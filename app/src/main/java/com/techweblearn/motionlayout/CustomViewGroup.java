package com.techweblearn.motionlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class CustomViewGroup extends ViewGroup {
    public CustomViewGroup(Context context) {
        super(context);
    }

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        int prevChildRight = 0;
        int prevChildBottom = 0;
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            child.layout(prevChildRight, prevChildBottom,
                    prevChildRight + child.getMeasuredWidth(),
                    prevChildBottom + child.getMeasuredHeight());
            prevChildRight += child.getMeasuredWidth();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int totalWidth = 0;
        int totalHeight = 0;

        int count=getChildCount();
        for(int i=0;i<count;i++)
        {
            final View child=getChildAt(i);
            measureChild(child,widthMeasureSpec,heightMeasureSpec);
            totalWidth += child.getMeasuredWidth();
            if (child.getMeasuredHeight() > totalHeight) {
                //height of the container, will be the largest height.
                totalHeight = child.getMeasuredHeight();
            }
        }

        setMeasuredDimension(totalWidth,totalHeight);
    }
}
