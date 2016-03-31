package com.i000phone.movieplayer2.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.i000phone.movieplayer2.DetailActivity;
import com.i000phone.movieplayer2.R;
import com.i000phone.movieplayer2.adapters.ImageAdapter;
import com.i000phone.movieplayer2.adapters.ImageAdapter1;
import com.i000phone.movieplayer2.entities.AllSimpleMovies;
import com.i000phone.movieplayer2.utils.HttpTask;
import com.i000phone.movieplayer2.utils.PathUtil;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends Fragment implements HttpTask.Callback<AllSimpleMovies>, AdapterView.OnItemClickListener {


    private GridView gridView;
    private ImageAdapter adapter;

    public ImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridView = ((GridView) view.findViewById(R.id.grid_image));
        adapter = new ImageAdapter(getContext(),new ArrayList<AllSimpleMovies.SimpleMovie>());
        gridView.setAdapter(adapter);
        HttpTask<AllSimpleMovies> task = new HttpTask<>(AllSimpleMovies.class, this);
        task.execute(PathUtil.getMoviesInfoUrl(1,"zh"));
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void doResponse(AllSimpleMovies allSimpleMovies) {
        adapter.addAll(allSimpleMovies.getList());
    }

    @Override
    public void doFailure(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
}
