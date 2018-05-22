package bonc.demopractice_allkinsoff.Animation;

import android.animation.TypeEvaluator;

/**
 * Created by chen1 on 2017/8/16.
 */

public class MyEvaluator implements TypeEvaluator<Integer> {
    @Override
    public Integer evaluate(float v, Integer start, Integer end) {
        return (int)(end - v * (end - start)) ;
    }
}
