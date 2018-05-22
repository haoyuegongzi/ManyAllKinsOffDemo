package bonc.demopractice_allkinsoff.objectAnimator;

import android.animation.TypeEvaluator;

/**
 * Created by chen1 on 2017/8/16.
 */

public class MyPointEvaluator implements TypeEvaluator<Point> {
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        int start = startValue.getRdious();
        int end  = endValue.getRdious();
        int curValue = (int)(start + fraction * (end - start));
        return new Point(curValue);
    }
}
