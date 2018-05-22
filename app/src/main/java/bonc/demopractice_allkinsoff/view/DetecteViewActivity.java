package bonc.demopractice_allkinsoff.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetecteViewActivity extends AppCompatActivity  {

    @BindView(R.id.tvDeteView)
    TextView mTvDeteView;
    @BindView(R.id.btDeteView)
    Button mBtDeteView;
    @BindView(R.id.btEvent)
    Button mBtEvent;
    @BindView(R.id.llEvent)
    LinearLayout mLlEvent;
    @BindView(R.id.rlEvent)
    RelativeLayout mRlEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detecte_view);
        ButterKnife.bind(this);
//        mBtDeteView.post(new Runnable() {
//            @Override
//            public void run() {
//                int tvLeft = mTvDeteView.getLeft();
//                int tvRight = mTvDeteView.getRight();
//                int btLeft = mBtDeteView.getLeft();
//                int beRight = mBtDeteView.getRight();
//                Log.i("TAG", "onClick: tvLeft ==" + tvLeft + "——>>>tvRight ==" + tvRight + "\n" +
//                        "——>>>btLeft ==" + btLeft + "——>>>beRight ==" + beRight);
//
//                float transX = mBtDeteView.getTranslationX();
//                float transY = mBtDeteView.getTranslationY();
//                Log.i("TAG", "onClick: transX ==" + transX + "——>>>transY ==" + transY);
//            }
//        });
//
//        mBtDeteView.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                int tvLeft = mTvDeteView.getLeft();
//                int tvRight = mTvDeteView.getRight();
//                int btLeft = mBtDeteView.getLeft();
//                int beRight = mBtDeteView.getRight();
//                Log.i("TAG", "onClick: tvLeft ==" + tvLeft + "——>>>tvRight ==" + tvRight + "\n" +
//                        "——>>>btLeft ==" + btLeft + "——>>>beRight ==" + beRight);
//
//                float transX = mBtDeteView.getTranslationX();
//                float transY = mBtDeteView.getTranslationY();
//                Log.i("TAG", "onClick: transX ==" + transX + "——>>>transY ==" + transY);
//            }
//        },1000);
    }

    int eventX = -1;
    int eventY = -1;
    int lastX = 0;
    int lastY = 0;
    int differenceX = 0;
    int differenceY = 0;
    Paint paint;
    Canvas canvas;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        eventX = (int) event.getRawX();
        eventY = (int) event.getRawY();
        paint = new Paint();
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#FF0000"));
        paint.setStyle(Paint.Style.FILL);
        canvas = new Canvas();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = eventX;
                lastY = eventY;
                break;
            case MotionEvent.ACTION_MOVE:
                differenceX = eventX - lastX;
                differenceY = eventY - lastY;
                Log.i("TAG", "onTouchEvent: differenceX ===" + differenceX +
                             "————》》》differenceY ===" + differenceY);
                canvas.drawLine(lastX, lastY, eventX, eventY, paint);
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return false;
    }



    @Override
    protected void onResume() {
        super.onResume();
        mBtEvent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("TAG", "onClick: 执行了onClick");
            }
        });
        mBtEvent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.i("TAG", "onTouch: 执行了onTouch————>>>>ACTION_DOWN：" + event.getAction());
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.i("TAG", "onTouch: 执行了onTouch————>>>>ACTION_MOVE："+ event.getAction());
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i("TAG", "onTouch: 执行了onTouch————>>>>ACTION_UP："+ event.getAction());
                        break;
                }
                return false;
            }
        });

//        mBtDeteView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int tvLeft = mTvDeteView.getLeft();
//                int tvRight = mTvDeteView.getRight();
//                int btLeft = mBtDeteView.getLeft();
//                int beRight = mBtDeteView.getRight();
//                Log.i("TAG", "onClick: tvLeft ==" + tvLeft + "——>>>tvRight ==" + tvRight + "\n" +
//                        "——>>>btLeft ==" + btLeft + "——>>>beRight ==" + beRight);
//
//                float transX = mBtDeteView.getTranslationX();
//                float transY = mBtDeteView.getTranslationY();
//                Log.i("TAG", "onClick: transX ==" + transX + "——>>>transY ==" + transY);
//            }
//        });
    }
}
