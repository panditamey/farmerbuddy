package com.ameypandit.farmerbuddy;

import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class VideoActivity extends AppCompatActivity {
    VideoView videoView;
    ListView listView;
    ArrayList<String>videoList;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        videoView=findViewById(R.id.videoview);
        listView=findViewById(R.id.lvideo);
        videoList= new ArrayList<>();
        videoList.add("\uD83D\uDCF1 How to Use FarmerBuddy ?? ");
        videoList.add("\uD83C\uDF0D Hydrophonics I ");
        videoList.add("\uD83D\uDCA7 Hydrophonics II");
        videoList.add("\uD83C\uDF3F Green Vegetables Technique I");
        videoList.add("\uD83C\uDF31 Green Vegetables Technique II");
        videoList.add(" \uD83C\uDF45 Green House Tomato");
        videoList.add("\uD83C\uDF3E Horticulture");

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,videoList);
        if (adapter!=null){
            listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        videoView.setVideoURI(Uri.parse("https://farmvtut.ameypandit.me/0:/Farmer%20Buddy%20Showcase%20video.mp4"));
                        break;
                    case 1:
                        videoView.setVideoURI(Uri.parse("https://farmertut.ameypandit.workers.dev/0:/America%20Modern%20Carrot%20Farming!%20%E0%A4%97%E0%A4%BE%E0%A4%9C%E0%A4%B0%20%E0%A4%95%E0%A5%80%20%E0%A4%96%E0%A5%87%E0%A4%A4%E0%A5%80%20(1).mp4"));
                        break;
                    case 2:
                        videoView.setVideoURI(Uri.parse("https://farmertut.ameypandit.workers.dev/0:/videoplayback.mp4"));
//                        videoView.loadUrl("https://www.appsloveworld.com/wp-content/uploads/2018/10/640.mp4");
                        break;
                    case 3:
                        videoView.setVideoURI(Uri.parse("https://farmertut.ameypandit.workers.dev/0:/videoplayback%20(1).mp4"));
//                        videoView.loadUrl("https://www.appsloveworld.com/wp-content/uploads/2018/10/640.mp4");
                        break;
                    case 4:
                        videoView.setVideoURI(Uri.parse("https://farmertut.ameypandit.workers.dev/0:/videoplayback%20(2).mp4"));
//                        videoView.loadUrl("https://www.appsloveworld.com/wp-content/uploads/2018/10/640.mp4");
                        break;
                    case 5:
                        videoView.setVideoURI(Uri.parse("https://farmertut.ameypandit.workers.dev/0:/videoplayback%20(3).mp4"));
//                        videoView.loadUrl("https://www.appsloveworld.com/wp-content/uploads/2018/10/640.mp4");
                        break;
                    case 6:
                        videoView.setVideoURI(Uri.parse("https://farmertut.ameypandit.workers.dev/0:/videoplayback%20(4).mp4"));
//                        videoView.loadUrl("http://download.samplelib.com/mp4/sample-30s.mp4");
                        break;
                    default:
                        break;
                }
                videoView.setMediaController(new MediaController(VideoActivity.this));
                videoView.requestFocus();
                videoView.start();


            }
        });
        }else{}
    }
}