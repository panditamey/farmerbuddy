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
        videoList.add("1");
        videoList.add("2");
        videoList.add("3");
        videoList.add("4");
        videoList.add("5");
        videoList.add("6");

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,videoList);
        if (adapter!=null){
            listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        videoView.setVideoURI(Uri.parse("https://www.appsloveworld.com/wp-content/uploads/2018/10/640.mp4"));
                        break;
                    case 1:
                        videoView.setVideoURI(Uri.parse("https://archive.org/download/SampleVideo1280x7205mb/SampleVideo_1280x720_5mb.mp4"));
//                        videoView.loadUrl("https://www.appsloveworld.com/wp-content/uploads/2018/10/640.mp4");
                        break;
                    case 2:
                        videoView.setVideoURI(Uri.parse("https://r4---sn-npoeenez.googlevideo.com/videoplayback?expire=1635858061&ei=LeKAYc6MDpzAlu8P1rmGoAc&ip=154.30.183.24&id=o-AFt56aez1EeI06teD7sIDltTmNgSCXcB_3Luk21SO4PW&itag=22&source=youtube&requiressl=yes&vprv=1&mime=video%2Fmp4&ns=srLbJwiifCLrPTxgxOHEvP0G&ratebypass=yes&dur=173.244&lmt=1618063399094339&fexp=24001373,24007246&c=WEB&txp=6216222&n=Qa8gXnawV-k57A&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRgIhAImNAgkdhkgUXu_sOd4UuwPDnMV9pJD_vF8qMvnDsz1QAiEAtupkHsh6wtcxSSVZw_I7hWRM8nq1it2e0HVuhFzFk3U%3D&title=Khada+karne+ki+machine+earth+auger+machine+earth+auger+post+hole+digger+%E0%A4%96%E0%A4%A1%E0%A5%8D%E0%A4%A1%E0%A4%BE+%E0%A4%95%E0%A4%B0%E0%A4%A8%E0%A5%87+%E0%A4%95%E0%A5%80+%E0%A4%AE%E0%A4%B6%E0%A5%80%E0%A4%A8%282%29&redirect_counter=1&cm2rm=sn-cvhze7z&req_id=a390f4754f3aa3ee&cms_redirect=yes&mh=DN&mip=103.139.220.18&mm=34&mn=sn-npoeenez&ms=ltu&mt=1635836435&mv=m&mvi=4&pl=24&lsparams=mh,mip,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRQIhALSrKoNMklJjX_4yU0tvRCYrulfw3n4wfo-46mCWun1cAiB2SWTX957kPDF5pr3DLR0WAFb8i4Bb-7a51FtxFPES7w%3D%3D"));
//                        videoView.loadUrl("https://www.appsloveworld.com/wp-content/uploads/2018/10/640.mp4");
                        break;
                    case 3:
                        videoView.setVideoURI(Uri.parse("https://youtu.be/t2iQh6vOACk"));
//                        videoView.loadUrl("https://www.appsloveworld.com/wp-content/uploads/2018/10/640.mp4");
                        break;
                    case 4:
                        videoView.setVideoURI(Uri.parse("https://docs.google.com/uc?export=download&id=1L0sd3n3MWWM-pfsdNPVaSXEhz9aXXX38"));
//                        videoView.loadUrl("https://www.appsloveworld.com/wp-content/uploads/2018/10/640.mp4");
                        break;
                    case 5:
                        videoView.setVideoURI(Uri.parse("https://docs.google.com/uc?export=download&id=1L0sd3n3MWWM-pfsdNPVaSXEhz9aXXX38"));
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