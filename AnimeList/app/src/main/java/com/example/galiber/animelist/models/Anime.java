package com.example.galiber.animelist.models;


import java.io.Serializable;
import java.util.List;

public class Anime implements Serializable{
    private static final long serialVersionUID=1L;
    public String name;
    public String releaseDate;
    public int seasons;
    public int eppisodeCount;
    public List<String> genres;

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
