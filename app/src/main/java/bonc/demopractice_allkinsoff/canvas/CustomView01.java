package bonc.demopractice_allkinsoff.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

/**
 * Created by chenjie on 2017/5/12.
 * TODO：Canvas可以绘制的对象有：弧线(arcs)、填充颜色(argb和color)、 Bitmap、
 *      圆(circle和oval)、点(point)、线(line)、矩形(Rect)、图片(Picture)、
 *      圆角矩形 (RoundRect)、文本(text)、顶点(Vertices)、路径(path)。
 * TODO：Canvas位置转换的方法：rorate、scale、translate、skew(扭曲)等
 * TODO：Canvas 还提供了保存和回滚属性的方法(save和restore)，比如你可以先保存目前画纸的位置(save)，
 *      然后旋转90度，向下移动100像素后画一些图形，画完后调用restore方法返回到刚才保存的位置
 */

public class CustomView01 extends View {
    private Paint mPaint;
    public CustomView01(Context context) {
        super(context);
        if(mPaint == null){
            mPaint = new Paint();//获取一个画笔对象，用于绘图
            mPaint.setColor(Color.RED);//画笔颜色
            mPaint.setStrokeJoin(Paint.Join.ROUND);
            mPaint.setStrokeCap(Paint.Cap.ROUND);
            mPaint.setAntiAlias(true);//抗锯齿
//        mPaint.setShadowLayer(10f,15f,15f,Color.GREEN);
            mPaint.setStrokeWidth(10);
            mPaint.setStyle(Paint.Style.STROKE);//设置填充样
        }
    }
/**===============================================================================================*/
    /**
     * canvas.drawArc （扇形）、canvas.drawCircle（圆）、canvas.drawOval（椭圆）、
     * canvas.drawLine（线）、canvas.drawPoint（点）、canvas.drawRect（矩形）、
     * canvas.drawRoundRect（圆角矩形）、canvas.drawVertices（顶点）、cnavas.drawPath（路径）
     * canvas.drawBitmap （位图）、canvas.drawPicture （图片）、canvas.drawText（文本）
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawArc(canvas);
//        paintOp(canvas);
    }
/**===============================================================================================*/
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void paintOp(Canvas canvas){
        //构造两个矩形
        Rect rect1 = new Rect(100,100,400,200);
        Rect rect2 = new Rect(200,0,300,300);
        canvas.drawRect(rect1, mPaint);
        canvas.drawRect(rect2, mPaint);

        Region region1 = new Region(rect1);
        Region region2 = new Region(rect2);
        //取两个区域的交集
        region1.op(region2, Region.Op.DIFFERENCE);//只需要改动Op.INTERSECT参数值即可得到不同的结果
        //再构造一个画笔,填充Region操作结果
        Paint paint_fill = new Paint();
        paint_fill.setColor(Color.GREEN);
        paint_fill.setStyle(Paint.Style.FILL);
        drawRegin(canvas, region1, paint_fill);
        /**
         * Region还有一些比较容易理解的方法:
         * 几个判断方法:
         *  public native boolean isEmpty();//判断该区域是否为空
         *  public native boolean isRect(); //是否是一个矩阵
         *  public native boolean isComplex();//是否是多个矩阵组合
         * 一系列的getBound方法，返回一个Region的边界
         *  public Rect getBounds()
         *  public boolean getBounds(Rect r)
         *  public Path getBoundaryPath()
         *  public boolean getBoundaryPath(Path path)
         *一系列的判断是否包含某点 和是否相交
         *  public native boolean contains(int x, int y);//是否包含某点
         *  public boolean quickContains(Rect r)   //是否包含某矩形
         *  public native boolean quickContains(int left, int top, int right,
         *  int bottom) //是否没有包含某矩阵形
         *  public boolean quickReject(Rect r) //是否没和该矩形相交
         *  public native boolean quickReject(int left, int top, int right, int bottom); //是否没和该矩形相交
         *  public native boolean quickReject(Region rgn);  //是否没和该矩形相交
         *几个平移变换的方法
         *  public void translate(int dx, int dy)
         *  public native void translate(int dx, int dy, Region dst);
         *  public void scale(float scale) //hide
         *  public native void scale(float scale, Region dst);//hide
         */
    }
/**===============================================================================================*/
    public void paintRegionOval(Canvas canvas){
        Path ovlPath = new Path();//构造一个椭圆路径
        RectF ovlRectf = new RectF(250,250,400,700);
        ovlPath.addOval(ovlRectf, Path.Direction.CW);
        Region region = new Region();
        //传入一个比椭圆区域小的矩形区域,取其交集
        region.setPath(ovlPath, new Region(250,250,400,400));
        drawRegin(canvas, region, mPaint);//画出路径
    }
/**===============================================================================================*/
    public void paintRegion(Canvas canvas){
        Region region = new Region(10,10,100,100);
        region.set(110,110,200,200);//开启 set函数后，set里面的新坐标会替代原来的坐标，构建新的区域；
        drawRegin(canvas,region,mPaint);
    }
    private void drawRegin(Canvas canvas, Region region, Paint paint){
        RegionIterator iterator = new RegionIterator(region);
        Rect rect = new Rect();
        while (iterator.next(rect)){
            canvas.drawRect(rect,paint);
        }
    }
/**===============================================================================================*/
    public void paintOnPath(Canvas canvas){
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(50);
//        String sText = "风萧萧兮易水寒，壮士一去兮不复返";
        String sText = "|||||||||||||||||||||||||||||||";
        Path circlerPath = new Path();
//        circlerPath.addCircle(360,200,200, Path.Direction.CW);
        circlerPath.addRect(100,100,400,400, Path.Direction.CW);
        canvas.drawPath(circlerPath, mPaint);//绘制出路径原形

        Path textPath = new Path();
        textPath.addCircle(360,800,200, Path.Direction.CW);
        canvas.drawPath(textPath,mPaint);//绘制出路径原形

        mPaint.setColor(Color.GREEN);
        //hoffset、voffset参数值全部设为0，看原始状态是怎样的
        //hOffset:水平； vOffset：垂直；
        canvas.drawTextOnPath(sText,circlerPath,0,0,mPaint);
        canvas.drawTextOnPath(sText,textPath,80,40,mPaint);
    }
/**===============================================================================================*/
    public void painRoundRect(Canvas canvas){
        Path path = new Path();
        //方法1、只能构建统一圆角大小，20：X轴半径；30：Y轴半径
        RectF rect1 =  new RectF(50, 50, 240, 200);
        path.addRoundRect(rect1, 20, 30 , Path.Direction.CCW);
        //方法2、可以构建4个圆角大小不一的图形
        RectF rect2 =  new RectF(290, 50, 480, 200);
        float radii[] ={10,15,20,25,30,35,40,45};
        path.addRoundRect(rect2, radii, Path.Direction.CCW);

        canvas.drawPath(path, mPaint);
    }
/**===============================================================================================*/
    public void paintRectPath(Canvas canvas){//绘制矩形路径
        /**
         * Path.Direction.CW:沿顺时针方向的路径绘制矩形
         * Path.Direction.CCW:沿逆时针方向的路径绘制矩形
         * 从图形绘制结果上看，二者没有区别；二者的作用主要体现在：文本文字的布局排版上。
         */
        //顺向生成
        Path pathCW = new Path();
        RectF mRect = new RectF(50,50,200,200);
        pathCW.addRect(mRect, Path.Direction.CW);
        //逆向生成
        Path pathCCW = new Path();
        RectF rect = new RectF(50,300,200,450);
        pathCCW.addRect(rect, Path.Direction.CCW);

        canvas.drawPath(pathCW, mPaint);
        canvas.drawPath(pathCCW, mPaint);

        //依据路径写出文字
        String text="风萧萧兮易水寒，壮士一去兮不复返";
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(20);
        canvas.drawTextOnPath(text, pathCCW, 0, 10, mPaint);//逆时针生成
        canvas.drawTextOnPath(text, pathCW, 0, 10, mPaint);//顺时针生成
    }
/**===============================================================================================*/
    public void zonghe(Canvas canvas){
        canvas.translate(100, 100);
        canvas.drawColor(Color.RED);//可以看到，整个屏幕依然填充为红色

        canvas.drawRect(new Rect(-100, -100, 0, 0), new Paint());//缩放了
        canvas.scale(0.5f, 0.5f);
        canvas.drawRect(new Rect(0, 0, 100, 100), new Paint());

        canvas.translate(200, 0);
        canvas.rotate(30);
        canvas.drawRect(new Rect(0, 0, 100, 100), new Paint());//旋转了

        canvas.translate(200, 0);
        canvas.skew(.5f, .5f);//扭曲了
        canvas.drawRect(new Rect(0, 0, 100, 100), new Paint());
    }
/**===============================================================================================*/
    public void drawPoint(Canvas canvas){
        canvas.drawPoint(100f, 100f, mPaint);
    }
/**===============================================================================================*/
    public void drawCircle(Canvas canvas){  //一、画圆
        //四个参数含义分别是：圆心距X轴的距离，圆心距离Y轴的距离，圆半径，画笔。
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(200f, 200f, 100f, paint);
    }
/**===============================================================================================*/
    public void drawRing(Canvas canvas){    //画个圆环
        canvas.drawCircle(200f, 200f, 100f, mPaint);
        Paint paint = new Paint();//获取一个画笔对象，用于绘图
        paint.setColor(Color.WHITE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(200f, 200f, 80f, paint);
    }
    /**===============================================================================================*/
    public void drawArc(Canvas canvas){     //二、绘制扇形、弧等
        /**
         * RectF的4个参数：left, top, right, bottom  多用于绘制不规则图形，如椭圆等
         * first parms（left）：图形最左边距离Y轴的距离；     second parms（top）：图形最上边距离X轴的距离；
         * third parms（right）：图形最右边距离Y轴的距离；    fourth parms（bottom）：图形最下边距离X轴的距离；
         */
        RectF rectF = new RectF(0, 0, 400, 200);
        /**
         * drawArc的5个参数：RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint
         * RectF oval：指定圆弧的外轮廓矩形区域
         * float startAngle：圆弧起始角度，单位为度。
         * float sweepAngle：圆弧扫过角度（0~360），顺时针方向，单位为度。
         * boolean useCenter：true：绘制一个扇形；false：绘制扇形的弧
         * Paint paint: 画笔
         * setStyle()设置为STROKE时，绘制的图形为线性；设置为fill时，为填充色的区域图。
         */
        Paint paint=new Paint();
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.STROKE);//填充样式改为描边
        paint.setStrokeWidth(5);//设置画笔宽度

        RectF rect1 = new RectF(100, 10, 300, 100);
        canvas.drawArc(rect1, 0, 90, true, paint);

        RectF rect2 = new RectF(400, 10, 600, 100);
        canvas.drawArc(rect2, 0, 90, false, paint);

        Paint mpaint=new Paint();
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.FILL);//填充样式
        paint.setStrokeWidth(5);//设置画笔宽度

