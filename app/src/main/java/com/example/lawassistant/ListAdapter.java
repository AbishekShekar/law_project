package com.example.lawassistant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<ListData> {

    public ListAdapter(
            @NonNull Context context,
            ArrayList<ListData> dataArrayList
    ) {
        super(context, R.layout.list_item, dataArrayList);
    }

    @NonNull
    @Override
    public View getView(
            int position,
            @Nullable View convertView,
            @NonNull ViewGroup parent
    ) {

        ListData advocate = getItem(position);

        if (convertView == null) {

            convertView =
                    LayoutInflater.from(getContext())
                            .inflate(
                                    R.layout.list_item,
                                    parent,
                                    false
                            );
        }

        ImageView advocateImage =
                convertView.findViewById(R.id.listImage);

        TextView advocateName =
                convertView.findViewById(R.id.listName);

        TextView specialization =
                convertView.findViewById(R.id.listSpecialization);

        TextView experience =
                convertView.findViewById(R.id.listExperience);

        TextView location =
                convertView.findViewById(R.id.listLocation);

        RatingBar ratingBar =
                convertView.findViewById(R.id.listRating);

        advocateImage.setImageResource(
                advocate.getImage()
        );

        advocateName.setText(
                advocate.getName()
        );

        specialization.setText(
                advocate.getSpecialization()
        );

        experience.setText(
                "Experience: "
                        + advocate.getExperience()
        );

        location.setText(
                advocate.getLocation()
        );

        ratingBar.setRating(
                advocate.getRating()
        );

        return convertView;
    }
}