package bonc.demopractice_allkinsoff.scrollview;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bonc.demopractice_allkinsoff.R;
import bonc.demopractice_allkinsoff.override_recycler_manager.FullyLinearLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VerticalScrollViewActivity extends AppCompatActivity {

    @BindView(R.id.ivScroll)
    ImageView mIvScroll;
    @BindView(R.id.ivScrollImage)
    ImageView mIvScrollImage;
    @BindView(R.id.ivScrollImage02)
    ImageView mIvScrollImage02;

    @BindView(R.id.tvLast)
    TextView mTvLast;
    @BindView(R.id.tvNext)
    TextView mTvNext;
    @BindView(R.id.rvVerticalRecycler)
    RecyclerView mRvVerticalRecycler;



    private List<Drawable> mDrawableList;
    private List<String> mStringList;
    private RecyclerAdapter mRecyclerAdapter;
    private int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_scroll_view);
        ButterKnife.bind(this);
        addParams();
    }

    private void addParams(){
        mDrawableList = new ArrayList<>();
        mStringList = new ArrayList<>();
        mDrawableList.add(getDrawable(R.drawable.spring01));
        mDrawableList.add(getDrawable(R.drawable.spring02));
        mDrawableList.add(getDrawable(R.drawable.spring03));
        mDrawableList.add(getDrawable(R.drawable.spring04));
        mDrawableList.add(getDrawable(R.drawable.spring05));
        mDrawableList.add(getDrawable(R.drawable.spring06));
        mDrawableList.add(getDrawable(R.drawable.spring07));
        mDrawableList.add(getDrawable(R.drawable.spring08));
        mDrawableList.add(getDrawable(R.drawable.spring09));
        mDrawableList.add(getDrawable(R.drawable.spring10));

        for (int i = 0; i < 50; i++){
            mStringList.add("Scroll和RecyclerView滑动冲突Item " + i);
        }

        FullyLinearLayoutManager layoutManager = new FullyLinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        FullyGridLayoutManager layoutManager = new FullyGridLayoutManager(this, 3);
//        layoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        mRvVerticalRecycler.setLayoutManager(layoutManager);

        mRecyclerAdapter = new RecyclerAdapter(VerticalScrollViewActivity.this, mStringList);
        mRvVerticalRecycler.setAdapter(mRecyclerAdapter);
    }

    @OnClick({R.id.tvLast, R.id.tvNext})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvLast:
                index--;
                if(index < 0){
                    index = mDrawableList.size() - 1;
                }
                break;
            case R.id.tvNext:
                index++;
                if(index > mDrawableList.size() - 1){
                    index = 0;
                }
                break;
        }
        mIvScroll.setImageDrawable(mDrawableList.get(index));
        mIvScrollImage.setImageDrawable(mDrawableList.get(index));
        mIvScrollImage02.setImageDrawable(mDrawableList.get(index));
    }



}
