package com.hour24.expandrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private ArrayList<ModelItem> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSample();
        initLayout();


    }

    private void setSample() {

        mList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            ModelItem model = new ModelItem();
            model.setCategory("카테고리 " + i);

            ArrayList<ModelItem> items = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                ModelItem item = new ModelItem();
                item.setTitle("아이템 " + j);
                items.add(item);
            }
            model.setItems(items);
            mList.add(model);
        }
    }

    private void initLayout() {

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new RecyclerViewAdapter(this, mList));

    }
}
