package com.ntrlab.ntrlabtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.ntrlab.ntrlabtest.adapters.EntityAdapter;
import com.ntrlab.ntrlabtest.models.Entity;
import com.ntrlab.ntrlabtest.tasks.Loading;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycler;
    private Entity entity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entity = new Entity();

        mRecycler = (RecyclerView) findViewById(R.id.recyclerView);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.setAdapter(new EntityAdapter(this, entity.getObjects()));

        Loading load = new Loading(this, entity);
        load.execute();
    }
}
