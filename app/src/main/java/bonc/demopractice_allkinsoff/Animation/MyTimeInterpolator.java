package bonc.demopractice_allkinsoff.Animation;

import android.animation.TimeInterpolator;

/**
 * Created by chen1 on 2017/8/16.
 */

public class MyTimeInterpolator implements TimeInterpolator {
    @Override
    public float getInterpolation(float v) {
        return v;
    }
}
