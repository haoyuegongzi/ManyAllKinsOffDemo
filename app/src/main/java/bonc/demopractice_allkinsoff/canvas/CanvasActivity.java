package bonc.demopractice_allkinsoff.canvas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import bonc.demopractice_allkinsoff.R;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        FrameLayout flCanvas = (FrameLayout) findViewById(R.id.flCanvas);
        flCanvas.addView(new CustomView01(CanvasActivity.this));
    }
}
