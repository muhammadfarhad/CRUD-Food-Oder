package com.example.crudfoododer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.crudfoododer.Adapters.OdersAdapter;
import com.example.crudfoododer.DBHelper.DBHelper;
import com.example.crudfoododer.Models.OderModal;
import com.example.crudfoododer.databinding.ActivityOderBinding;

import java.util.ArrayList;

public class OderActivity extends AppCompatActivity {

    ActivityOderBinding oderBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        oderBinding = ActivityOderBinding.inflate(getLayoutInflater());
        setContentView(oderBinding.getRoot());


        DBHelper helper = new DBHelper(this);
        ArrayList<OderModal> list = helper.getOrder();


        OdersAdapter odersAdapter = new OdersAdapter(list,this);
        oderBinding.oderRecyclerView.setAdapter(odersAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        oderBinding.oderRecyclerView.setLayoutManager(linearLayoutManager);

    }
}