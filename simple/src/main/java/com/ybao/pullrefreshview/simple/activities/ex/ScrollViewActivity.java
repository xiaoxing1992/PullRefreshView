package com.ybao.pullrefreshview.simple.activities.ex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ybao.pullrefreshview.layout.BaseFooterView;
import com.ybao.pullrefreshview.layout.BaseHeaderView;
import com.ybao.pullrefreshview.simple.R;

/**
 * Created by Ybao on 2015/11/5 0003.
 */
public class ScrollViewActivity extends AppCompatActivity implements BaseHeaderView.OnRefreshListener, BaseFooterView.OnLoadListener {

    BaseHeaderView headerView;
    BaseFooterView footerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview);

        headerView = (BaseHeaderView) findViewById(R.id.header);
        footerView = (BaseFooterView) findViewById(R.id.footer);

        headerView.setOnRefreshListener(this);
        footerView.setOnLoadListener(this);
    }


    @Override
    public void onRefresh(BaseHeaderView baseHeaderView) {
        headerView.stopRefresh();
    }

    @Override
    public void onLoad(BaseFooterView baseFooterView) {
        footerView.stopLoad();
    }


}
