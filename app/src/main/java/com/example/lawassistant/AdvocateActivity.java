package com.example.lawassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.lawassistant.databinding.ActivityAdvocateBinding;


import java.util.ArrayList;

public class AdvocateActivity extends AppCompatActivity {

    ActivityAdvocateBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdvocateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageList = {R.drawable.ad, R.drawable.ad, R.drawable.ad, R.drawable.ad, R.drawable.ad, R.drawable.ad, R.drawable.ad};
        int[] ingredientList = {R.string.BASKAR, R.string.ARUNAN,R.string.PRABAKAR,R.string.DEEBA,R.string.NIVE, R.string.JAGAN, R.string.CHITRA};
        int[] descList = {R.string.baskarDesc, R.string.arunanDesc, R.string.prabakarDesc,R.string.deebaDesc,R.string.niveDesc, R.string.jaganDesc, R.string.chitraDesc};
        String[] nameList = {"BASKAR", "ARUNAN", "PRABAKAR", "DEEBA", "NIVE","JAGAN", "CHITRA"};
        String[] timeList = {"Defense Lawyer", " Business Lawyer ", "Constitutional Lawyer ","Family Lawyer","Mergers and Acquisitions Lawyer", "Medical Malpractice Lawyer", "Immigration Lawyer", "Labor Lawyer"};

        for (int i = 0; i < imageList.length; i++){
            listData = new ListData(nameList[i], timeList[i], ingredientList[i], descList[i], imageList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter(AdvocateActivity.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(AdvocateActivity.this, DetailedActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("time", timeList[i]);
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
}