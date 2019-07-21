package com.otemainc.thevendor;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AgricultureItemsAdapter extends RecyclerView.Adapter<AgricultureItemsAdapter.ViewHolder> {
    private Context context;
    private List<ClientUploads> uploads;

    public AgricultureItemsAdapter(Context context, List<ClientUploads> uploads) {
        this.uploads = uploads;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_orders, parent, false);
        AgricultureItemsAdapter.ViewHolder viewHolder = new AgricultureItemsAdapter.ViewHolder(v);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(AgricultureItemsAdapter.ViewHolder holder, int position) {
        ClientUploads upload = uploads.get(position);
        holder.textViewName.setText(upload.getName());
        holder.textdescription.setText( "Ksh" + upload.getCost());
       holder.textSchoolName.setText(upload.getSchool());
    }

    @Override
    public int getItemCount() {
        return uploads.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName, textdescription, textcost, textSchoolName;
        public ViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textdescription = itemView.findViewById(R.id.textdescription);
            textSchoolName = itemView.findViewById(R.id.textSchoolName);
        }
    }
}
