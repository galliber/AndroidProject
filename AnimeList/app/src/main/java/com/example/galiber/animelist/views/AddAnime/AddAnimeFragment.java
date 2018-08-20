package com.example.galiber.animelist.views.AddAnime;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.galiber.animelist.R;
import com.example.galiber.animelist.models.Anime;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddAnimeFragment extends Fragment {
    private FirebaseFirestore mFirebase;
    private Anime anime;

    public AddAnimeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_add_anime, container, false);
        mFirebase=FirebaseFirestore.getInstance();
        EditText mNameField = (EditText) view.findViewById(R.id.et_name);
        EditText mReleaseDateField = view.findViewById(R.id.et_release_date);
        EditText mGenresField = view.findViewById(R.id.et_genres);
        EditText mSeasonsField = view.findViewById(R.id.et_seasons);
        EditText mEpisodesField = view.findViewById(R.id.et_episodes);
        Button mAddButton = view.findViewById(R.id.btn_add);
        mAddButton.setText("Add Anime");
        String[] pars=new String[5];

        mAddButton.setOnClickListener((item)->{

            pars[0]=mNameField.getText().toString();
            pars[1]=mReleaseDateField.getText().toString();
            pars[2]=mGenresField.getText().toString();
            pars[3]=mSeasonsField.getText().toString();
            pars[4]=mEpisodesField.getText().toString();
            if(pars[0].length()==0||pars[1].length()==0|pars[2].length()==0||pars[3].length()==0||pars[4].length()==0){
                Toast.makeText(getContext(), "Fill all blanks!", Toast.LENGTH_SHORT).show();
            }
            else {

                anime = new Anime(pars[0], pars[1], Integer.valueOf(pars[3]), Integer.parseInt(pars[4]), Arrays.stream(pars[2].split(", ")).collect(Collectors.toList()));
                anime.img = Anime.DEF_IMG;

                mFirebase.collection("allAnimes").add(anime);

                Toast.makeText(getContext(), "Successfully added.", Toast.LENGTH_SHORT).show();
            }
        });



        return view;
    }

}
