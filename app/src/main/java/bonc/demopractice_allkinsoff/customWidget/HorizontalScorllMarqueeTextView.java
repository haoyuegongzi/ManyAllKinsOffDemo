package bonc.demopractice_allkinsoff.customWidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import bonc.demopractice_allkinsoff.R;

/**
 * Created by chen1 on 2017/10/11.
 * 利用HorizontalScrollView控件的特性，里面加个TextView，通过定时器让HorizontalScrollView循环滑动，达到跑马灯效果。
 */

public class HorizontalScorllMarqueeTextView extends HorizontalScrollView implements Runnable {
    int currentScrollX = 0;// 当前滚动的位置
    TextView tv;

    public HorizontalScorllMarqueeTextView(Context context) {
        super(context);
        initView(context);
    }

    public HorizontalScorllMarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public HorizontalScorllMarqueeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }

    void initView(Context context) {
        View v = LayoutInflater.from(context).inflate(R.layout.horizontalscorll_marquee_textview, null);
        tv = (TextView) v.findViewById(R.id.tvCustomMarqueeTextView);
        this.addView(v);
    }

    public void setText(String text) {
        tv.setText(text);
        startScroll();
    }

    private void startScroll() {
        this.removeCallbacks(this);
        post(this);
    }

    @Override
    public void run() {
        currentScrollX++;// 滚动速度
        scrollTo(currentScrollX, 0);
        if (currentScrollX >= tv.getWidth()) {
            scrollTo(0, 0);
            currentScrollX = 0;
        }
        postDelayed(this, 50);
    }
}
