package com.example.vocalartist;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video2);
		
		VideoView videoView = (VideoView)this.findViewById(R.id.videoView2);
	    videoView.setVideoURI(Uri.parse("android.resource://"+ getPackageName() +"/"+R.raw.most_important_decision));
	    videoView.setMediaController(new MediaController(this));
	    videoView.requestFocus();
	    videoView.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.video_activity2, menu);
		return true;
	}
	 public void finishActivity2(View v) {
	        VideoActivity2.this.finish();
	    }

}
