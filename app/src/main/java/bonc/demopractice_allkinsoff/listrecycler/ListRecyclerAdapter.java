package bonc.demopractice_allkinsoff.listrecycler;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chenjie on 2017/4/24.
 * TODO：
 */

public class ListRecyclerAdapter extends BaseAdapter {
    private Context mContext;
    private List<ListRecyclerBean> mGroupList;
    public ListRecyclerAdapter(List<ListRecyclerBean> mGroupList, Context mContext) {
        this.mContext = mContext;
        this.mGroupList = mGroupList;
    }

    @Override
    public int getCount() {
        return mGroupList.size();
    }

    @Override
    public Object getItem(int i) {
        return mGroupList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.childview, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.mTvTitle.setText(mGroupList.get(i).getTitle());
        holder.mRvChild.setLayoutManager(new GridLayoutManager(mContext, 3));
        holder.mRvChild.setAdapter(new ListRecyclerChildAdapter(
                        mGroupList.get(i).getChild(), mContext));
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.tvTitle) TextView mTvTitle;
        @BindView(R.id.rvChild)RecyclerView mRvChild;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
