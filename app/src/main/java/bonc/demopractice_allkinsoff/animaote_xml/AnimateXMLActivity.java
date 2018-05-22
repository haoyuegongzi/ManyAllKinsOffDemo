package bonc.demopractice_allkinsoff.animaote_xml;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimateXMLActivity extends AppCompatActivity {
    @BindView(R.id.rvLayoutAnimate)
    RecyclerView mRvmLayoutAnimate;
    @BindView(R.id.btLoadRecyclerView)
    Button mBtLoadRecyclerView;
    @BindView(R.id.rlParent)
    RelativeLayout mRlParent;
    @BindView(R.id.btMain)
    Button mBtMain;
    @BindView(R.id.btChild01)
    Button mBtChild01;
    @BindView(R.id.btChild02)
    Button mBtChild02;
    @BindView(R.id.btChild03)
    Button mBtChild03;
    @BindView(R.id.btChild04)
    Button mBtChild04;
    @BindView(R.id.btChild05)
    Button mBtChild05;

    private boolean ViewBoolean = false;
    private LinearLayoutManager mLayoutManager;
    private List<String> mLayoutAnimate = new ArrayList<>();
    private AdapterLayoutAnimate mAdapterAnimate;
    private AnimatorSet openAnimatorSet = new AnimatorSet();
    private AnimatorSet closeAnimatorSet = new AnimatorSet();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate_xml);
        ButterKnife.bind(this);

        mLayoutAnimate = layoutAnimateList();
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvmLayoutAnimate.setLayoutManager(mLayoutManager);

//        mRvmLayoutAnimate.setLayoutManager(new GridLayoutManager(this, 3));
        mAdapterAnimate = new AdapterLayoutAnimate(this, mLayoutAnimate);
        mRvmLayoutAnimate.setAdapter(mAdapterAnimate);
    }

    private void openButtonView(View view, float position, float total, float radus) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = 90f / total * position;
        float traslateX = -(float) Math.abs(radus * Math.cos(degree));
        float traslateY = -(float) Math.abs(radus * Math.sin(degree));
        Log.i("TAG", "openButtonView Math.sin(degree)===" + Math.sin(degree) + "\n Math.cos(degree) ===" + Math.cos(degree) +
                "\n degree ===" + degree + "\n traslateX ===" + traslateX + "\n traslateY ===" + traslateY);
        openAnimatorSet.playTogether(ObjectAnimator.ofFloat(view, "translationX", 0f, traslateX),
                ObjectAnimator.ofFloat(view, "translationY", 0f, traslateY),
                ObjectAnimator.ofFloat(view, "scaleX", 0f, 1.0f),
                ObjectAnimator.ofFloat(view, "scaleY", 0f, 1.0f),
                ObjectAnimator.ofFloat(view, "alpha", 0f, 1.0f));
        openAnimatorSet.setDuration(1000).setInterpolator(new LinearInterpolator());
        openAnimatorSet.start();
    }

    private void closeButtonView(View view) {
        int distanceX = mRlParent.getHeight() - view.getBottom();
        int distanceY = mRlParent.getWidth() - view.getRight();

        closeAnimatorSet.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", 0f, distanceX),
                ObjectAnimator.ofFloat(view, "translationY", 0f, distanceY),
                ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0f),
                ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0f),
                ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0f));
    }

    @OnClick({R.id.btMain, R.id.btChild01, R.id.btChild02, R.id.btChild03, R.id.btChild04, R.id.btChild05, R.id.btLoadRecyclerView})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btMain:
                ViewBoolean = !ViewBoolean;
                if (ViewBoolean) {
                    openButtonView(mBtChild01, 0, 4, 360f);
                    openButtonView(mBtChild02, 1, 4, 360f);
                    openButtonView(mBtChild03, 2, 4, 360f);
                    openButtonView(mBtChild04, 3, 4, 360f);
                    openButtonView(mBtChild05, 4, 4, 360f);
                } else {
                    closeButtonView(mBtChild01);
                    closeButtonView(mBtChild02);
                    closeButtonView(mBtChild03);
                    closeButtonView(mBtChild04);
                    closeButtonView(mBtChild05);
                }

                break;
            case R.id.btChild01:

                break;
            case R.id.btChild02:

                break;
            case R.id.btChild03:


                break;
            case R.id.btChild04:

                break;
            case R.id.btChild05:

                break;
            case R.id.btLoadRecyclerView:
                constructeAnimarion();
                break;
        }
    }

    private void constructeAnimarion(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_in_bottom);
        LayoutAnimationController animationController = new LayoutAnimationController(animation);
        animationController.setDelay(0.5f);
        animationController.setOrder(LayoutAnimationController.ORDER_NORMAL);
        mRvmLayoutAnimate.setLayoutAnimation(animationController);
        mRvmLayoutAnimate.startLayoutAnimation();
        mAdapterAnimate.refreshAdapter();
    }

    private List<String> layoutAnimateList(){
        List<String> layoutAnimateList = new ArrayList<>();
        layoutAnimateList.add("缥缈剑法十二式");
        layoutAnimateList.add("剑一破");
        layoutAnimateList.add("剑二空");
        layoutAnimateList.add("剑三飞");
        layoutAnimateList.add("剑四灭");
        layoutAnimateList.add("剑五虚");
        layoutAnimateList.add("剑六绝");
        layoutAnimateList.add("剑七真");
        layoutAnimateList.add("剑八玄");
        layoutAnimateList.add("剑九轮回——八式往复入轮回");
        layoutAnimateList.add("剑十天葬——自生而灭为天葬");
        layoutAnimateList.add("剑十一涅槃——极而复始不生不灭是为涅槃");
        return layoutAnimateList;
    }

