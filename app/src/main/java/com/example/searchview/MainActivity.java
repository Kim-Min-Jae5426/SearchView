package com.example.searchview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> items ;
    SearchView searchView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        items = new ArrayList<>();
        items.add("캔");
        items.add("플라스틱");
        items.add("종이");
        items.add("유리");




        searchView = findViewById(R.id.searchView);
        textView = findViewById(R.id.textView);
        textView.setText(getResult());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                startActivity(intent);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                textView.setText(search(newText));
                return true;
            }
        });
    }

    private String search(String query){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++){
            String item  = items.get(i);
            if (item.toLowerCase().contains(query.toLowerCase())){
                sb.append(item);
                if (i != items.size() - 1){
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }
    private String getResult(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++){
            String item = items.get(i);
            sb.append(item);
            if (i != items.size() - 1){
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}