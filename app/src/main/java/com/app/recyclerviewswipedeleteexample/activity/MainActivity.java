package com.app.recyclerviewswipedeleteexample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.app.recyclerviewswipedeleteexample.R;
import com.app.recyclerviewswipedeleteexample.adapter.MainAdapter;
import com.app.recyclerviewswipedeleteexample.listener.OnItemClickIdListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickIdListener {

    private RecyclerView rvList;
    private List<String> mList = new ArrayList<>();
    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

    }

    private void findViews() {
        rvList = findViewById(R.id.rv_list);
        setAdapter();
    }

    private void setAdapter() {
        for (int i = 0; i < 15; i++) {
            mList.add("Text " + i);
        }
        mAdapter = new MainAdapter(MainActivity.this, mList, this);
        rvList.setHasFixedSize(true);
        rvList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvList.setAdapter(mAdapter);
    }

    @Override
    public void itemClickItem(int position) {
        mList.remove(position);
        mAdapter = new MainAdapter(MainActivity.this, mList, this);
        rvList.setHasFixedSize(true);
        rvList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvList.setAdapter(mAdapter);
    }
}
