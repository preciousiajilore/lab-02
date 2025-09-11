package com.example.listycisty_preciousajilore;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //Declare the variables so that you will be able to reference it later
    ListView cityList;
    ArrayAdapter<City> cityAdapter;
    ArrayList<City> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        cityList = findViewById(R.id.city_list);
        EditText inputCity = findViewById(R.id.inputCity);
        Button addButton = findViewById(R.id.add_button);
        Button deleteButton = findViewById(R.id.delete_button);
        Button confirmButton = findViewById(R.id.confirm_button);

        inputCity.setVisibility(TextView.INVISIBLE);
        deleteButton.setEnabled(false);


        //Only allow when row is selected


        cityList.setOnItemClickListener((parent, view, position, id) -> {
            deleteButton.setEnabled(true);
        });

        //TODO:Add the "add" button
        addButton.setOnClickListener(v -> {
            //Text box should appear set the textview visibility to true
            inputCity.setVisibility(TextView.VISIBLE);

        });

        //TODO: Add the confirm button to add the city to the list
        confirmButton.setOnClickListener(v -> {
            String newStr = inputCity.getText().toString().trim();
            if (!newStr.isEmpty()) {

                City newCity = new City(newStr);
                dataList.add(newCity);
                cityAdapter.notifyDataSetChanged();
                inputCity.setText("");
                inputCity.setVisibility(TextView.INVISIBLE);

                //
            }

        });


        //TODO:Add the "delete" button
        deleteButton.setOnClickListener(v -> {
            int selectedPosition = cityList.getCheckedItemPosition();
            if (selectedPosition != ListView.INVALID_POSITION) {

                dataList.remove(selectedPosition);
                cityAdapter.notifyDataSetChanged();

                deleteButton.setEnabled(false);
                cityList.clearChoices();

            }
        });


        String []cities = {"Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi"};

        dataList = new ArrayList<>();
        dataList.add(new City("Edmonton"));
        dataList.add(new City("Vancouver"));
        dataList.add(new City("Moscow"));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}