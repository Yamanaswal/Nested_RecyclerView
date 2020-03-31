package com.app.nestedrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder> {

    public HorizontalAdapter(Context context, ArrayList<HorizontalModel> horizontalList) {
        this.context = context;
        this.horizontalList = horizontalList;
    }

    Context context;
    ArrayList<HorizontalModel> horizontalList;

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal, parent, false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {
        final HorizontalModel horizontalModel = horizontalList.get(position);
        holder.textView.setText(horizontalModel.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, horizontalModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.sample);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
