package bonc.demopractice_allkinsoff.intent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static bonc.demopractice_allkinsoff.R.id.ivIntent;

public class IntentActionActivity extends AppCompatActivity {
     final int REQUEST_PERMISSION_CAMERA_CODE = 0xf2;


    @BindView(R.id.btCall)
    Button mBtCall;
    @BindView(R.id.btMap)
    Button mBtMap;
    @BindView(R.id.btHtml)
    Button mBtHtml;
    @BindView(R.id.btSendEmail)
    Button mBtSendEmail;
    @BindView(R.id.btCalendar)
    Button mBtCalendar;
    @BindView(R.id.btQuery)
    Button mBtQuery;
    @BindView(R.id.btForResult)
    Button mBtForResult;
    @BindView(ivIntent)
    ImageView mIvItent;
    @BindView(R.id.btTakePictrue)
    Button mBtTakePictrue;
    @BindView(R.id.btPhotoAlbum)
    Button mBtPhotoAlbum;
    @BindView(R.id.btPhotoDeal)
    Button mBtPhotoDeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btCall, R.id.btMap, R.id.btHtml, R.id.btSendEmail, R.id.btCalendar,
              R.id.btQuery, R.id.btForResult, R.id.btTakePictrue, R.id.btPhotoAlbum,
              R.id.btPhotoDeal})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btCall:
                Uri call = Uri.parse("tel:17628699611");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, call);
                startActivity(callIntent);
                break;
            case R.id.btMap:
                Uri map = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
                Uri location = Uri.parse("geo:37.422219,-122.08364?z=14");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(mapIntent);
                break;
            case R.id.btHtml:
                Uri Html = Uri.parse("http://www.ifeng.com");
                Intent htmlIntent = new Intent(Intent.ACTION_VIEW, Html);
                startActivity(htmlIntent);
                break;
            case R.id.btSendEmail:
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("message/rfc822");//邮件的编码格式
                //第一个账号是发件人，所有的邮件账号都会被添加进收件人里面去
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"303884862@qq.com", "chen126jie@163.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hi, This is a test mail..");//邮件主题
                //邮件内容
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Did you get this mail? if so please reply back");
                //选择客户端时的弹框提示语
                startActivity(Intent.createChooser(emailIntent, "选择一个邮件客户端"));
                break;
            case R.id.btCalendar:
                Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
                startActivity(calendarIntent);
                break;
            case R.id.btQuery:
                Intent queryIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
                startActivity(queryIntent);
                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> resolveInfo = packageManager.queryIntentActivities(queryIntent, 0);
                boolean isResponse = resolveInfo.isEmpty();
                Log.i("TAG", "onClick: isResponse ===" + isResponse);
                break;
            case R.id.btForResult:
                //读取联系人并打电话，23之后的SDK需要申请权限
                Intent intentContent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
                intentContent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(intentContent, forResultCode);
                break;
            case R.id.btTakePictrue:
                PackageManager pManager = getPackageManager();
                //检查设备是否拥有摄像头
                boolean isCamera = pManager.hasSystemFeature(PackageManager.FEATURE_CAMERA);
                if(isCamera){
                    int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
                    boolean hasPermission = (permission == PackageManager.PERMISSION_GRANTED);
                    if (hasPermission) {
                        isCamera();
                    }else {
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_PERMISSION_CAMERA_CODE);
                    }
                }
                break;
            case R.id.btPhotoAlbum:
                if(getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
                    Intent albumIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if(albumIntent.resolveActivity(getPackageManager()) != null){
                        File photoFile = createImage();
                        if(photoFile != null){
                            albumIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                            startActivityForResult(albumIntent, photoAlbumCode);
                        }
                    }
                }
                break;
            case R.id.btPhotoDeal:


                break;
        }
    }

    private void isCamera(){
        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intentCamera, forCameraCode);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_PERMISSION_CAMERA_CODE){
            if(grantResults.length >= 1){
                int cameraResult = grantResults[0];//相机权限
                boolean hasPermission = cameraResult == PackageManager.PERMISSION_GRANTED;
                if (hasPermission) {
                    isCamera();
                }else {
                    Toast.makeText(IntentActionActivity.this, "您未授予使用照相机的权限", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    String currentImagePath;
    private File createImage() {
        File image = null;
        try{
            String stampTime = new SimpleDateFormat("yyMMdd_hhmmss").format(new Date());
            String imageName = stampTime + ".JPGE";
            File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            image = File.createTempFile(imageName, "jpg", storageDir);
            currentImagePath = "file:" + image.getAbsolutePath();
        }catch (IOException e){
            e.printStackTrace();
        }
        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == forResultCode){
                Uri contacts = data.getData();
                String[] prject = {ContactsContract.CommonDataKinds.Phone.NUMBER};
                Cursor cursor = getContentResolver().query(contacts, prject, null, null, null);
                cursor.moveToFirst();
                int colum = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(colum);
                Log.i("TAG", "onActivityResult: number ===" + number);
                Uri callUri = Uri.parse("tel:" + number);
                Intent intentCall = new Intent(Intent.ACTION_DIAL, callUri);
                startActivity(intentCall);
            }
            if(requestCode == forCameraCode){//保存缩略图
                Bundle bundle = data.getExtras();
                Bitmap bitmap = (Bitmap) bundle.get("data");
                mIvItent.setImageBitmap(bitmap);
            }
            if(requestCode == photoAlbumCode){
                Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                File f = new File(currentImagePath);
                Uri contentUri = Uri.fromFile(f);
                mediaScanIntent.setData(contentUri);
                this.sendBroadcast(mediaScanIntent);
                Log.i("TAG", "onActivityResult: photoAlbumCode ==" + photoAlbumCode);
            }
        }
    }

    static int forResultCode = 100;
    static int forCameraCode = 200;
    static int photoAlbumCode = 300;
}