/**
 * 1	static double abs(double a) //法返回一个double值的绝对值.
 2	static float abs(float a) //返回一个float值的绝对值.
 3	static int abs(int a) //返回一个int值的绝对值.
 4	static long abs(long a) //返回一个long值的绝对值.
 5	static double acos(double a) //返回一个值的反余弦值，返回的角度范围从0.0到pi.
 6	static double asin(double a) //返回一个值的反正弦，返回的角度范围在-pi/2到pi/2.
 7	static double atan(double a) //返回一个值的反正切值，返回的角度范围在-pi/2到pi/2.
 8	static double atan2(double y, double x) //返回角度theta（x，y）从转换的矩形坐标到极坐标（r，θ）.
 9	static double cbrt(double a) //返回一个double值的立方根.
 10	static double ceil(double a) //返回最小的（最接近负无穷大）double值，大于或等于参数，并等于一个整数.
 11	static double copySign(double magnitude, double sign) //返回的第一个浮点参数与第二个浮点参数的符号.
 12	static float copySign(float magnitude, float sign) //返回的第一个浮点参数与第二个浮点参数的符号.
 13	static double cos(double a) //返回一个角的三角余弦.
 14	static double cosh(double x) //返回一个double值的双曲余弦.
 15	static double exp(double a) //回欧拉数e的一个double值的次幂.
 16	static double	expm1(double x) //返回 ex -1.
 17	static double floor(double a) //返回最大的（最接近正无穷大）double值小于或相等于参数，并相等于一个整数.
 18	static int getExponent(double d) //返回的无偏指数在该项表述的double.
 19	static int getExponent(float f) //返回一个浮点数的表示中使用的无偏指数.
 20	static double hypot(double x, double y) //没有中间溢出或下溢的情况下，此方法返回的sqrt(x2 +y2) .
 22	static double log(double a) //返回一个double值的自然对数（以e为底）.
 23	static double log10(double a) //返回一个double值以10为底.
 24	static double log1p(double x) //返回自然对数的总和的参数.
 25	static double max(double a, double b) //返回两个double值较大的那一个.
 26	static float max(float a, float b) //返回的两个浮点值最大的那一个.
 27	static int max(int a, int b) //法返回两个int值中最大的那一个.
 28	static long max(long a, long b) //返回的两个long值中最大的那一个.
 29	static double min(double a, double b) //返回的两个较小的double值.
 30	static float min(float a, float b) //返回的两个较小的浮动值.
 31	static int min(int a, int b) //返回的两个较小的int值.
 32	static long min(long a, long b) //返回的两个较小的长值.
 33	static double nextAfter(double start, double direction) //返回浮点数相邻方向的第二个参数，第一个参数.
 34	static float nextAfter(float start, double direction) //返回浮点数相邻方向的第二个参数，第一个参数.
 35	static double nextUp(double d) //在正无穷大的方向，此方法返回至d相邻的浮点值.
 36	static float nextUp(float f) //返回到f相邻的浮点值在正无穷方向上.
 37	static double pow(double a, double b) //返回的第一个参数的值提升到第二个参数的幂
 38	static double random() //返回一个无符号的double值，大于或等于0.0且小于1.0.
 39	static double rint(double a) //返回的double值，值的参数是最接近的，相等于一个整数.
 40	static long round(double a) //返回的参数最接近的long.
 41	static int round(float a) //返回的参数最接近的整数.
 42	static double scalb(double d, int scaleFactor) //返回d × 2scaleFactor 四舍五入，如果由一个单一的正确舍入的浮点乘法的double值组的成员.
 43	static float scalb(float f, int scaleFactor) //返回f × 2scaleFactor 四舍五入，如果由一个单一的正确舍入的浮点乘法，浮点值集合的成员.
 44	static double signum(double d) //返回signum函数的参数，如果参数是零返回0，如果参数大于零返回1.0，如果参数小于零返回-1.0.
 45	static float signum(float f) //返回signum函数的参数，如果参数是零返回0，如果参数大于零返回1.0f，如果参数小于零返回-1.0f.
 46	static double sin(double a) //返回一个double值的双曲正弦.
 47	static double sinh(double x) //返回一个double值的双曲正弦.
 48	static double sqrt(double a) //返回正确舍入的一个double值的正平方根.
 49	static double tan(double a) //返回一个角的三角函数正切值
 50	static double tanh(double x) //返回一个double值的双曲正切.
 51	static double toDegrees(double angrad) //这种方法大致相等的角度，以度为单位的角度转换成弧度测量.
 52	static double toRadians(double angdeg) //转换一个角度，以度为单位大致相等的角弧度测量.
 53	static double ulp(double d) //返回的参数的ulp的大小.
 54	static double ulp(float f) //返回的参数的ulp的大小.
 */
}
