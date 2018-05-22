package bonc.demopractice_allkinsoff.imageswicher;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImageSwicherActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {
    @BindView(R.id.ivDisplayImage)
    ImageView mIvDisplayImage;
    private int index = 0;
    private List<Drawable> mDrawableList;

    @BindView(R.id.isSwicher)
    ImageSwitcher mIsSwicher;
    @BindView(R.id.btNext)
    Button mBtNext;
    @BindView(R.id.btForWard)
    Button mBtForWard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_swicher);
        ButterKnife.bind(this);
        mDrawableList = new ArrayList<>();
        addListData();
    }

    @Override
    public View makeView() {
        return new ImageView(ImageSwicherActivity.this);
    }

    @OnClick({R.id.btNext, R.id.btForWard})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btNext:
                index--;
                if (index < 0) {
                    index = mDrawableList.size() - 1;
                }
                break;
            case R.id.btForWard:
                index++;
                if (index > mDrawableList.size() - 1) {
                    index = 0;
                }
                break;
        }
        mIsSwicher.setImageDrawable(mDrawableList.get(index));
        mIvDisplayImage.setImageDrawable(mDrawableList.get(index));
    }

    private void addListData() {
        mIsSwicher.setFactory(this);
        mDrawableList.add(getDrawable(R.mipmap.sunlu12));
        mDrawableList.add(getDrawable(R.mipmap.sunlu13));
        mDrawableList.add(getDrawable(R.mipmap.sunlu14));
        mDrawableList.add(getDrawable(R.mipmap.sunlu15));
        mDrawableList.add(getDrawable(R.mipmap.sunlu22));
        mDrawableList.add(getDrawable(R.mipmap.sunlu24));
        mDrawableList.add(getDrawable(R.mipmap.sunlu40));
        mDrawableList.add(getDrawable(R.mipmap.sunlu48));
        mDrawableList.add(getDrawable(R.mipmap.shuchang));
        mDrawableList.add(getDrawable(R.mipmap.view01));
        mDrawableList.add(getDrawable(R.mipmap.view02));
        mDrawableList.add(getDrawable(R.mipmap.view03));

        if (mDrawableList.size() > 0) {
            mIsSwicher.setImageDrawable(mDrawableList.get(index));
            mIvDisplayImage.setImageDrawable(mDrawableList.get(index));
        }
    }
}
