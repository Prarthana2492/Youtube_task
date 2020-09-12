package com.example.farmpe_stream.Activity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.farmpe_stream.R;
import com.example.farmpe_stream.Video_Adapter;
import com.example.farmpe_stream.Video_Bean;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import com.google.android.youtube.player.YouTubeBaseActivity;

import static com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import static com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import static com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import static com.google.android.youtube.player.YouTubePlayer.Provider;

import java.util.ArrayList;
import java.util.List;

public class Video_Activity extends YouTubeBaseActivity implements OnInitializedListener {
    public static final String API_KEY = "AIzaSyBxiaZr07X2USYY15-NNCD5LASvtwpK9EY";
    //AIzaSyBxiaZr07X2USYY15-NNCD5LASvtwpK9EY
    //https://www.youtube.com/watch?v=<VIDEO_ID>
    //  https://www.youtube.com/watch?v=HFUPgP7wPpE
    public static final String VIDEO_ID = "EG397TcQe-I";
ImageView logout_lay;
    TextView login_button;
    RecyclerView recylr_2;
    private List<Video_Bean> newOrderBeansList = new ArrayList<>();
    Video_Adapter video_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_activity);

        recylr_2 = findViewById(R.id.recylr_2);

        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);
        youTubePlayerView.initialize(API_KEY, this);
        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);

        recylr_2.setLayoutManager(mLayoutManager);
        Video_Bean item1    =  new Video_Bean("Amazing Agriculture","Technology - Bottle",R.drawable.organic);
        Video_Bean item2    =  new Video_Bean("Amazing Agriculture","Technology - Bottle",R.drawable.plantation);
        Video_Bean item3    =  new Video_Bean("Amazing Agriculture","Technology - Bottle",R.drawable.vegetables);
        Video_Bean item4    =  new Video_Bean("Amazing Agriculture","Technology - Bottle",R.drawable.organic);
        Video_Bean item5    =  new Video_Bean("Amazing Agriculture","Technology - Bottle",R.drawable.plantation);


        newOrderBeansList.clear();
        newOrderBeansList.add(item1);
        newOrderBeansList.add(item2);
        newOrderBeansList.add(item3);
        newOrderBeansList.add(item4);
        newOrderBeansList.add(item5);




        System.out.println("newOrderBeansListvsdvdv"+newOrderBeansList.size());
        video_adapter = new Video_Adapter(this,newOrderBeansList);
        recylr_2.setAdapter(video_adapter);




    }
    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult result) {
        Toast.makeText(this, "Failed to initialize.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
        if(null== player) return;

        // Start buffering
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
        }
//8008899062
        // Add listeners to YouTubePlayer instance
        player.setPlayerStateChangeListener(new PlayerStateChangeListener() {
            @Override public void onAdStarted() { }
            @Override public void onError(YouTubePlayer.ErrorReason arg0) { }
            @Override public void onLoaded(String arg0) { }
            @Override public void onLoading() { }
            @Override public void onVideoEnded() { }
            @Override public void onVideoStarted() { }
        });


        player.setPlaybackEventListener(new PlaybackEventListener() {
            @Override public void onBuffering(boolean arg0) { }
            @Override public void onPaused() { }
            @Override public void onPlaying() { }
            @Override public void onSeekTo(int arg0) { }
            @Override public void onStopped() { }
        });
    }

}
