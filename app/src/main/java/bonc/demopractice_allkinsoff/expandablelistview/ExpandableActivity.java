package bonc.demopractice_allkinsoff.expandablelistview;

import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

import bonc.demopractice_allkinsoff.R;
import bonc.demopractice_allkinsoff.application.BaseActivity;
import bonc.demopractice_allkinsoff.bean.ExpandableBean;
import bonc.demopractice_allkinsoff.bean.Group;
import butterknife.ButterKnife;

public class ExpandableActivity extends BaseActivity {
    List<Group> mGroupList = new ArrayList<>();
    List<ExpandableBean> mChildItems;
    List<List<ExpandableBean>> ChildList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);
        ButterKnife.bind(this);
    }

    public void iniData() {
        mGroupList.add(new Group("东风系列"));
        mGroupList.add(new Group("歼击系列"));
        mGroupList.add(new Group("预警系列"));
        mGroupList.add(new Group("护卫系列"));

        mChildItems = new ArrayList<>();
        mChildItems.add(new ExpandableBean(R.mipmap.launcher01, "东风 - 5B"));
        mChildItems.add(new ExpandableBean(R.mipmap.launcher11, "东风 - 15"));
        mChildItems.add(new ExpandableBean(R.mipmap.launcher12, "东风 - 16"));
        mChildItems.add(new ExpandableBean(R.mipmap.launcher16, "东风 - 21"));
        mChildItems.add(new ExpandableBean(R.mipmap.launcher21, "东风 - 21D"));
        mChildItems.add(new ExpandableBean(R.mipmap.launcher32, "东风 - 26"));
        mChildItems.add(new ExpandableBean(R.mipmap.launcher34, "东风 - 31"));
        mChildItems.add(new ExpandableBean(R.mipmap.launcher37, "东风 - 41"));
        ChildList.add(mChildItems);

        mChildItems = new ArrayList<>();
        mChildItems.add(new ExpandableBean(R.mipmap.launcher40, "J - 10"));
        mChildItems.add(new ExpandableBean(R.mipmap.launcher43, "J - 10D"));
        mChildItems.add(new ExpandableBean(R.mipmap.launcher46, "J - 11"));
        mChildItems.add(new ExpandableBean(R.mipmap.launcher48, "J - 15"));
        mChildItems.add(new ExpandableBean(R.mipmap.launcher01, "J - 20"));
        mChildItems.add(new ExpandableBean(R.mipmap.launcher11, "J - 31"));
        ChildList.add(mChildItems);

        mChildItems = new ArrayList<>();
        mChildItems.add(new ExpandableBean(R.mipmap.launcher01, "空警 - 200"));
        mChildItems.add(new ExpandableBean(R.mipmap.launcher11, "空警 - 500"));
        mChildItems.add(new ExpandableBean(R.mipmap.launcher12, "空警 - 2000"));
        mChildItems.add(new ExpandableBean(R.mipmap.launcher16, "空警 - 3000"));
        ChildList.add(mChildItems);

        mChildItems = new ArrayList<>();
        mChildItems.add(new ExpandableBean(R.mipmap.launcher40, "054A导弹驱逐舰"));
        mChildItems.add(new ExpandableBean(R.mipmap.launcher43, "054B导弹驱逐舰"));
        mChildItems.add(new ExpandableBean(R.mipmap.launcher46, "054C导弹驱逐舰"));
        mChildItems.add(new ExpandableBean(R.mipmap.launcher48, "054D导弹驱逐舰"));
        mChildItems.add(new ExpandableBean(R.mipmap.launcher16, "055导弹驱逐舰"));
        ChildList.add(mChildItems);

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.Expandable);
        ExpandableAdapter expandableAdapter = new ExpandableAdapter(this, mGroupList, ChildList);
        //        mExpandable.setAdapter(expandableAdapter);
        expandableListView.setAdapter(expandableAdapter);
    }
}
