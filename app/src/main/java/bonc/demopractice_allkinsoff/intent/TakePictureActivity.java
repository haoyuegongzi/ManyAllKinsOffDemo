package bonc.demopractice_allkinsoff.intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;

public class TakePictureActivity extends AppCompatActivity {
    @BindView(R.id.btPhotoDeal)
    Button mBtPhotoDeal;
    @BindView(R.id.ivIntent)
    ImageView mIvIntent;


    private final int OPEN_CAMERA = 100;
    private final int OPEN_PHOTO_ALBUM = 200;
    private final int CUT_PHOTO = 300;

    private String takeImagePath;
    private String cutImagePath;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_picture);


    }


}
