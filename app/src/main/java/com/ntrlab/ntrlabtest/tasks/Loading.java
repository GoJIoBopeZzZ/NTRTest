package com.ntrlab.ntrlabtest.tasks;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ntrlab.ntrlabtest.MainActivity;
import com.ntrlab.ntrlabtest.R;
import com.ntrlab.ntrlabtest.adapters.EntityAdapter;
import com.ntrlab.ntrlabtest.models.Entity;
import com.ntrlab.ntrlabtest.models.ObjectFetcher;

public class Loading extends AsyncTask<Void, Void, Entity> {
    private final String objects = "https://dl.dropboxusercontent.com/s/ufwuccum01rchdl/entity.json";
    private final String status = "https://dl.dropboxusercontent.com/s/c9o1x8i45q5872k/statuses.json";
    private Context context;
    private Entity entity;

    public Loading(Context context, Entity entity) {
        this.context = context;
        this.entity = entity;
    }

    @Override
    protected Entity doInBackground(Void... voids) {
        entity = new ObjectFetcher().fetchEntity(objects);
        return entity;
    }

    @Override
    protected void onPostExecute(Entity entity) {
        super.onPostExecute(entity);
        ((RecyclerView)((MainActivity)context)
                .findViewById(R.id.recyclerView))
                .setAdapter(new EntityAdapter(context, entity.getObjects()));
        Log.d("TEST", entity.getObjects().toString());
    }
}
