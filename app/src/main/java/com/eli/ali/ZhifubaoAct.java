package com.eli.ali;

import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiresApi(api = Build.VERSION_CODES.N)
public class ZhifubaoAct extends AppCompatActivity {

    private static final String TAG = "ZhifubaoAct";

    private RecyclerView mBillsList;

    private BillsAdapter mBillsAdapter;

    private List<Bill> mBills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhifubao);

        mBillsList = findViewById(R.id.bills_list);

        mBillsAdapter = new BillsAdapter(loadBills(), this);
        mBillsList.setLayoutManager(new LinearLayoutManager(this));
        mBillsList.setAdapter(mBillsAdapter);

        AssetManager assetManager = getAssets();
        String[] assets = null;
        try {
            assets = assetManager.list("");
        } catch (IOException e) {
        }

        if (assets != null && assets.length > 0) {
            for (String item : assets) {
                Log.i(TAG, item);
            }
        }
    }

    private List<Bill> loadBills() {
        List<Bill> mBills = new ArrayList<>();

        AssetManager assetManager = getAssets();

        InputStream inputStream = null;
        try {
            inputStream = assetManager.open("bills.json");
        } catch (IOException e) {
        }
        if (inputStream != null) {
            String str = new BufferedReader(new InputStreamReader(inputStream))
                    .lines().collect(Collectors.joining(System.lineSeparator()));
            Gson gson = new Gson();
            mBills = Arrays.asList(gson.fromJson(str, Bill[].class));
        }
        return mBills;
    }
}
