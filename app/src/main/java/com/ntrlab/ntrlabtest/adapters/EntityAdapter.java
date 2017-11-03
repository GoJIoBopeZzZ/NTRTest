package com.ntrlab.ntrlabtest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ntrlab.ntrlabtest.R;
import com.ntrlab.ntrlabtest.models.NTRObject;

import java.util.List;

public class EntityAdapter extends RecyclerView.Adapter<EntityAdapter.EntityHolder> {
    private Context context;
    private List<NTRObject> list;

    public EntityAdapter(Context context, List<NTRObject> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public EntityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.entity_item, parent, false);
        return new EntityHolder(view);
    }

    @Override
    public void onBindViewHolder(EntityHolder holder, int position) {
        holder.bindData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class EntityHolder extends RecyclerView.ViewHolder {

        private final String TAG = "EntityHolder";

        private TextView tvName;
        private TextView tvTitle;
        private TextView tvId;

        EntityHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvId = itemView.findViewById(R.id.tvId);
            Log.d(TAG, "Created new Holder");
        }

        void bindData(NTRObject entry) {
            tvName.setText("Name - " + entry.getName());
            tvTitle.setText("Title - " + entry.getTitle());
            tvId.setText("ID - " + entry.getObjectID());
        }
    }
}
