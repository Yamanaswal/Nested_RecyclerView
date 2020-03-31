package com.app.nestedrecyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    VerticalAdapter verticalAdapter;
    ArrayList<VerticalModel> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //set adapter for Vertical RecyclerView
        verticalAdapter = new VerticalAdapter(this, arrayList);
        recyclerView.setAdapter(verticalAdapter);

        setData();


    }

    private void setData() {


        for (int i = 1; i <= 5; i++) {
            VerticalModel verticalModel = new VerticalModel();

            verticalModel.setName("Title : " + i);

            ArrayList<HorizontalModel> arrayListH = new ArrayList<>();

            for (int j = 0; j <= 5; j++) {
                arrayListH.add(j,new HorizontalModel("New Data", "Dassadsadsadsadsadta"));
            }

            verticalModel.setArrayList(arrayListH);
            arrayList.add(verticalModel);
        }
        verticalAdapter.notifyDataSetChanged();
    }
}
