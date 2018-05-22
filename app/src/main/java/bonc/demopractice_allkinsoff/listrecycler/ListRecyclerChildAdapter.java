package bonc.demopractice_allkinsoff.listrecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chenjie on 2017/4/24.
 * TODO：
 */

public class ListRecyclerChildAdapter extends RecyclerView.Adapter<ListRecyclerChildAdapter.ViewHolder> {
    private Context mContext;
    private List<String> childList;

    public ListRecyclerChildAdapter(List<String> childList, Context mContext) {
        this.mContext = mContext;
        this.childList = childList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.child_textview, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTvChild.setText(childList.get(position));
    }

    @Override
    public int getItemCount() {
        return childList == null ? 0 : childList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvChild) TextView mTvChild;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
