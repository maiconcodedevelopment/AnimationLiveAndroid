package com.example.layoutandroid.components;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class ViewContainer extends View {

    public ViewContainer(Context context) {
        super(context);
    }

    public ViewContainer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e("measureWidth",MeasureSpec.toString(widthMeasureSpec));
        Log.e("measureHeight",MeasureSpec.toString(heightMeasureSpec));
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
