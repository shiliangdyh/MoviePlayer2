package com.i000phone.movieplayer2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        long id = getIntent().getLongExtra("id", -1);
//        Toast.makeText(DetailActivity.this, "id="+id, Toast.LENGTH_SHORT).show();

    }
}
