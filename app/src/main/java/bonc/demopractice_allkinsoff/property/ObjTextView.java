package bonc.demopractice_allkinsoff.property;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by chen1 on 2017/8/17.
 */

public class ObjTextView extends TextView {

    public ObjTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setCharText(Character character){
        setText(String.valueOf(character));
    }
}
