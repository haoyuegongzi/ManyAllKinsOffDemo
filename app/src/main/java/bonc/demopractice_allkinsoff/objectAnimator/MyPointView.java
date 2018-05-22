package bonc.demopractice_allkinsoff.objectAnimator;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

/**
 * Created by chen1 on 2017/8/16.
 */

public class MyPointView extends View {
    ValueAnimator valueAnimator;

    private Point mPoint;
    private Paint mPaint;

    private int wid, hei;

    public MyPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setStrokeWidth(5);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        wid = w;
        hei = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mPoint != null){
            canvas.drawCircle(wid / 2, hei / 2, mPoint.getRdious(), mPaint);
        }
    }

    public void getAnimator(){
        valueAnimator = ValueAnimator.ofObject(new MyPointEvaluator(), new Point(20), new Point(280));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mPoint = (Point)valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.setDuration(1500);
        valueAnimator.setRepeatCount(1);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.start();
    }
}
