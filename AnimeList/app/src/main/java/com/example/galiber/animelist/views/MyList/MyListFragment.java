package com.example.galiber.animelist.views.MyList;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.galiber.animelist.R;
import com.example.galiber.animelist.models.Anime;
import com.example.galiber.animelist.utils.Navigator;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private FirebaseFirestore mFirebase;
    private ListView mAnimeNames;
    private ArrayAdapter<String> mAdapter;
    private Navigator mNavigator;
    private List<Anime> mAnimes;

    public MyListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_list, container, false);
        mFirebase = FirebaseFirestore.getInstance();
        mAnimeNames = view.findViewById(R.id.lv_myAnimes);
        mAdapter=new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1);
        mAnimeNames.setAdapter(mAdapter);
        mAnimeNames.setOnItemClickListener(this);

        mFirebase.collection("myAnimes").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                mAnimes=task.getResult().toObjects(Anime.class);
                for(Anime a:mAnimes){
                    mAdapter.add(a.name);
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
