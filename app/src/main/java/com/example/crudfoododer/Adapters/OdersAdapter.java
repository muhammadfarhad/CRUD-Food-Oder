package com.example.crudfoododer.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.sax.ElementListener;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudfoododer.DBHelper.DBHelper;
import com.example.crudfoododer.DetailActivity;
import com.example.crudfoododer.Models.OderModal;
import com.example.crudfoododer.OderActivity;
import com.example.crudfoododer.R;

import java.nio.file.attribute.PosixFileAttributes;
import java.util.ArrayList;

public class OdersAdapter extends RecyclerView.Adapter<OdersAdapter.viewHolder> {

    ArrayList<OderModal> list;
    Context context;

    public OdersAdapter(ArrayList<OderModal> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.oder_semple, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final OderModal modal = list.get(position);
        holder.oderimage.setImageResource(modal.getOderImage());
        holder.odername.setText(modal.getOderName());
        holder.oderNumber.setText(modal.getOderNumber());
        holder.oderprince.setText(modal.getOderPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("id", Integer.parseInt(modal.getOderNumber()));
                intent.putExtra("type",2);
                context.startActivity(intent);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Alert Dialog")
                        .setIcon(R.drawable.alart)
                        .setMessage("Are you sure to delete this item..!")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DBHelper helper = new DBHelper(context);
                                if (helper.oderDelete(modal.getOderNumber()) > 0){
                                    Toast.makeText(context, "Delete Data", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
                return false;

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView oderimage;
        TextView odername, oderNumber, oderprince;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            oderimage = itemView.findViewById(R.id.oderImageView);
            odername = itemView.findViewById(R.id.oderItemName);
            oderNumber = itemView.findViewById(R.id.oderItemNumber);
            oderprince = itemView.findViewById(R.id.oderItemPrice);
        }
    }
}
