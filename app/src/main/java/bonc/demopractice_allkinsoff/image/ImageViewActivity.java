package bonc.demopractice_allkinsoff.image;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImageViewActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    private final int SELECT_TAG = 1;
    private final int CUT_TAG = 2;
    private final int minWidth = 100;
    private Bitmap bitSelect;
    private Bitmap bitCut;
    private Bitmap bitmapTranslation;
    private Matrix mMatrix = new Matrix();


    @BindView(R.id.btSelect)
    Button mBtSelect;
    @BindView(R.id.btCut)
    Button mBtCut;
    @BindView(R.id.ivDisplayImage)
    ImageView mIvDisplayImage;
    @BindView(R.id.ivImage00)
    ImageView mIvImage00;
    @BindView(R.id.ivImage01)
    ImageView mIvImage01;
    @BindView(R.id.ivImage02)
    ImageView mIvImage02;
    @BindView(R.id.ivImage03)
    ImageView mIvImage03;
    @BindView(R.id.ivImage04)
    ImageView mIvImage04;
    @BindView(R.id.ivImage05)
    ImageView mIvImage05;
    @BindView(R.id.ivImage06)
    ImageView mIvImage06;
    @BindView(R.id.scrollView)
    ScrollView mScrollView;
    @BindView(R.id.ivScale)
    ImageView mIvScale;
    @BindView(R.id.tvScale)
    TextView mTvScale;
    @BindView(R.id.sbScale)
    SeekBar mSbScale;
    @BindView(R.id.tvTranslation)
    TextView mTvTranslation;
    @BindView(R.id.sbTranslatio)
    SeekBar mSbTranslatio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        ButterKnife.bind(this);
        mSbScale.setOnSeekBarChangeListener(this);
        mSbTranslatio.setOnSeekBarChangeListener(this);
        chengedImageViewSize();
    }

    private void chengedImageViewSize(){
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        mSbScale.setMax(dm.widthPixels - minWidth);
    }

    @OnClick({R.id.btSelect, R.id.btCut})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btSelect:
                //android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_UR:从内容提供者provider的媒体存储库下图片指定的路径去提取
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, SELECT_TAG);
                break;
            case R.id.btCut:
                Intent intent1 = getImageClipIntent();
                startActivityForResult(intent1, CUT_TAG);
                break;
        }
    }

    public Intent getImageClipIntent() {
        //这里值为空null，表示没有指定URL
        Intent in = new Intent(Intent.ACTION_GET_CONTENT, null);
        //实现图片的裁剪，必须设置图片的属性和大小
        in.setType("image/*");//表示任意格式的图片
        in.putExtra("crop", "true");//表示可以手动选择裁剪区域（手指down事件和up事件对应的两个点所形成的矩形区域）
        in.putExtra("aspectX", 1);//表示剪切框的比例，通常为1:1
        in.putExtra("aspectY", 1);
        in.putExtra("outputX", 80);//指定输出图片的的大小
        in.putExtra("outputY", 80);
        in.putExtra("return-data", true);//有返回值
        return in;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            //过程回顾：首先获取图片的路径，即Uri对象，然后获取屏幕尺寸；然后将获取到的图片对象（流）转化为bitmap对象；
            //再根据屏幕size对其进行适配。
            if (requestCode == SELECT_TAG) {
                Uri uri = data.getData();//获取图片的路径
                setBtSelect(uri);
            }
            if (requestCode == CUT_TAG) {
                bitCut = data.getParcelableExtra("data");//return-
                mIvDisplayImage.setImageBitmap(bitCut);
                Log.i("TAG", "onActivityResult: 执行了这个方法");
            }
        }
    }

    private void setBtSelect(Uri uri) {
        int width = getWindowManager().getDefaultDisplay().getWidth();//获取屏幕的宽度
        int height = getWindowManager().getDefaultDisplay().getHeight() / 2;//获取屏幕的高度
        Log.i("TAG", "setBtSelect: width ===" + width + "——>>> height ===" + height);
        try {
            BitmapFactory.Options factory = new BitmapFactory.Options();//实现对图片裁剪的一个匿名内部类，
            factory.inJustDecodeBounds = true;//为true，表示允许查询图片不是按照像素分配给内存的
            //讲一个流转化为bitmap对象
            bitSelect = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null, factory);
            //根据手机屏幕尺寸，调整图片的宽高（图片与屏幕适配）
            //如果hRadio和wRadio大于1，表示图片本身的宽高大于手机屏幕的宽高，这是就要将图片缩放的手机屏幕的尺寸（宽高比例也行）
            int hRadio = (int) Math.ceil(factory.outHeight / height);
            int wRadio = (int) Math.ceil(factory.outWidth / width);
            if (hRadio > 1 || wRadio > 1) {
                if (hRadio > wRadio) {
                    factory.inSampleSize = hRadio;
                } else {
                    factory.inSampleSize = wRadio;
                }
            }
            factory.inJustDecodeBounds = false;
            bitSelect = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null, factory);
            mIvDisplayImage.setImageBitmap(bitSelect);
            Log.i("TAG", "onActivityResult: 执行了选择图片");
        } catch (Exception e) {
            Log.i("TAG", "setBtSelect: e ===" + e);
            e.printStackTrace();
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar.getId() == R.id.sbScale){
            int newWidth = progress + minWidth;
            int newHeight = (int)(newWidth / 3 *2);
            mIvScale.setLayoutParams(new LinearLayout.LayoutParams(newWidth, newHeight));
            mTvScale.setText("图像宽度 ===" + newWidth + "————>>>图像高度 ===" + newHeight);
            Log.i("TAG", "onProgressChanged: 图像宽度 ===" + newWidth + "————>>>图像高度 ===" + newHeight);
        }
        if (seekBar.getId() == R.id.sbTranslatio){
            bitmapTranslation = ((BitmapDrawable)getResources().getDrawable(R.mipmap.sunlu40)).getBitmap();
            mMatrix.setRotate(progress);
            bitmapTranslation = Bitmap.createBitmap(bitmapTranslation, 0, 0,
                    bitmapTranslation.getWidth(), bitmapTranslation.getHeight(), mMatrix, true);
            mIvScale.setImageBitmap(bitmapTranslation);
            mTvTranslation.setText("旋转了：" + progress + " °");
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
