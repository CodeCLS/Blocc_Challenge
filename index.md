## Blocc Widget

This project is a widget which was created for the Blocc Intern Challenge. It is made out of three different classes.
1. Thumb
2. Switch
3. MainActivity

### Introduction to code

The circle and the two Arcs which make up the circle are made within two methods.


```markdown
@Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        draw_Line(canvas);
        drawArcs(canvas);


    }
```
The onDraw Method gets overriden everytime the ObjectAnimator makes another step.
In my MainActivity I call a method which sets the positino of the animation in the Thumb Class and the Switch class.
This again invalidates the Viewlayout and moves the views and changes the colors.

```markdown
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
```



