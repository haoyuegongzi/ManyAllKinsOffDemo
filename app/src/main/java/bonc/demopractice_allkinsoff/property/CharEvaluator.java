package bonc.demopractice_allkinsoff.property;

import android.animation.TypeEvaluator;

/**
 * Created by chen1 on 2017/8/17.
 */

public class CharEvaluator implements TypeEvaluator<Character> {
    @Override
    public Character evaluate(float v, Character character, Character t1) {
        int start = (int)character;
        int end = (int)t1;
        int value = (int)(start + v * (end - start));
        char cha = (char)value;
        return cha;
    }
}
