package com.example.lawassistant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.lawassistant.databinding.ActivityAdvocateBinding;

import java.util.ArrayList;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;

public class AdvocateActivity extends AppCompatActivity {

    private ActivityAdvocateBinding binding;
    private ArrayList<ListData> advocateList;
    private ArrayList<ListData> filteredList;
    private ListAdapter adapter;
    private Spinner spinnerState;
    private Spinner spinnerDistrict;
    private Spinner spinnerFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAdvocateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        spinnerState = binding.spinnerState;
        spinnerDistrict = binding.spinnerDistrict;
        spinnerFilter = binding.spinnerFilter;



        loadAdvocates();
        setupStateSpinner();
        setupDistrictSpinner();
        setupSearch();

        adapter = new ListAdapter(this, advocateList);

        binding.listview.setAdapter(adapter);

        binding.listview.setOnItemClickListener(
                (parent, view, position, id) -> {

                    ListData selected =
                            advocateList.get(position);

                    Intent intent =
                            new Intent(
                                    AdvocateActivity.this,
                                    DetailedActivity.class
                            );


                    intent.putExtra("name", selected.getName());

                    intent.putExtra("specialization",
                            selected.getSpecialization());

                    intent.putExtra("experience",
                            selected.getExperience());

                    intent.putExtra("phone",
                            selected.getPhone());

                    intent.putExtra("email",
                            selected.getEmail());

                    intent.putExtra("location",
                            selected.getLocation());

                    intent.putExtra("rating",
                            selected.getRating());

                    intent.putExtra("desc",
                            selected.getDesc());

                    intent.putExtra("image",
                            selected.getImage());



                    startActivity(intent);
                });
    }

    private void loadAdvocates() {

        advocateList = new ArrayList<>();

        advocateList.add(new ListData(
                "BASKAR",
                "Criminal Lawyer",
                "12 Years",
                "+91 9876543210",
                "baskar@gmail.com",
                "Tamil Nadu",
                "Madurai",
                "Madurai District Court",
                4.8f,
                R.string.baskarDesc,
                R.drawable.ad
        ));

        advocateList.add(new ListData(
                "ARUNAN",
                "Business Lawyer",
                "10 Years",
                "+91 9876543211",
                "arunan@gmail.com",
                "Tamilnadu",
                "Hosur",
                "Hosur District court",
                4.9f,
                R.string.arunanDesc,
                R.drawable.ad
        ));

        advocateList.add(new ListData(
                "PRABAKAR",
                "Constitutional Lawyer",
                "15 Years",
                "+91 9876543212",
                "prabakar@gmail.com",
                "Tamilnadu",
                "Theni",
                "Theni High court",
                4.3f,
                R.string.prabakarDesc,
                R.drawable.ad
        ));

        advocateList.add(new ListData(
                "DEEBA",
                "Family Lawyer",
                "8 Years",
                "+91 9876543213",
                "deeba@gmail.com",
                "Tamilnadu",
                "coimbatore",
                "Coimbatore high court",
                4.5f,
                R.string.deebaDesc,
                R.drawable.ad
        ));

        advocateList.add(new ListData(
                "NIVE",
                "Corporate Lawyer",
                "11 Years",
                "+91 9876543214",
                "nive@gmail.com",
                "Tamilnadu",
                "Trichy",
                "Trichy district court",
                4.6f,
                R.string.niveDesc,
                R.drawable.ad
        ));

        advocateList.add(new ListData(
                "JAGAN",
                "Medical Lawyer",
                "13 Years",
                "+91 9876543215",
                "jagan@gmail.com",
                "Tamilnadu",
                "Salem",
                "Salem district court",
                4.8f,
                R.string.jaganDesc,
                R.drawable.ad
        ));

        advocateList.add(new ListData(
                "CHITRA",
                "Immigration Lawyer",
                "9 Years",
                "+91 9876543216",
                "chitra@gmail.com",
                "Tamilnadu",
                "Chennai",
                "Chennai High court",
                4.7f,
                R.string.chitraDesc,
                R.drawable.ad
        ));
    }
    private void setupStateSpinner() {

        String[] states = {
                "Tamil Nadu"
        };

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        states
                );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerState.setAdapter(adapter);
    }
    private void setupDistrictSpinner() {

        String[] districts = {
                "All",
                "Madurai",
                "Chennai",
                "Theni",
                "Salem",
                "Trichy",
                "Coimbatore",
                "Hosur"
        };

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        districts
                );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerDistrict.setAdapter(adapter);

        spinnerDistrict.setOnItemSelectedListener(
                new android.widget.AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            android.widget.AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        filterDistrict(
                                districts[position]
                        );
                    }

                    @Override
                    public void onNothingSelected(
                            android.widget.AdapterView<?> parent) {
                    }
                });
    }
    private void filterDistrict(String district) {

        filteredList = new ArrayList<>();

        for (ListData advocate : advocateList) {

            if (district.equals("All")) {

                filteredList.add(advocate);

            } else if (
                    advocate.getDistrict()
                            .equalsIgnoreCase(district)
            ) {

                filteredList.add(advocate);
            }
        }

        adapter = new ListAdapter(
                this,
                filteredList
        );

        binding.listview.setAdapter(adapter);
    }
    private void setupSearch() {

        binding.searchView.setOnQueryTextListener(
                new androidx.appcompat.widget.SearchView.OnQueryTextListener() {

                    @Override
                    public boolean onQueryTextSubmit(
                            String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(
                            String newText) {

                        searchAdvocates(newText);

                        return true;
                    }
                });
    }
    private void searchAdvocates(String text) {

        filteredList = new ArrayList<>();

        for (ListData advocate : advocateList) {

            if (
                    advocate.getName()
                            .toLowerCase()
                            .contains(
                                    text.toLowerCase()
                            )

                            ||

                            advocate.getSpecialization()
                                    .toLowerCase()
                                    .contains(
                                            text.toLowerCase()
                                    )

                            ||

                            advocate.getDistrict()
                                    .toLowerCase()
                                    .contains(
                                            text.toLowerCase()
                                    )
            ) {

                filteredList.add(advocate);
            }
        }

        adapter = new ListAdapter(
                this,
                filteredList
        );

        binding.listview.setAdapter(adapter);
    }
}