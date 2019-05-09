package com.ybao.pullrefreshview.simple.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.Toast;

import com.ybao.pullrefreshview.layout.BaseFooterView;
import com.ybao.pullrefreshview.layout.BaseHeaderView;
import com.ybao.pullrefreshview.simple.R;

public class WebViewActivity extends AppCompatActivity implements BaseHeaderView.OnRefreshListener, BaseFooterView.OnLoadListener {

    WebView webview_wv;
    BaseHeaderView headerView;
    BaseFooterView footerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webview_wv =  findViewById(R.id.webview_wv);
        headerView = (BaseHeaderView) findViewById(R.id.header);
        footerView = (BaseFooterView) findViewById(R.id.footer);

        headerView.setOnRefreshListener(this);
        footerView.setOnLoadListener(this);

        webview_wv.loadUrl("https://blog.csdn.net/weixin_33754913/article/details/87512447");
    }

    @Override
    public void onRefresh(BaseHeaderView baseHeaderView) {
        headerView.stopRefresh();
        Toast.makeText(this, "刷新完成", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoad(BaseFooterView baseFooterView) {
        footerView.stopLoad();
        Toast.makeText(this, "加载下一个完成", Toast.LENGTH_SHORT).show();
    }
}
