package com.ilham.simplepricesuggestion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Integer> prices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prices.add(1000);
        prices.add(2000);
        prices.add(5000);
        prices.add(10000);
        prices.add(20000);
        prices.add(50000);
        prices.add(100000);
    }

    public void process(View view) {
        EditText i = (EditText) findViewById(R.id.priceInput);
        Integer input = Integer.parseInt(i.getText().toString());
        List<Integer> suggestion = new ArrayList<>();
        suggestion.add(input);

        for(Integer p : prices){
            if(p > input){
                suggestion.add(p);
            }
        }

        ListView suggestionList = (ListView) findViewById(R.id.suggestionList);
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, suggestion);
        suggestionList.setAdapter(arrayAdapter);
    }
}
