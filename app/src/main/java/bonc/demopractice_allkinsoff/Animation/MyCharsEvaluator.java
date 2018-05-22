package bonc.demopractice_allkinsoff.Animation;

import android.animation.TypeEvaluator;

/**
 * Created by chen1 on 2017/8/16.
 */

public class MyCharsEvaluator implements TypeEvaluator<Character> {
    @Override
    public Character evaluate(float v, Character characterStart, Character characterEnd) {
        int start = (int)characterStart;
        int end = (int)characterEnd;
        int result = (int)(start + v*(end - start));
        char cha = (char)result;
        return cha;
    }
}
