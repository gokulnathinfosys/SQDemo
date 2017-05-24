package com.kpgn.sqdemo.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kpgn.sqdemo.R;
import com.kpgn.sqdemo.application.SQDemoApplication;
import com.kpgn.sqdemo.utility.DateTimeUtil;

import java.util.Date;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Inject
    Context context;

    @Inject
    DateTimeUtil dateTimeUtil;

    @Bind(R.id.message)
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ButterKnife.bind(this);
        SQDemoApplication.inject(this);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.action_update_time)
    public void actionUpdateTime(View view){
        message.setText(dateTimeUtil.getFormattedDateTime(new Date()));
        Toast.makeText(context, getString(R.string.toast_message), Toast.LENGTH_SHORT).show();
    }
}
