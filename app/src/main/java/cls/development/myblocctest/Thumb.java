package cls.development.myblocctest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Thumb extends View {
    private float position = 1;


    public Thumb(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }



    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);




        setMeasuredDimension(50, 50);

    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawArcs(canvas);
        draw_Line(canvas);

    }

    private void drawArcs(Canvas canvas) {

        Paint circlePaint = new Paint();
        circlePaint.setStrokeWidth(5);
        circlePaint.setColor(Color.WHITE);


        RectF rectF = new RectF(position * 5/10, 5, canvas.getWidth()-5, canvas.getHeight()-5);


        canvas.drawArc (rectF, 270, 180, true,  circlePaint);
        canvas.drawArc (rectF, 270, -180, true,  circlePaint);

    }
    private void draw_Line(Canvas canvas) {
        Paint circlePaint = new Paint();
        circlePaint.setStrokeWidth(10);
        circlePaint.setStrokeCap(Paint.Cap.ROUND);


        circlePaint.setColor(Color.WHITE);
        float end_percentage = 70f;
        if(position < end_percentage -20 && position > 40) {
            circlePaint.setAlpha((int) ((position * 100) / end_percentage));
            canvas.drawLine(canvas.getWidth()-10,10,canvas.getWidth()-10,canvas.getHeight()-10,circlePaint);

        }
        if(position > end_percentage -20){
            circlePaint.setAlpha((int) ((position * 160) / end_percentage)+50);
            canvas.drawLine(canvas.getWidth()-10,10,canvas.getWidth()-10,canvas.getHeight()-10,circlePaint);


        }




    }






    public void anim_view(Float animatedValue) {

        position = animatedValue;
        this.invalidate();

    }
}
