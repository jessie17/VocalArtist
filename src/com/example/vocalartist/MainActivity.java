package com.example.vocalartist;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private MediaPlayer mediaPlayer;
	
	private int playbackPosition = 0;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		Button startPlayerBtn1 = (Button)findViewById(R.id.button1);
        Button pausePlayerBtn = (Button)findViewById(R.id.button2);
        Button restartPlayerBtn = (Button)findViewById(R.id.button3);
        Button startPlayerBtn2 = (Button)findViewById(R.id.button4);
        Button sendemail = (Button)findViewById(R.id.button7);
        Button wallpaper = (Button)findViewById(R.id.button8);
        startPlayerBtn1.setOnClickListener(new OnClickListener()
        {
        	@Override
        	public void onClick(View view)
        	{
		        try 
		        {
		        	playLocalAudio_UsingDescriptor(1);
		        } catch (Exception e) 
		        {
		        	e.printStackTrace();
		        }
        	}
        });
        
	    pausePlayerBtn.setOnClickListener(new OnClickListener()
	    {
	    	@Override
	     	public void onClick(View view)
	        {
		        	if(mediaPlayer!=null)
		        	{
		        		playbackPosition = mediaPlayer.getCurrentPosition();
		        		mediaPlayer.pause();
		        	}
	        }
	    });
	        	
	    restartPlayerBtn.setOnClickListener(new OnClickListener()
	    {
	    	@Override
	        public void onClick(View view)
	        {
		        	if(mediaPlayer!=null && !mediaPlayer.isPlaying())
		        	{
		        		mediaPlayer.seekTo(playbackPosition);
		        		mediaPlayer.start();
		        	}
		    }
	    });
	    
	    startPlayerBtn2.setOnClickListener(new OnClickListener()
        {
        	@Override
        	public void onClick(View view)
        	{
		        try 
		        {
		        	
		        	playLocalAudio_UsingDescriptor(2);
		        } catch (Exception e) 
		        {
		        	e.printStackTrace();
		        }
        	}
        });
	    wallpaper.setOnClickListener(new OnClickListener()
        {
        	@Override
        	public void onClick(View view)
        	{
		        try 
		        {
		        	
		        	Intent intent = new Intent(MainActivity.this, Wallpaper.class);  
	                startActivity(intent);  
		        } catch (Exception e) 
		        {
		        	e.printStackTrace();
		        }
        	}
        });
	    
	    sendemail.setOnClickListener(new OnClickListener()
        {
        	@Override
        	public void onClick(View view)
        	{
        		Intent i = new Intent(Intent.ACTION_SEND);
        		i.setType("plain/text");
        		i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"caojiashi@gmail.com"});
        		i.putExtra(Intent.EXTRA_SUBJECT, "Adding a potential audience member on mailing list");
        		i.putExtra(Intent.EXTRA_TEXT   , "Hi Christine, I am a big fan of you. Please add me to your mailing list. ");
        		try {
        		startActivity(i);
        		} catch (android.content.ActivityNotFoundException ex) {
        		  Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        		}
        		
        	        
        	}
        });
	    
	    
	}
	
	protected void onDestroy(MediaPlayer mediaPlayer)
	{
	       	super.onDestroy();
	       	killMediaPlayer(mediaPlayer);
	}
	
	private void killMediaPlayer(MediaPlayer mediaPlayer)
	{
	   	if(mediaPlayer!=null)
	   	{
	       	try
	       	{
	       		mediaPlayer.release();
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
	    }
	 } 	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void playLocalAudio_UsingDescriptor(int i) throws Exception 
	{   AssetFileDescriptor fileDesc = null;
		if (i == 1){
			fileDesc = getResources().openRawResourceFd(R.raw.song1);
		}
		else if(i == 2){
		    fileDesc = getResources().openRawResourceFd(R.raw.song2);
		}
		if (fileDesc != null) 
		{
			mediaPlayer = new MediaPlayer();
			mediaPlayer.setDataSource(fileDesc.getFileDescriptor(), fileDesc.getStartOffset(), fileDesc.getLength());
			fileDesc.close();
			mediaPlayer.prepare();
			mediaPlayer.start();
		}
	}
	
	 public void startVideoActivity(View v) {
	        Intent intent = new Intent(MainActivity.this, VideoActivity.class);
	        startActivity(intent);
	    }
	
	public void startVideoActivity2(View v) {
	        Intent intent = new Intent(MainActivity.this, VideoActivity2.class);
	        startActivity(intent);
	    }

}
