//package bonc.demopractice_allkinsoff.intent;
//
//import android.app.Dialog;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.net.Uri;
//import android.os.Bundle;
//import android.os.Environment;
//import android.provider.MediaStore;
//import android.support.v7.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import bonc.demopractice_allkinsoff.R;
//
//public class ImageActivity extends AppCompatActivity {
//    public static final int OPEN_CAMERA_FLAG = 1023;//打开相机的requestid
//    public static final int OPEN_ALBUM_FLAG = 130;//打开相册的requestid
//    public static final int CUT_PIC_FLAG = 520;//裁剪图片的requestid
//
//    private RelativeLayout mHeadViewRL;
//
//    //拍照文件的输出路径
//    private String mFilePath;
//    //裁剪图片的输出路径，intent无法传递大图（bitmap）,只能通过uri传递
//    private String mCropFilePath;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_image);
//
//        findViewById(R.id.rl_headphoto).setOnclickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDialog();
//            }
//        });
//
//        // 新建目录
//        String saveDir = Environment.getExternalStorageDirectory() + "/wyk/tmp/";
//        File dir = new File(saveDir);
//        if (!dir.exists()) dir.mkdirs();
//        String filename = "tmp" + String.valueOf(System.currentTimeMillis() + ".jpg");
//        mFilePath = saveDir + filename;
//        mCropFilePath = saveDir + "tmp.jpg";
//    }
//
//    private void showDialog() {
//        LayoutInflater inflater = LayoutInflater.from(this);
//        View alertView = inflater.inflate(R.layout.dialog_select_headphoto, null);
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        alertView.setLayoutParams(params);
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setView(alertView);
//
//        final Dialog dialog = builder.create();
//        dialog.show();
//
//        //拍照按钮
//        (alertView.findViewById(R.id.ll_camera)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//                openCamera();
//            }
//        });
//        //从相册选择按钮
//        (alertView.findViewById(R.id.ll_album)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//                openAlbum();
//            }
//        });
//        //取消按钮
//        (alertView.findViewById(R.id.ll_cancel)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//    }
//
//    //打开相机
//    private void openCamera() {
//        String saveDir = Environment.getExternalStorageDirectory() + "/ydl/tmp/";
//        // 新建目录
//        File dir = new File(saveDir);
//        if (!dir.exists()) dir.mkdirs();
//        String filename = "tmp" + String.valueOf(System.currentTimeMillis() + ".jpg");
//        File file = new File(saveDir, filename);
//        if (file.exists()) {
//            file.delete();
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        mFilePath = saveDir + filename;
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
//        startActivityForResult(intent, OPEN_CAMERA_FLAG);
//    }
//
//    //打开相册
//    private void openAlbum() {
//        Intent intent = new Intent(
//                Intent.ACTION_PICK,
//                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        intent.setType("image/*");
//        startActivityForResult(intent, OPEN_ALBUM_FLAG);
//    }
//
//    //裁剪图片方法实现
//    public void startPhotoZoom(Uri uri) {
//        Intent intent = new Intent("com.android.camera.action.CROP");
//        File file = new File(mCropFilePath);
//        if (file.exists()) {
//            file.delete();
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        intent.setDataAndType(uri, "image/*");
//        //下面这个crop=true是设置在开启的Intent中设置显示的VIEW可裁剪
//        intent.putExtra("crop", "true");
//        // aspectX aspectY 是宽高的比例
//        intent.putExtra("aspectX", 1);
//        intent.putExtra("aspectY", 1);
//        // outputX outputY 是裁剪图片宽高
//        intent.putExtra("outputX", 150);
//        intent.putExtra("outputY", 150);
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));//通过传递uri而不是bitmap，避免大图
//        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
//        intent.putExtra("noFaceDetection", true); // no face detection
//        intent.putExtra("return-data", false);
//        startActivityForResult(intent, CUT_PIC_FLAG);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK) {
//            switch (requestCode) {
//                case OPEN_CAMERA_FLAG://拍照获取照片
//                    File tempFile = new File(mFilePath);
//                    startPhotoZoom(Uri.fromFile(tempFile));
//                    break;
//                case OPEN_ALBUM_FLAG://从相册获取照片
//                    startPhotoZoom(data.getData());
//                    break;
//                case CUT_PIC_FLAG://裁剪完的照片
//                    if (mCropFilePath != null) {//避免裁剪后不满意点击取消后为空的情况
//                        handlerCutPic();
//                    }
//                    break;
//                default:
//                    break;
//            }
//        }
//    }
//
//    //处理裁剪完的照片
//    private void handlerCutPic() {
//        Bitmap bitmap = ImageUtil.getBitmap(mCropFilePath);
//        File file = new File(mCropFilePath);
//        try {
//            FileOutputStream stream = new FileOutputStream(file);
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//            sendHeadPhotoToServer(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//}
