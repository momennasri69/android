package com.example.myprojectuni;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class product extends AppCompatActivity {

    private String name;
    private Double price;
    private Integer id;
    private List<product> products = new ArrayList<>();
    public product(Integer id,String name,Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public Double getPrice() {
        return price;
    }
    public Integer getId() {
        return id;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void click_labester(View view) {
        Intent intent = new Intent(getApplicationContext(), labester_product.class);
        startActivity(intent);
    }

    public void click_meat(View view) {
        Intent meat = new Intent(getApplicationContext(), meat_product.class);
        startActivity(meat);
    }
    public void click_chiken(View view) {
        Intent chiken = new Intent(getApplicationContext(), chiken_product.class);
        startActivity(chiken);
    }
    public void click_fish(View view) {
        Intent fish = new Intent(getApplicationContext(), fish_product.class);
        startActivity(fish);
    }
    public void click_basket(View view) {
        Intent basket = new Intent(getApplicationContext(), basket.class);
        startActivity(basket);
    }
    public void click_back(View view) {
        Intent back = new Intent(getApplicationContext(), home.class);
        startActivity(back);
    }
}