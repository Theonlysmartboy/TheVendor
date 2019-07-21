package com.otemainc.thevendor;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by Tosby on 1/1/2018.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private Context context;
    private List<Upload> uploads;
    Menu menu;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference(Constants.DATABASE_PATH_UPLOADS);

    public ItemsAdapter(Context context, List<Upload> uploads) {
        this.uploads = uploads;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_items, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        final Upload upload = uploads.get(position);
        holder.textViewName.setText(upload.getName());
        holder.textdescription.setText(upload.getDescription());
        holder.textcost.setText( "Ksh" + upload.getCost());
        holder.buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + uploads.get(position));
                String category = "Bought";
                String school = upload.getCategory();
                String name = upload.getName();
                String cost = upload.getCost();
                if(upload.getCategory().equals("Ecohim")){
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("+254722720646", null, "Hello, I am interested in buying " + upload.getName() , null, null);
                    smsManager.sendTextMessage("+254711965776", null, "Hello, I am interested in buying " + upload.getName() , null, null);
                    smsManager.sendTextMessage("+254705769867", null, "Hello, I am interested in buying " + upload.getName() , null, null);
                    Toast.makeText(context, upload.getName() + " successfully Purchased Please Visit the Stand to pay and collect", Toast.LENGTH_SHORT).show();

                }else if(upload.getCategory().equals("Agriculture")){
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("+254724215319", null, "Hello, I am interested in buying " + upload.getName() , null, null);
                    smsManager.sendTextMessage("+254711965776", null, "Hello, I am interested in buying " + upload.getName() , null, null);
                    Toast.makeText(context, upload.getName() + " successfully Purchased Please Visit the Stand to pay and collect", Toast.LENGTH_SHORT).show();

                }else if(upload.getCategory().equals("Physical & Biological Sciences")){
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("+254726685528", null, "Hello, I am interested in buying " + upload.getName() , null, null);
                    smsManager.sendTextMessage("+254711965776", null, "Hello, I am interested in buying " + upload.getName() , null, null);
                    Toast.makeText(context, upload.getName() + " successfully Purchased Please Visit the Stand to pay and collect", Toast.LENGTH_SHORT).show();

                }else if(upload.getCategory().equals("Kisumu Hotel")){
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("+254702293572", null, "Hello, I am interested in Booking " + upload.getName() , null, null);
                    smsManager.sendTextMessage("+254711965776", null, "Hello, I am interested in Booking " + upload.getName() , null, null);
                    Toast.makeText(context, upload.getName() + " successfully Booked Please Visit the Stand or Kisumu Hotel Opposite Varsity Plaza", Toast.LENGTH_SHORT).show();

                }
                //creating the upload object to store uploaded image details
                ClientUploads uploads = new ClientUploads(school, name, category, cost);

                //adding an upload to firebase database
                String uploadId = mDatabase.push().getKey();
                mDatabase.child(uploadId).setValue(uploads);
            }
        });
        Glide.with(context).load(upload.getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
            return uploads.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewName, textdescription, textcost;
        public ImageView imageView;
        public Button buy;
        public ViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textdescription = itemView.findViewById(R.id.textdescription);
            textcost = itemView.findViewById(R.id.textcost);
            imageView = itemView.findViewById(R.id.imageView);
            buy = itemView.findViewById(R.id.addToCart);
        }
    }
}

