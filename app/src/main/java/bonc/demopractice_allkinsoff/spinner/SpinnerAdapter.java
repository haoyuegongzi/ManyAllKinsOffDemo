package bonc.demopractice_allkinsoff.spinner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import bonc.demopractice_allkinsoff.R;

/**
 * Created by chen1 on 2017/6/19.
 */

public class SpinnerAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> spinnerList;

    public SpinnerAdapter(Context mContext, List<String> spinnerList){
        this.mContext = mContext;
        this.spinnerList = spinnerList;
    }

    @Override
    public int getCount() {
        return spinnerList == null ? 0 : spinnerList.size();
    }

    @Override
    public Object getItem(int i) {
        return spinnerList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(holder == null){
            holder = new ViewHolder();
            view = View.inflate(mContext, R.layout.spinner, null);
            holder.text1 = (TextView) view.findViewById(R.id.text1);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.text1.setText(spinnerList.get(i));
        return view;
    }

    class ViewHolder{
        TextView text1;
    }
}
