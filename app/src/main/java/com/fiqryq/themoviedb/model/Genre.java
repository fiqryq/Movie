package com.fiqryq.themoviedb.model;

import java.util.List;

public class Genre {

    private Genres[] genres;

    public Genres[] getGenres() {
        return genres;
    }

    public class Genres {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
