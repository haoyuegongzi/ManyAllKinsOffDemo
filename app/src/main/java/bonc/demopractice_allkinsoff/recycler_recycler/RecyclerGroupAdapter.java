package bonc.demopractice_allkinsoff.recycler_recycler;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bonc.demopractice_allkinsoff.R;
import bonc.demopractice_allkinsoff.listrecycler.ListRecyclerBean;
import bonc.demopractice_allkinsoff.listrecycler.ListRecyclerChildAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chenjie on 2017/4/24.
 * TODO：
 */

public class RecyclerGroupAdapter extends RecyclerView.Adapter<RecyclerGroupAdapter.GroupViewHolder> {
    private Context mContext;
    private List<ListRecyclerBean> mGroupList;
    private ListRecyclerChildAdapter lrvChildAdapter;

    public RecyclerGroupAdapter(Context mContext, List<ListRecyclerBean> mGroupList) {
        this.mContext = mContext;
        this.mGroupList = mGroupList;
    }

    @Override
    public GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GroupViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recycler_group, parent, false));
    }

    @Override
    public void onBindViewHolder(GroupViewHolder holder, int position) {
        holder.mTvGroup.setText(mGroupList.get(position).getTitle());
        holder.mRvChildView.setLayoutManager(new GridLayoutManager(mContext, 3));

        lrvChildAdapter = new ListRecyclerChildAdapter(mGroupList.get(position).getChild(), mContext);
        holder.mRvChildView.setAdapter(lrvChildAdapter);
    }

    @Override
    public int getItemCount() {
        return mGroupList == null ? 0 : mGroupList.size();
    }

    static class GroupViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvGroup) TextView mTvGroup;
        @BindView(R.id.rvChildView) RecyclerView mRvChildView;

        public GroupViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
