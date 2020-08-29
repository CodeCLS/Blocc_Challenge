package cls.development.myblocctest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Switch extends View {
    private Paint paint = new Paint();
    private int color = Color.parseColor(getContext().getString(R.string.color_dark));


    public Switch(Context context, AttributeSet attrs) {
        super(context, attrs);

    }


    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(150, 140);

    }





    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //sizes and values of the circles => canvas.drawCircle()
        int circle_x_a = getWidth()/4;
        int circle_y_a = getHeight()/2;
        int circle_radius_a = getWidth()/4;

        int circle_x_b = getWidth() - getWidth()/4;
        int circle_y_b = getHeight() - getHeight()/2;
        int circle_radius_b = getWidth()/4;




        paint.setColor(color);





        @SuppressLint("DrawAllocation")
        RectF rectF = new RectF(circle_x_a, circle_y_a -circle_radius_a, circle_x_b, circle_y_b +circle_radius_b);
        canvas.drawCircle(circle_x_a, circle_y_a, circle_radius_a, paint);

        canvas.drawCircle(circle_x_b, circle_y_b, circle_radius_b, paint);
        canvas.drawRect(rectF,paint);










    }

    public void setColor(int color) {
        this.color = color;
        invalidate();
    }
}
