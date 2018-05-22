package bonc.demopractice_allkinsoff.popup;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chen1 on 2017/11/1.
 * TO DO:
 */

public class PopupAdapter extends RecyclerView.Adapter<PopupAdapter.ViewHolder> {
    private Context mContext;
    private List<PopupBean> popupList;


    public PopupAdapter(Context mContext, List<PopupBean> popupList) {
        this.mContext = mContext;
        this.popupList = popupList;
    }

    public void refreshAdapter(List<PopupBean> popupList){
        this.popupList = popupList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.adapter_popup_test, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTvTitle.setText(popupList.get(position).title);
        holder.mIvState.setImageDrawable(popupList.get(position).state);
    }

    @Override
    public int getItemCount() {
        return popupList == null ? 0 : popupList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tvTitle)
        TextView mTvTitle;
        @BindView(R.id.ivState)
        ImageView mIvState;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
