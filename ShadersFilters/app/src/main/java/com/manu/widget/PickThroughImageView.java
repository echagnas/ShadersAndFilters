package com.manu.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by Manu on 28/11/2014.
 */
public class PickThroughImageView extends ImageView{

    private final float radius;
    private Paint paint = null;
    private float x;
    private float y;
    private boolean shouldDrawOpening = false;

    public PickThroughImageView(Context context) {
        super(context);
        radius = 100;
    }

    public PickThroughImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        radius = 100;
    }

    public PickThroughImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        radius = 100;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction();
        shouldDrawOpening = (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_MOVE);
        x = event.getX();
        y = event.getY();
        invalidate();

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(paint == null){
            Bitmap original = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            Canvas originalCanvas = new Canvas(original);
            super.onDraw(originalCanvas);

            Shader shader = new BitmapShader(original, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            paint = new Paint();
            paint.setShader(shader);
        }

        canvas.drawColor(Color.GRAY);
        if(shouldDrawOpening){
            canvas.drawCircle(x, y - radius, radius, paint);
        }
    }
}
