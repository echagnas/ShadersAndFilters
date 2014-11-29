package com.manu.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Manu on 29/11/2014.
 */
public class GreyImageView extends ImageView{


    public GreyImageView(Context context) {
        super(context);
    }

    public GreyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GreyImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Bitmap original = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas originalCanvas = new Canvas(original);
        super.onDraw(originalCanvas);

        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(getColorMatrix()));

        canvas.drawBitmap(original, 0, 0, paint);
    }

    private ColorMatrix getColorMatrix() {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0);
        return colorMatrix;
    }


}