        RectF mRectF = new RectF(100, 310, 300, 400);
        canvas.drawArc(mRectF, 0, 90, true, mpaint);

        RectF mrectf = new RectF(400, 310, 600, 400);
        canvas.drawArc(mrectf, 0, 90, false, paint);
    }
/**===============================================================================================*/
    public void areaColor(Canvas canvas){   //三、直接将View显示区域用某个颜色填充满。
        canvas.drawColor(Color.GREEN);
    }
/**===============================================================================================*/
    public void paintLine(Canvas canvas){   //四、绘制直线(直线簇)
        /**
         * drawLine:五个参数：
         * float startX：折线起点X坐标值；float start：折线起点Y坐标值；float stopX：折线终点X坐标值
         * float stopY：折线终点Y坐标值； Paint paint:画笔
         */
        canvas.drawLine(100f,150f,100f,660f,mPaint);//画单条直线
        //画直线簇时，坐标数据的数组长度是 4 的整倍数，因为每条直线都有startX，startY，stopX，stopY
        float[] pts= {10,10,40,20,100,10,100,65,200,100,160,60,400,40,400,200,380,220,320,260};
        canvas.drawLines(pts,mPaint);//画直线簇
    }
/**===============================================================================================*/
    /**
     * RectF和RectF都是矩形辅助类，区别不大，用哪个都行。根据四个点构建一个矩形结构；
     * 利用这个矩形结构可以画出对应的矩形或者与其它图形相交、相加等等；
     */
    public void tuoyuan(Canvas canvas){      //五、绘制椭圆等
        RectF mRectf = new RectF(200,100,300,400);
        canvas.drawOval(mRectf, mPaint);
    }
