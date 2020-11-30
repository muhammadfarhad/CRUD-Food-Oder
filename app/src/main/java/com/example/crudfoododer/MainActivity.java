package com.example.crudfoododer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.crudfoododer.Adapters.MainAdapter;
import com.example.crudfoododer.Models.MainModel;
import com.example.crudfoododer.databinding.ActivityMainBinding;

import java.lang.reflect.Modifier;
import java.time.MonthDay;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.burger, "Burgur", "5", "Chicken Burger with Extra Cheese"));
        list.add(new MainModel(R.drawable.pizza, "Pizza", "10", "Pizza hut with Extra Cheese"));
        list.add(new MainModel(R.drawable.shuwarma, "Shuwarma", "15", "Shuwarma with Extra Cheese"));
        list.add(new MainModel(R.drawable.rollpratha, "Roll Pratha", "12", "Roll Pratha with Extra Cheese"));
        list.add(new MainModel(R.drawable.chicken, "Chicken", "20", "Chicken Karhaiy with Extra Cheese"));
        list.add(new MainModel(R.drawable.rice, "Rice", "25", "Biryani with Extra Cheese"));
        list.add(new MainModel(R.drawable.burger, "Burgur", "5", "Chicken Burger with Extra Cheese"));
        list.add(new MainModel(R.drawable.pizza, "Pizza", "10", "Pizza hut with Extra Cheese"));
        list.add(new MainModel(R.drawable.shuwarma, "Shuwarma", "15", "Shuwarma with Extra Cheese"));
        list.add(new MainModel(R.drawable.rollpratha, "Roll Pratha", "12", "Roll Pratha with Extra Cheese"));
        list.add(new MainModel(R.drawable.chicken, "Chicken", "20", "Chicken Karhaiy with Extra Cheese"));
        list.add(new MainModel(R.drawable.rice, "Rice", "25", "Biryani with Extra Cheese"));

        MainAdapter adapter = new MainAdapter(list, this);
        binding.recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_oder:
                startActivity(new Intent(MainActivity.this,OderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}