package bonc.demopractice_allkinsoff.listrecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ListRecyclerActivity extends AppCompatActivity {
    @BindView(R.id.tvWorld) TextView mTvWorld;
    @BindView(R.id.lvList_Recycler)ListView mLvListRecycler;

    private String mTitle;
    private List<String> childList =null;
    private List<ListRecyclerBean> mGroupList = new ArrayList<>();
    private ListRecyclerAdapter mListRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_recycler);
        ButterKnife.bind(this);
        setData();
    }

    private void setData(){
        for (int i = 1; i < 11; i++){
            mTitle = "GroupTitle ：" + i;
            childList = new ArrayList<>();
            for (int j = 0; j < i; j++){
                childList.add("Child +" + j * j);
            }
            mGroupList.add(new ListRecyclerBean(mTitle, childList));
        }
        mTvWorld.setText(getClass().getName() + "：ListView和RecyclerView的组合体");
        mTvWorld.setTextSize(10);
        mListRecyclerAdapter = new ListRecyclerAdapter(mGroupList, this);
        mLvListRecycler.setAdapter(mListRecyclerAdapter);
    }
}
