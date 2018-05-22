package bonc.demopractice_allkinsoff.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by chenjie on 2017/5/12.
 * TODO：Canvas可以绘制的对象有：弧线(arcs)、填充颜色(argb和color)、 Bitmap、
 * 圆(circle和oval)、点(point)、线(line)、矩形(Rect)、图片(Picture)、
 * 圆角矩形 (RoundRect)、文本(text)、顶点(Vertices)、路径(path)。
 * TODO：Canvas位置转换的方法：rorate、scale、translate、skew(扭曲)等
 * TODO：Canvas 还提供了保存和回滚属性的方法(save和restore)，比如你可以先保存目前画纸的位置(save)，
 * 然后旋转90度，向下移动100像素后画一些图形，画完后调用restore方法返回到刚才保存的位置
 */

public class CanvasChangeOperate extends View {
    private Paint mPaint;

    public CanvasChangeOperate(Context context) {
        super(context);
        mPaint = new Paint();//获取一个画笔对象，用于绘图
        mPaint.setColor(Color.RED);//画笔颜色
        mPaint.setAntiAlias(true);//抗锯齿
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.FILL);//设置填充样
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        reMove(canvas);
    }

    public void reMove(Canvas canvas){
        Paint paintGreen = generatePaint(Color.GREEN, Paint.Style.STROKE, 3);
        Paint paintRed = generatePaint(Color.RED, Paint.Style.STROKE, 3);
        RectF rectF = new RectF(100,100,400,400);
        //平移画布前用绿色画下边框
        canvas.drawRect(rectF, paintGreen);
        //平移画布后,再用红色边框重新画下这个矩形
        canvas.translate(100,100);
        canvas.drawRect(rectF,paintRed);
    }

    private Paint generatePaint(int color, Paint.Style style, int width) {
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(style);
        paint.setStrokeWidth(width);
        return paint;
    }
}