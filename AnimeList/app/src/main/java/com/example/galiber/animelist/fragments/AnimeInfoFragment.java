package com.example.galiber.animelist.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.galiber.animelist.R;
import com.example.galiber.animelist.models.Anime;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnimeInfoFragment extends Fragment {
    private Anime mAnime;
    public AnimeInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_anime_info, container, false);
        TextView name=view.findViewById(R.id.tv_name);
        name.setText("Name: "+mAnime.name);
        TextView releaseDate=view.findViewById(R.id.tv_release_date);
        releaseDate.setText("Release Date: "+mAnime.releaseDate);
        TextView genres=view.findViewById(R.id.tv_genres);
        StringBuilder sb=new StringBuilder();
        sb.append("Genres: ");
        for(String s:mAnime.genres){
            sb.append(s+", ");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        genres.setText(sb.toString());
        TextView seasons=view.findViewById(R.id.tv_seasons);
        seasons.setText("Seasons: "+mAnime.seasons);
        TextView eppisodeCount=view.findViewById(R.id.tv_eppisode_count);
        eppisodeCount.setText("Episodes: "+mAnime.eppisodeCount);

        return view;
    }

    public void setAnime(Anime anime){
        mAnime=anime;
    }
}
