package com.example.galiber.animelist.models;


import java.io.Serializable;
import java.util.List;

public class Anime implements Serializable{
   public static final String DEF_IMG="https://firebasestorage.googleapis.com/v0/b/androidproject-9937a.appspot.com/o/def.jpg?alt=media&token=f8fcccc5-5d24-45ff-a754-2754a62775c7";
    private static final long serialVersionUID=1L;
    public String name;
    public String releaseDate;
    public int seasons;
    public int eppisodeCount;
    public List<String> genres;
    public String img;

    @Override
    public String toString(){
        return name;
    }

    public Anime(String name, String releaseDate, int seasons, int eppisodeCount, List<String> genres) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.seasons = seasons;
        this.eppisodeCount = eppisodeCount;
        this.genres = genres;
    }

    public Anime() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
