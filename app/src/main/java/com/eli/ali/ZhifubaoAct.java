package com.eli.ali;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

@RequiresApi(api = Build.VERSION_CODES.N)
public class ZhifubaoAct extends AppCompatActivity {

    private static final String TAG = "ZhifubaoAct";

    private RecyclerView mBillsList;

    private BillsAdapter mBillsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhifubao);

        mBillsList = findViewById(R.id.bills_list);

        mBillsAdapter = new BillsAdapter(Utils.loadList("bills.json", Bill[].class, this), this);
        mBillsList.setLayoutManager(new LinearLayoutManager(this));
        mBillsList.setAdapter(mBillsAdapter);
    }
}