/**===============================================================================================*/
    public void rectf(Canvas canvas){       //六、绘制矩形
        //下面A+B、C、D+E的效果一样
        RectF mRectf = new RectF(410,10,610,210);//A
        canvas.drawRect(mRectf, mPaint);          //B
        canvas.drawRect(200f,200f,400f,400f,mPaint);//C
        Rect mRect = new Rect(200,600,400,800);//D
        canvas.drawRect(mRect,mPaint);//E
    }
/**===============================================================================================*/
    public void recycler(Canvas canvas){     //七、绘制带圆角的矩形
        // 前4个参数含义见 二；后二个分别是X、Y方向的圆角
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawRoundRect(100f, 100f, 300f, 300f, 50f, 50f,mPaint);
        }
    }
/**===============================================================================================*/
    public void paintText(Canvas canvas){       //八、绘制文字
        mPaint.setTextSize(80);
        mPaint.setFakeBoldText(true);//设置是否为粗体文字
        mPaint.setUnderlineText(true);//设置下划线
        mPaint.setStrikeThruText(true);//设置带有删除线效果
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSkewX((float) -0.25);
        String sText = "定义ANDROID";
        mPaint.setTextScaleX(2);
        //描绘文字:sText：文字内容；   float[]：每个文字的坐标；  mPaint：画笔
        canvas.drawPosText(sText, new float[]{
                10,10,60,60,110,110,160,160,210,210,260,260,310,310,360,360,410,410
        }, mPaint);

//        mPaint.setTextSize(50);
        //绘图样式，设置为填充
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSkewX((float) 0.25);//设置字体水平倾斜度，为正向左倾斜；为负向右倾斜。
        mPaint.setTextScaleX(1);//先还原拉伸效果
        canvas.drawText("欢迎光临Harvic的博客", 10,600, mPaint);

        //绘图样式设置为描边
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawText("欢迎光临Harvic的博客", 10,700, mPaint);

        //绘图样式设置为填充且描边
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawText("欢迎光临Harvic的博客", 10,800, mPaint);
    }
