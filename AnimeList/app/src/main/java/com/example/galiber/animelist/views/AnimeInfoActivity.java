package com.example.galiber.animelist.views;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.galiber.animelist.R;
import com.example.galiber.animelist.fragments.AnimeInfoFragment;
import com.example.galiber.animelist.models.Anime;

public class AnimeInfoActivity extends AppCompatActivity {
    private AnimeInfoFragment mAnimeInfoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_info);

        Intent intent=getIntent();
        Anime anime=(Anime)intent.getSerializableExtra("name");

        mAnimeInfoFragment=new AnimeInfoFragment();
        mAnimeInfoFragment.setAnime(anime);

        getFragmentManager().beginTransaction().replace(R.id.content2, mAnimeInfoFragment).commit();

    }
}
