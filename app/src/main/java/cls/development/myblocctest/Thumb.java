package cls.development.myblocctest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class Thumb extends View {
    private float position = 1;
    private MainActivity main;
    private Switch switch_instance;
    private int switch_width;
    private int index;



    public Thumb(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.main = new MainActivity();
        this.index = main.getIndex();
        this.switch_instance = new Switch(context,attrs);
        this.switch_width = switch_instance.getWidth();

    }



    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);




        setMeasuredDimension(50, 50);

    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        draw_Line(canvas);
        drawArcs(canvas);


    }

    private void drawArcs(Canvas canvas) {

        Paint circlePaint = new Paint();
        circlePaint.setStrokeWidth(5);
        circlePaint.setColor(Color.WHITE);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeCap(Paint.Cap.ROUND);
        float end_percentage = 70f;
        circlePaint.setAntiAlias(true);



        RectF rectF = new RectF(position+3, 5, canvas.getWidth()-2, canvas.getHeight()-5);

        if(position < end_percentage -20 && position > 40) {
            rectF = new RectF(position+3, 5, canvas.getWidth()-2, canvas.getHeight()-5);

        }
        if(position > end_percentage -20){
            rectF = new RectF(position+2, 5, canvas.getWidth()-2, canvas.getHeight()-5);


        }
        if(position ==end_percentage){
            rectF = new RectF(position, 5, canvas.getWidth()-2, canvas.getHeight()-5);


        }
        canvas.drawArc (rectF, 270, 180, false,  circlePaint);
        canvas.drawArc (rectF, 270, -180, false,  circlePaint);

    }
    private void draw_Line(Canvas canvas) {
        Paint circlePaint = new Paint();
        circlePaint.setStrokeWidth(10);
        circlePaint.setStrokeCap(Paint.Cap.ROUND);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setAntiAlias(true);



        circlePaint.setColor(Color.WHITE);
        float end_percentage = 70f;
        if(position < end_percentage -20 && position > 40) {
            circlePaint.setAlpha((int) ((position * 160) / end_percentage)+100);
            canvas.drawLine(canvas.getWidth()-7,10,canvas.getWidth()-7,canvas.getHeight()-10,circlePaint);


        }
        if(position > end_percentage -20){
            circlePaint.setAlpha((int) ((position * 160) / end_percentage)+50);
            canvas.drawLine(canvas.getWidth()-7,10,canvas.getWidth()-7,canvas.getHeight()-10,circlePaint);



        }
        if(position ==end_percentage){
            circlePaint.setAlpha(1000);
            canvas.drawLine(canvas.getWidth()-7,10,canvas.getWidth()-7,canvas.getHeight()-10,circlePaint);



        }






    }






    public void anim_view(Float animatedValue) {

        position = animatedValue;
        this.invalidate();

    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float X = (int) event.getRawX();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                X = event.getRawX();


            case MotionEvent.ACTION_UP:
                if(event.getRawX()/10 > 40 ){
                    this.setX(80);
                    main.setIndex(1);
                    switch_instance.setColor(Color.parseColor("#FFFFFF"));



                }
                else{
                    switch_instance.setColor(Color.parseColor(getContext().getString(R.string.color_dark)));
                    this.setX(10);
                    main.setIndex(0);

                }

                break;

            case MotionEvent.ACTION_MOVE:
                if(event.getRawX()/10 > 10 && event.getRawX()/10 < 70) {
                    this.setX(event.getRawX() / 10);
                    anim_view(event.getRawX() / 10);
                }

                Log.d("Thumb_anim" , "Position: " + event.getRawX() + "bounds: " + switch_width);


                break;
        }
        return true;




    }


}
