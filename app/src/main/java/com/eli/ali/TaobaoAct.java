package com.eli.ali;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaobaoAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taobao);

        RecyclerView recyclerView = findViewById(R.id.order_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("12djfuj"));
        orders.add(new Order("ry6378"));
        orders.add(new Order("12dsjdujjfuj"));
        orders.add(new Order("qwerrt"));
        orders.add(new Order("12d123334jfuj"));
        recyclerView.setAdapter(new OrdersAdapter(this, orders));
    }
}