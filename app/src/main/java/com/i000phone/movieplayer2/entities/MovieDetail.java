package com.i000phone.movieplayer2.entities;

import com.i000phone.movieplayer2.utils.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/3/30.
 */
public class MovieDetail extends Response {
    private String backdrop_path;
    private Belong belongs_to_collection;
    private long budget;
    private String homepage;
    private int id;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private double popularity;
    private String poster_path;
    private String release_date;
    private String title;
    private double vote_average;
    private int vote_count;

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public Belong getBelongs_to_collection() {
        return belongs_to_collection;
    }

    public void setBelongs_to_collection(Belong belongs_to_collection) {
        this.belongs_to_collection = belongs_to_collection;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }
    public MovieDetail(String json) {
        super(json);
        try {
            JSONObject jsonObject = new JSONObject(json);
            backdrop_path = jsonObject.optString("backdrop_path");
            JSONObject jsonObject1 = jsonObject.optJSONObject("belongs_to_collection");
            belongs_to_collection = new Belong();
            belongs_to_collection.id = jsonObject1.optInt("id");
            belongs_to_collection.name = jsonObject1.optString("name");
            belongs_to_collection.poster_path = jsonObject1.optString("poster_path");
            belongs_to_collection.backdrop_path = jsonObject1.optString("backdrop_path");
            budget = jsonObject.optLong("budget");
            homepage = jsonObject.optString("homepage");
            id = jsonObject.optInt("id");
            imdb_id = jsonObject.optString("imdb_id");
            original_language = jsonObject.optString("original_language");
            original_title = jsonObject.optString("original_title");
            overview = jsonObject.optString("overview");
            popularity = jsonObject.optDouble("popularity");
            poster_path = jsonObject.optString("poster_path");
            release_date = jsonObject.optString("release_date");
            title = jsonObject.optString("title");
            vote_average = jsonObject.optDouble("vote_average");
            vote_count = jsonObject.optInt("vote_count");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static class Belong{
        private int id;
        private String name;
        private String poster_path;
        private String backdrop_path;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }
    }
}
