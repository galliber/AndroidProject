package com.example.galiber.animelist.views.AddAnime;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.galiber.animelist.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddAnimeFragment extends Fragment {

    public AddAnimeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_add_anime, container, false);
        EditText mNameField = (EditText) view.findViewById(R.id.et_name);
        EditText mReleaseDateField = view.findViewById(R.id.et_release_date);
        EditText mGenresField = view.findViewById(R.id.et_genres);
        EditText mSeasonsField = view.findViewById(R.id.et_seasons);
        EditText mEpisodesField = view.findViewById(R.id.et_episodes);
        Button mAddButton = view.findViewById(R.id.btn_add);
        mAddButton.setText("Add Anime");

        mAddButton.setOnClickListener((item)->{
            Toast.makeText(getContext(),mNameField.getText(), Toast.LENGTH_SHORT).show();
        });



        return view;
    }

}
