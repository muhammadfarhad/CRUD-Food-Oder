package com.example.crudfoododer;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crudfoododer.DBHelper.DBHelper;
import com.example.crudfoododer.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding detailBinding;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailBinding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(detailBinding.getRoot());
        DBHelper helper = new DBHelper(this);

        if (getIntent().getIntExtra("type",0) == 1) {
            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String desc = getIntent().getStringExtra("desc");
            final String name = getIntent().getStringExtra("name");

            detailBinding.detailImage.setImageResource(image);
            detailBinding.detailPrice.setText(String.format("%d", price));
            detailBinding.detailDescription.setText(desc);
            detailBinding.detailSolidName.setText(name);


            detailBinding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted = helper.insertOrder(
                            detailBinding.nameBox.getText().toString(),
                            detailBinding.phoneBox.getText().toString(),
                            price,
                            image,
                            name,
                            desc,
                            Integer.parseInt(detailBinding.quantity.getText().toString())
                    );
                    if (isInserted) {
                        Toast.makeText(DetailActivity.this, "Data Success...!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailActivity.this, "Data Inserting Error...!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }else {
            int id = getIntent().getIntExtra("id",0);
            Cursor cursor = helper.getOrderById(id);
            int image  = cursor.getInt(4);
            detailBinding.detailImage.setImageResource(image);
            detailBinding.detailPrice.setText(String.format("%d", cursor.getInt(3)));
            detailBinding.detailDescription.setText(cursor.getString(5));
            detailBinding.detailSolidName.setText(cursor.getString(6));

            detailBinding.nameBox.setText(cursor.getString(1));
            detailBinding.phoneBox.setText(cursor.getString(2));
            detailBinding.btnText.setText("Update Now");
            detailBinding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isUpdated = helper.updateOrders(
                            detailBinding.nameBox.getText().toString(),
                            detailBinding.phoneBox.getText().toString(),
                            Integer.parseInt(detailBinding.detailPrice.getText().toString()),
                            image,
                            detailBinding.detailDescription.getText().toString(),
                            detailBinding.detailSolidName.getText().toString(),
                            1,
                            id);

                    if (isUpdated){
                        Toast.makeText(DetailActivity.this, "Access", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(DetailActivity.this, "Sorry", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


        detailBinding.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                detailBinding.quantity.setText(Integer.toString(counter));
            }
        });
        detailBinding.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                detailBinding.quantity.setText(Integer.toString(counter));
            }
        });
    }
}