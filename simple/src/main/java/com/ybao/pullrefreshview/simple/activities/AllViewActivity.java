package com.ybao.pullrefreshview.simple.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ybao.pullrefreshview.simple.R;
import com.ybao.pullrefreshview.simple.activities.ex.RecyclerViewActivity;
import com.ybao.pullrefreshview.simple.activities.ex.ScrollViewActivity;
import com.ybao.pullrefreshview.simple.activities.ex.TextViewActivity;


/**
 * Created by Ybao on 2015/11/3 0003.
 */
public class AllViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_view);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AllViewActivity.this, ScrollViewActivity.class));
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AllViewActivity.this, TextViewActivity.class));
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AllViewActivity.this, RecyclerViewActivity.class));
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AllViewActivity.this, WebViewActivity.class));
            }
        });
    }
}
