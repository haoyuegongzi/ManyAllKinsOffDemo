package bonc.demopractice_allkinsoff.customWidget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by chen1 on 2017/10/11.
 * 为什么要复写onFocusChanged()方法，那是因为如果不写，在Textview 获得焦点后，再失去焦点时字就会停止“跑”了，
 * 所以如果想让它一直跑下去就复写onFocusChanged(),并且里面什么也不做（主要是不能调用父类的方法）
 */

public class MarqueeText extends TextView {
    public MarqueeText(Context con) {
        super(con);
    }
    public MarqueeText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MarqueeText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean isFocused() {
        return true;
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {

    }
}
