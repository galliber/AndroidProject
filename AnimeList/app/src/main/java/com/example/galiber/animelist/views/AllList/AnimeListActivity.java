package com.example.galiber.animelist.views.AllList;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.galiber.animelist.R;
import com.example.galiber.animelist.models.Anime;
import com.example.galiber.animelist.utils.Navigator;
import com.example.galiber.animelist.views.AddAnime.AddAnimeActivity;
import com.example.galiber.animelist.views.Info.AnimeInfoActivity;
import com.example.galiber.animelist.views.MyList.MyListActivity;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class AnimeListActivity extends AppCompatActivity implements Navigator {

    private AllListFragment allListFragment;
    private Toolbar mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_list);

        allListFragment=new AllListFragment();

        allListFragment.setNavigator(this);

        getFragmentManager().beginTransaction().replace(R.id.content, allListFragment).commit();

        mDrawer=findViewById(R.id.tb_drawer);

        setupDrawer();
    }

    private void setupDrawer() {
        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem allAnimeItem = new PrimaryDrawerItem().withIdentifier(1).withIcon(R.drawable.material_drawer_circle_mask).withName("All Anime List");
        PrimaryDrawerItem myAnimeItem = new PrimaryDrawerItem().withIdentifier(2).withIcon(R.drawable.common_full_open_on_phone).withName("My Anime List");
        PrimaryDrawerItem addAnimeItem= new PrimaryDrawerItem().withIdentifier(3).withIcon(R.drawable.common_full_open_on_phone).withName("Add Anime");


//create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mDrawer)
                .addDrawerItems(
                        allAnimeItem,
                        new DividerDrawerItem(),
                        myAnimeItem,
                        new DividerDrawerItem(),
                        addAnimeItem
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        navigate(drawerItem.getIdentifier());
                        return false;
                    }
                })
                .build();
    }

    void navigate(long n){
        if(n==1){
            Intent intent=new Intent(this, AnimeListActivity.class);
            startActivity(intent);
        }
        else if(n==2){
            Intent intent=new Intent(this, MyListActivity.class);
            startActivity(intent);
        }
        else if(n==3){
            Intent intent=new Intent(this, AddAnimeActivity.class);
            startActivity(intent);
        }
        return;
    }

    @Override
    public void navigate(Anime anime) {
        Intent intent=new Intent(this, AnimeInfoActivity.class);
        Anime a=anime;
        intent.putExtra("anime",anime);
        startActivity(intent);
    }


}
