package bonc.demopractice_allkinsoff.animaote_xml;

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
 * Created by chen1 on 2017/8/22.
 */

public class AdapterLayoutAnimate extends RecyclerView.Adapter<AdapterLayoutAnimate.LayoutAnimateViewHolder> {
    private List<String> mLayoutAnimate;
    private Context mContext;

    public AdapterLayoutAnimate(Context context, List<String> mLayoutAnimate) {
        this.mContext = context;
        this.mLayoutAnimate = mLayoutAnimate;
    }

    public void refreshAdapter(){
        notifyDataSetChanged();
    }

    @Override
    public LayoutAnimateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LayoutAnimateViewHolder(LayoutInflater.from(mContext).inflate(R.layout.adapter_layoutanimate, parent, false));
    }

    @Override
    public void onBindViewHolder(LayoutAnimateViewHolder holder, int position) {
        holder.mTvLayoutAnimateItem.setText(mLayoutAnimate.get(position));
    }

    @Override
    public int getItemCount() {
        return mLayoutAnimate == null ? 0 : mLayoutAnimate.size();
    }

    static class LayoutAnimateViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvLayoutAnimateItem)
        TextView mTvLayoutAnimateItem;

        LayoutAnimateViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
