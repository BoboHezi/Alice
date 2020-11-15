package com.eli.ali;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DeliverAct extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliver_info);

        String id = getIntent().getStringExtra("id");
        ((TextView) findViewById(R.id.order_id)).setText(id);
    }

    public void close(View v) {
        finish();
    }
}
