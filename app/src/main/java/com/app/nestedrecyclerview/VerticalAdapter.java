package com.app.nestedrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.VerticalHolder> {

    Context context;
    ArrayList<VerticalModel> arrayList;

    public VerticalAdapter(Context context, ArrayList<VerticalModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public VerticalHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical, parent, false);
        return new VerticalHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalHolder holder, int position) {
        final VerticalModel verticalModel = arrayList.get(position);
        String title = verticalModel.getName();

        ArrayList<HorizontalModel> singleItem = verticalModel.getArrayList();

        holder.title.setText(title);

        //set up Horizontal Recyclerview

        HorizontalAdapter horizontalAdapter = new HorizontalAdapter(context, singleItem);
        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        holder.recyclerView.setAdapter(horizontalAdapter);

        holder.more_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, verticalModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class VerticalHolder extends RecyclerView.ViewHolder {

        TextView title;
        RecyclerView recyclerView;
        Button more_button;

        public VerticalHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            recyclerView = itemView.findViewById(R.id.recyclerView1);
            more_button = itemView.findViewById(R.id.more_button);

        }
    }
}
