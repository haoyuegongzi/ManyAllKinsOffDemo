package bonc.demopractice_allkinsoff.recycler_recycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bonc.demopractice_allkinsoff.R;
import bonc.demopractice_allkinsoff.listrecycler.ListRecyclerBean;

public class Recycler_RecyclerActivity extends AppCompatActivity {
    private RecyclerView rvGroup;
    private TextView tvWorld;

    /*****************************************************************************/
    private String mTitle;
    private List<String> childList =null;
    private List<ListRecyclerBean> mGroupList = new ArrayList<>();
    private RecyclerGroupAdapter rvGroupAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler__recycler);
        dealData();
    }

    private void dealData(){
        tvWorld = (TextView) findViewById(R.id.tvWorld);
        rvGroup = (RecyclerView) findViewById(R.id.rvGroup);
        for (int i = 1; i < 11; i++){
            mTitle = "GroupTitle ：" + i;
            childList = new ArrayList<>();
            for (int j = 1; j < (i+1); j++){
                childList.add("Child +" + j * j);
            }
            mGroupList.add(new ListRecyclerBean(mTitle, childList));
        }
        tvWorld.setText(getClass().getName() + "\n" + "：RecyclerView和RecyclerView的组合体");
        tvWorld.setTextSize(10);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvGroup.setLayoutManager(layoutManager);
        rvGroupAdapter = new RecyclerGroupAdapter(this, mGroupList);
        rvGroup.setAdapter(rvGroupAdapter);
    }
}
