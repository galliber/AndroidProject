package com.example.galiber.animelist.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.galiber.animelist.R;
import com.example.galiber.animelist.models.Anime;
import com.example.galiber.animelist.repositories.FirebaseRepository;
import com.example.galiber.animelist.repositories.base.Repository;
import com.example.galiber.animelist.utils.Navigator;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Document;

import java.util.List;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView mAnimeNames;
    private ArrayAdapter<String> mAnimeNamesAdapter;
    private FirebaseFirestore mFirebase;
    private Repository mAnimeNamesRepository;
    private Navigator mNavigator;
    private List<Anime> mAnimes;

    public AllListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_all_list, container, false);

        mFirebase = FirebaseFirestore.getInstance();

        mAnimeNames=view.findViewById(R.id.lv_allAnimes);
        mAnimeNamesAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1);

        mAnimeNames.setAdapter(mAnimeNamesAdapter);
        mAnimeNames.setOnItemClickListener(this);

        mAnimeNamesRepository = new FirebaseRepository<Anime>("allAnimes", Anime.class);

//        mAnimeNamesRepository.getAll(animes->{
//            for(Anime anime:animes){
//                mAnimeNamesAdapter.add(anime.name);
//            }
//        });

        mFirebase.collection("allAnimes").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                mAnimes=task.getResult().toObjects(Anime.class);
                for(Anime anime: mAnimes){
                    mAnimeNamesAdapter.add(anime.name);
                }
            }
        });


        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Anime animee=mAnimes.get(position);
        mNavigator.navigate(animee);
    }

    public void setNavigator(Navigator navigator){
        mNavigator=navigator;
    }
}
