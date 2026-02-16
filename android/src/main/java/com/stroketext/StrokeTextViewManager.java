package com.stroketext;

import android.view.View;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class StrokeTextViewManager extends SimpleViewManager<View> {
    public static final String REACT_CLASS = "StrokeTextView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public View createViewInstance(ThemedReactContext reactContext) {
        return new StrokeTextView(reactContext);
    }

    @ReactProp(name = "text")
    public void setText(StrokeTextView view, String text) {
        view.setText(text);
    }

    @ReactProp(name = "fontSize")
    public void setFontSize(StrokeTextView view, float fontSize) {
        view.setFontSize(fontSize);
    }

    @ReactProp(name = "color")
    public void setColor(StrokeTextView view, String color) {
        view.setTextColor(color);
    }

    @ReactProp(name = "strokeColor")
    public void setStrokeColor(StrokeTextView view, String strokeColor) {
        view.setStrokeColor(strokeColor);
    }

    @ReactProp(name = "strokeWidth")
    public void setStrokeWidth(StrokeTextView view, float strokeWidth) {
        view.setStrokeWidth(strokeWidth);
    }

    @ReactProp(name = "fontFamily")
    public void setFontFamily(StrokeTextView view, String fontFamily) {
        view.setFontFamily(fontFamily);
    }

    @ReactProp(name = "align")
    public void setTextAlignment(StrokeTextView view, String align) {
        view.setTextAlignment(align);
    }

    @ReactProp(name = "numberOfLines")
    public void setNumberOfLines(StrokeTextView view, int numberOfLines) {
        view.setNumberOfLines(numberOfLines);
    }

    @ReactProp(name = "ellipsis")
    public void setEllipsis(StrokeTextView view, boolean ellipsis) {
        view.setEllipsis(ellipsis);
    }

    @ReactProp(name = "width")
    public void setWidth(StrokeTextView view, float width) {
        view.setCustomWidth(width);
    }

    @ReactProp(name = "shadowColor")
    public void setShadowColor(StrokeTextView view, String shadowColor) {
        view.setShadowColor(shadowColor);
    }

    @ReactProp(name = "shadowOffsetX", defaultFloat = 0f)
    public void setShadowOffsetX(StrokeTextView view, float shadowOffsetX) {
        view.setShadowOffsetX(shadowOffsetX);
    }

    @ReactProp(name = "shadowOffsetY", defaultFloat = 0f)
    public void setShadowOffsetY(StrokeTextView view, float shadowOffsetY) {
        view.setShadowOffsetY(shadowOffsetY);
    }

    @ReactProp(name = "shadowRadius", defaultFloat = 0f)
    public void setShadowRadius(StrokeTextView view, float shadowRadius) {
        view.setShadowRadius(shadowRadius);
    }

    @ReactProp(name = "shadowOpacity", defaultFloat = 1f)
    public void setShadowOpacity(StrokeTextView view, float shadowOpacity) {
        view.setShadowOpacity(shadowOpacity);
    }
}
