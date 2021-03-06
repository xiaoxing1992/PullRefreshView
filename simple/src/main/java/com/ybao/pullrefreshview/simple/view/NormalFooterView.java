package com.ybao.pullrefreshview.simple.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.view.ViewHelper;
import com.ybao.pullrefreshview.layout.BaseFooterView;
import com.ybao.pullrefreshview.simple.R;
import com.ybao.pullrefreshview.simple.utils.AnimUtil;
import com.ybao.pullrefreshview.support.type.LayoutType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ybao on 2015/11/3 0003.
 */
public class NormalFooterView extends BaseFooterView {

    TextView textView;
    View tagImg;

    public NormalFooterView(Context context) {
        this(context, null);
    }

    public NormalFooterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NormalFooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_footer_normal, this, true);
        textView = (TextView) findViewById(R.id.text);
        tagImg = findViewById(R.id.tag);
    }


    List<Animator> animators = new ArrayList<>();
    @Override
    protected void onStateChange(int state) {
        for (Animator animator : animators) {
            animator.cancel();
        }
        animators.clear();
        textView.setVisibility(View.VISIBLE);
        tagImg.setVisibility(View.VISIBLE);
        ViewHelper.setAlpha(textView, 1);
        ViewHelper.setAlpha(tagImg, 1);
        switch (state) {
            case NONE:
                break;
            case PULLING:
                textView.setText("上拉阅读下一个内容");
                animators.add(AnimUtil.startRotation(tagImg, 0));
                break;
            case LOOSENT_O_LOAD:
                textView.setText("松开阅读下一个内容");
                animators.add(AnimUtil.startRotation(tagImg, 180));
                break;
            case LOADING:
                animators.add(AnimUtil.startHide(textView));
                animators.add(AnimUtil.startHide(tagImg));
                break;
            case LOAD_CLONE:
                textView.setVisibility(View.INVISIBLE);
                tagImg.setVisibility(View.INVISIBLE);
                break;

        }

    }

    @Override
    public float getSpanHeight() {
        return getHeight();
    }

    @Override
    public int getLayoutType() {
        return LayoutType.LAYOUT_NORMAL;
    }
}
