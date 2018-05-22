//package bonc.demopractice_allkinsoff.adaptive;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.graphics.Rect;
//import android.support.annotation.Nullable;
//import android.util.AttributeSet;
//import android.util.TypedValue;
//import android.widget.TextView;
//
///**
// * Created by chen1 on 2017/10/30.
// * TO DO:
// */
//
//public class AdjustSizeTextView extends TextView {
//    private Paint mTextPaint;
//    private float mTextSize;
//    private float mMinTextSize = 16.0f;
//
//    public AdjustSizeTextView(Context context) {
//        super(context);
//    }
//
//    public AdjustSizeTextView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    private void refitText(String text, int textViewWidth) {
//        if (text == null || text.equals("") || textViewWidth < 0) {
//            return;
//        }
//        mTextPaint = this.getPaint();
//        int availableTextViewWidth = getWidth() - getPaddingLeft() - getPaddingRight();
//        float[] charWidthArr = new float[text.length()];
//        Rect boundsRect = new Rect();
//        mTextPaint.getTextBounds(text, 0, text.length(), boundsRect);
//        int textWidth = boundsRect.width();
//        int textNum = 0;
//        mTextSize = getTextSize();
//        while (textWidth > availableTextViewWidth) {
//            if (mTextSize > mMinTextSize) {
//                mTextSize -= 1;
//                mTextPaint.setTextSize(mTextSize);
//                textNum = mTextPaint.getTextWidths(text,charWidthArr);
//
//                textWidth = 0;
//                for (int i =0; i<textNum; i++){
//                    textWidth += charWidthArr[i];
//                }
//            }
//        }
//        this.setTextSize(TypedValue.COMPLEX_UNIT_PX,mTextSize);//单位转化:sp转为px
//    }
//    @Override
//    protected void onDraw(Canvas canvas) {
//        refitText(this.getText().toString(),this.getWidth());
//        canvas.drawText(this.getText().toString(),0,getHeight(),mTextPaint);
//    }
//
//    @Override
//    public void setPadding(int left, int top, int right, int bottom) {
//        super.setPadding(left, top, right, bottom);
//    }
//}