/**===============================================================================================*/
    public void paintPath(Canvas canvas){        //九、绘制路径
        //moveTo(float x, float y)：给出起点坐标；
        //lineTo(float x, float y)：给出目标坐标；
        Path mPath = new Path();
        mPath.moveTo(50f,50f);
        mPath.lineTo(200f,50f);
        mPath.lineTo(200f,200f);
        mPath.lineTo(50f,200f);
        mPath.lineTo(50f,50f);
        mPath.close();
        canvas.drawPath(mPath,mPaint);
    }
/**===============================================================================================*/
    public void translate(Canvas canvas){       //十、位置转换
//        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setDither(true);
        canvas.translate(canvas.getWidth()/2, 500f);//所绘制的圆形刻度盘几何中心坐标

        canvas.save();
        canvas.translate(-75f,-75f);
        Path mPath = new Path();
        mPath.addArc(new RectF(0f, 0f, 150f, 150f), -180f, 180f);
        Paint paint = new Paint(mPaint);
        paint.setTextSize(16f);
        paint.setStrokeWidth(1);
        canvas.drawTextOnPath("http://www.android777.com", mPath, 28, 0, paint);
        canvas.restore();

        Paint litterPaint = new Paint(mPaint);//小刻度画笔对象
        litterPaint.setStrokeWidth(1);

        float y = 100;
        int count = 60;//总刻度数
        for (int i = 0; i < count; i++){
            if( i % 5 == 0){
                canvas.drawLine(0f, y, 0f, y+12f, mPaint);
                canvas.drawText(String.valueOf( i/5 + 1), -4f, y+25f, litterPaint);
            }else {
                canvas.drawLine(0f,y,0f,y+5f,litterPaint);
            }

            canvas.rotate(360/count, 0f, 0f);//旋转画纸
        }
        litterPaint.setColor(Color.RED);
        litterPaint.setStrokeWidth(4);
        canvas.drawCircle(0, 0, 7, litterPaint);
        litterPaint.setStyle(Paint.Style.FILL);
        litterPaint.setColor(Color.YELLOW);
        canvas.drawCircle(0, 0, 5, litterPaint);
        canvas.drawLine(0, 10, 0, -65, paint);
    }
}