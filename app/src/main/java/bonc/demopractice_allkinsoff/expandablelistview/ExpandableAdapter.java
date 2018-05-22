package bonc.demopractice_allkinsoff.expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bonc.demopractice_allkinsoff.R;
import bonc.demopractice_allkinsoff.bean.ExpandableBean;
import bonc.demopractice_allkinsoff.bean.Group;

/**
 * Created by chenjie on 2017/4/13.
 * TODO：
 */

public class ExpandableAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private List<Group> mGroupList;
    private List<List<ExpandableBean>> ChildList;

    public ExpandableAdapter(Context mContext, List<Group> mGroupList, List<List<ExpandableBean>> ChildList) {
        this.mContext = mContext;
        this.mGroupList = mGroupList;
        this.ChildList = ChildList;
    }

    @Override
    public int getGroupCount() {
        return mGroupList.size();
    }

    @Override
    public int getChildrenCount(int childPosition) {
        return ChildList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return ChildList.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View view, ViewGroup viewGroup) {
        ViewHolderGroup group = null;
        if(group == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.expandable_group, viewGroup, false);
            group = new ViewHolderGroup();
            group.mTvGroup = (TextView) view.findViewById(R.id.tvGroup);
            view.setTag(group);
        }else{
            group = (ViewHolderGroup) view.getTag();
        }
        group.mTvGroup.setText(mGroupList.get(groupPosition).Value);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View view, ViewGroup viewGroup) {
        ViewHolderChild child = null;
        if(child == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.expandable_child, viewGroup, false);
            child = new ViewHolderChild();
            child.mIvIcon = (ImageView) view.findViewById(R.id.ivIcon);
            child.mTvChild = (TextView) view.findViewById(R.id.tvChild);
           view.setTag(child);
        }else{
            child = (ViewHolderChild) view.getTag();
        }
        child.mIvIcon.setImageResource(ChildList.get(groupPosition).get(childPosition).id);
        child.mTvChild.setText(ChildList.get(groupPosition).get(childPosition).name);
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class ViewHolderGroup {
//        @InjectView(R.id.tvGroup)
        TextView mTvGroup;

//        ViewHolderGroup(View view) {
//            ButterKnife.inject(mContext, view);
//        }
    }

    class ViewHolderChild {
//        @InjectView(R.id.ivIcon)
        ImageView mIvIcon;
//        @InjectView(R.id.tvChild)
        TextView mTvChild;

//        ViewHolderChild(View view) {
//            ButterKnife.inject(mContext, view);
//        }
    }
}
