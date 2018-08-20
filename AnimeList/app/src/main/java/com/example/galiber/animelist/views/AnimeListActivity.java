package com.example.galiber.animelist.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.galiber.animelist.fragments.AllListFragment;
import com.example.galiber.animelist.R;
import com.example.galiber.animelist.models.Anime;
import com.example.galiber.animelist.utils.Navigator;

public class AnimeListActivity extends AppCompatActivity implements Navigator {

    private AllListFragment allListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_list);

        allListFragment=new AllListFragment();

        allListFragment.setNavigator(this);

        getFragmentManager().beginTransaction().replace(R.id.content, allListFragment).commit();
    }

    @Override
    public void navigate(Anime anime) {
        Intent intent=new Intent(this, AnimeInfoActivity.class);
        Anime a=anime;
        intent.putExtra("name",anime);
        startActivity(intent);
    }
}
