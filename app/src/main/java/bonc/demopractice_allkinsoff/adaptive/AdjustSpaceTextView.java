package bonc.demopractice_allkinsoff.adaptive;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

/**
 * Created by chen1 on 2017/10/31.
 * TO DO: 操作canvas和mPaint的单位都是px
 */

public class AdjustSpaceTextView extends TextView {
    private Paint mPaint;
    private float mTextSize;

    public AdjustSpaceTextView(Context context) {
        super(context);
    }

    public AdjustSpaceTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        refitText(getText().toString());
    }

    private void refitText(String text) {
        if(TextUtils.isEmpty(text)){
            return;
        }
        mTextSize = getTextSize();//返回值的单位是px
        mPaint = new Paint();
        mPaint.set(getPaint());
        int drawableWidth = 0;//drawableLeft/Right/Top/Buttom文本内容四周的图片宽度
        Drawable[] drawableCompound = getCompoundDrawables();
        for (int i = 0; i < drawableCompound.length; i++) {
            if(drawableCompound[i]!= null){
                drawableWidth += drawableCompound[i].getBounds().width();
            }
        }
        //获得当前TextView仅仅是显示文本内容的区域宽度
//                      TextView总宽度  xml文件中的PaddingLeft  文本内容四周的图片宽度
        int maybeWidth = getWidth() - getPaddingLeft() - drawableWidth -
//              xml文件中的PaddingRight   文本内容四周的图片距离边框的距离
                getPaddingRight() - getCompoundDrawablePadding();
        float textWidth =  mPaint.measureText(text);////text纯文本所占据的宽度
        while(textWidth > maybeWidth){
            mPaint.setTextSize(--mTextSize);
            textWidth = mPaint.measureText(text);
        }
        //setTextSize() 的单位是sp，因此要转化一次：sp ---→ px
        this.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
    }
}
