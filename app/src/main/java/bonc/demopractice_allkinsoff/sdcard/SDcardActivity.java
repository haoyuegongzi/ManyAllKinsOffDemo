package bonc.demopractice_allkinsoff.sdcard;

import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.DecimalFormat;

import bonc.demopractice_allkinsoff.R;

public class SDcardActivity extends AppCompatActivity {
    private Button myButton;
    ProgressBar myBar;
    TextView myTextView;
    @Override
    public
    void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdcard);
        findView();
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick(View arg0) {
                getSize();
            }
        });
    }
    void findView(){
        myButton = (Button)findViewById(R.id.Button01);
        myBar = (ProgressBar)findViewById(R.id.myProgressBar);
        myTextView = (TextView)findViewById(R.id.myTextView);
    }
    void getSize(){
        myTextView.setText("");
        myBar.setProgress(0);
        //判断是否有插入存储卡
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            File path =Environment.getExternalStorageDirectory();
            //取得sdcard文件路径
            StatFs statfs=new StatFs(path.getPath());
            //获取block的SIZE
            long blocSize=statfs.getBlockSize();
            //获取BLOCK数量
            long totalBlocks=statfs.getBlockCount();
            //己使用的Block的数量
            long availaBlock=statfs.getAvailableBlocks();
            String[] total=filesize(totalBlocks*blocSize);
            String[] availale=filesize(availaBlock*blocSize);
            //设置进度条的最大值
            int maxValue=Integer.parseInt(availale[0]) * myBar.getMax()/Integer.parseInt(total[0]);
            myBar.setProgress(maxValue);
            String Text="总共："+total[0]+total[1]+"/n" +"可用:"+availale[0]+availale[1];
            myTextView.setText(Text);
        }else if( !Environment.getExternalStorageState().equals(Environment.MEDIA_REMOVED)){
            Toast.makeText(SDcardActivity.this, "没有sdCard", Toast.LENGTH_SHORT).show();
        }
    }
    //返回数组，下标1代表大小，下标2代表单位 KB/MB
    String[] filesize(long size){
        String str="";
        if(size>=1024){
            str="KB";
            size/=1024;
            if(size>=1024){
                str="MB";
                size/=1024;
            }
        }
        DecimalFormat formatter=new DecimalFormat();
        formatter.setGroupingSize(3);
        String result[] =new String[2];
        result[0]=formatter.format(size);
        result[1]=str;
        return result;
    }
}
