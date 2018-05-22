package bonc.demopractice_allkinsoff.viewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by chen1 on 2017/9/27.
 */

public class LoopPagerAdapetr extends PagerAdapter {

    private List<View> mViewList;
    private int size = 0;

    public LoopPagerAdapetr(List<View> mViews){
        mViewList = mViews;
        size = mViewList.size();
    }

    @Override
    public int getCount() {
        return mViewList == null ? 0 : size;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mViewList.get(position % size));
        return mViewList.get(position % size);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
