package bonc.demopractice_allkinsoff.popup;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

import bonc.demopractice_allkinsoff.R;

/**
 * Created by chen1 on 2017/11/1.
 * TO DO:
 */

public class TestPopupWindow extends PopupWindow {
    RecyclerView mRvPopupWindow;

    private View popupView;
    private Activity mActivity;
    private List<PopupBean> popupList;
    private PopupAdapter mAdapter;

    public TestPopupWindow(Activity activity) {
        mActivity = activity;
        popupView = LayoutInflater.from(activity).inflate(R.layout.popup_window_test, null);
        this.setContentView(popupView);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setBackgroundDrawable(new ColorDrawable(0x00000000));
        this.setFocusable(true);
        this.setTouchable(true);
        this.setOutsideTouchable(true);
        mRvPopupWindow = (RecyclerView) popupView.findViewById(R.id.rvPopupWindow);
        addParms();
        loadData();
    }

    private void loadData(){
        mAdapter = new PopupAdapter(mActivity, popupList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvPopupWindow.setLayoutManager(layoutManager);
        mRvPopupWindow.setAdapter(mAdapter);
    }

    private void addParms(){
        popupList = new ArrayList<>();
        popupList.add(new PopupBean("晴", mActivity.getDrawable(R.mipmap.shine)));
        popupList.add(new PopupBean("雨", mActivity.getDrawable(R.mipmap.runing)));
        popupList.add(new PopupBean("雪", mActivity.getDrawable(R.mipmap.snow)));
        popupList.add(new PopupBean("雾", mActivity.getDrawable(R.mipmap.fog)));
        popupList.add(new PopupBean("阴", mActivity.getDrawable(R.mipmap.cloudy)));
    }

    @Override
    public void showAsDropDown(View anchor) {
        super.showAsDropDown(anchor);

    }

    @Override
    public void showAsDropDown(View anchor, int xoff, int yoff) {
        super.showAsDropDown(anchor, xoff, yoff);
    }

    /**
     * @param anchor:popupWindow相对于的目标控件。
     * @param xoff:popupWindow相对于原点X轴上的位置。x为正popupWindow向右，x为负popupWindow向左。
     * @param yoff:popupWindow相对于原点y轴上的位置。y为正popupWindow向上，y为负popupWindow向下。
     * @param gravity:
     */
    @Override
    public void showAsDropDown(View anchor, int xoff, int yoff, int gravity) {
        super.showAsDropDown(anchor, xoff, yoff, gravity);
    }

    /**
     * @param parent:父布局类，一般都是方法体中的参数view。
     * @param gravity:popupWindow在父布局中出现的大致位置。常见的有 Gravity.NO_GRAVITY,
     *               Gravity.LEFT,Gravity.RIGHT,Gravity.TOP,Gravity.BOTTOM。
     * @param x:以第二个参数gravity指点的位置为原点，popupWindow相对于原点X轴上的位置。
     *          x为正,popupWindow向右移动;x为负,popupWindow向左移动。
     * @param y:同X差不多，指的是y轴上的位置。y为正popupWindow向上，y为负popupWindow向下。
     *
     *         parent.getLocationInWindow(location)获得parent在屏幕上的坐标，
     *         其中location是一个大小为2的int数组，第一个就是parent的左上角x坐标，第二个就是parent的左上角y坐标。
     */
    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        super.showAtLocation(parent, gravity, x, y);
    }
}
