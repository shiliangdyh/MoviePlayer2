package com.i000phone.movieplayer2.entities;

import com.i000phone.movieplayer2.utils.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/30.
 */
public class AllSimpleMovies extends Response {
    private List<SimpleMovie> list;
    public AllSimpleMovies(String json) {
        super(json);
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.optJSONArray("results");
            list = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.optJSONObject(i);
                SimpleMovie simpleMovie = new SimpleMovie();
                simpleMovie.id = jsonObject1.optInt("id");
                simpleMovie.backdrop_path = jsonObject1.optString("poster_path");
                list.add(simpleMovie);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public List<SimpleMovie> getList() {
        return list;
    }

    public void setList(List<SimpleMovie> list) {
        this.list = list;
    }

    public static class SimpleMovie{
        private int id;
        private String backdrop_path;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }
    }
}
