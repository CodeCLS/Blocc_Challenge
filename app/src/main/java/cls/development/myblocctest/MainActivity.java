package cls.development.myblocctest;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //i is the index of the switch. Value 1 is on and value 0 is off
    private int i = 1;

    public int getIndex() {
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Thumb thumb = findViewById(R.id.circle_view);
        final Switch switch_widget = findViewById(R.id.view_switch);
        Switch_onClick(thumb, switch_widget);


    }

    private void Switch_onClick(final Thumb thumb, final Switch switch_widget) {
        switch_widget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i == 1) {


                    circle_to_line_anim(thumb, switch_widget);

                }
                else{
                    line_to_circle_anim(thumb, switch_widget);


                }






            }
        });
    }

    private void line_to_circle_anim(final Thumb thumb, final Switch switch_widget) {

        ObjectAnimator translateXAnimation= ObjectAnimator.ofFloat(thumb, "translationX",  1f);
        translateXAnimation.setDuration(300);
        translateXAnimation.start();

        translateXAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float x = (Float)valueAnimator.getAnimatedValue();

                float val_alpha =(70-x)/70+0.3f;
                switch_widget.setAlpha(val_alpha);
                thumb.anim_view(x);

            }
        });
        Toast.makeText(this, "ON", Toast.LENGTH_SHORT).show();
        i = 1;

    }

    private void circle_to_line_anim(final Thumb thumb, final Switch switch_widget) {
        ObjectAnimator translateXAnimation= ObjectAnimator.ofFloat(thumb, "translationX",  70f);
        translateXAnimation.setDuration(300);
        translateXAnimation.start();


        translateXAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float x = (Float) valueAnimator.getAnimatedValue();

                switch_widget.setAlpha((70-x)/70+0.3f);
                thumb.anim_view(x);

            }
        });

        Toast.makeText(this, "OFF", Toast.LENGTH_SHORT).show();


        i = 0;
    }

    public void setIndex(int i) {
        this.i = i;
    }
}