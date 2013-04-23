package com.example.vocalartist;  
  
import android.app.Activity;  
import android.content.Context;  
import android.os.Bundle;  
import android.view.View;  
import android.view.ViewGroup;  
import android.view.Window;  
import android.view.animation.AnimationUtils;  
import android.widget.AdapterView;  
import android.widget.BaseAdapter;  
import android.widget.Gallery;  
import android.widget.ImageSwitcher;  
import android.widget.ImageView;  
import android.widget.AdapterView.OnItemSelectedListener;  
import android.widget.RelativeLayout.LayoutParams;  
import android.widget.ViewSwitcher.ViewFactory;  
  
public class Wallpaper extends Activity implements ViewFactory,  
        OnItemSelectedListener {  
    
    ImageSwitcher mSwitcher;  
    private Integer[] mThumbIds = { R.drawable.image1,  
            R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image5};  
  
    private Integer[] mImageIds = { R.drawable.image1,  
            R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image5 };  
  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.activity_wallpaper);  
        
  
        mSwitcher = (ImageSwitcher) findViewById(R.id.ImageSwitcher01);   
        mSwitcher.setFactory(this);  
        mSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));  
        mSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));  
  
        Gallery g = (Gallery) findViewById(R.id.gallery);  
 
        g.setAdapter(new ImageAdapter(this));  
        g.setOnItemSelectedListener(this);  
  
    }  
  
    public void onItemSelected(AdapterView parent, View v, int position, long id) {  
        mSwitcher.setImageResource(mImageIds[position]);  
    }  
  
    public void onNothingSelected(AdapterView parent) {  
    }  
  
    
	@Override  
    public View makeView() {  
        ImageView i = new ImageView(this);  
        i.setBackgroundColor(0xFF000000);  
        i.setScaleType(ImageView.ScaleType.FIT_CENTER);  
        i.setLayoutParams(new ImageSwitcher.LayoutParams(  
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));  
        return i;  
    }  
  
    public class ImageAdapter extends BaseAdapter {  
        private Context mContext;  
  
        public ImageAdapter(Context c) {  
            mContext = c;  
        }  
  
        public int getCount() {  
            return mThumbIds.length;  
        }  
  
        public Object getItem(int position) {  
            return position;  
        }  
  
        public long getItemId(int position) {  
            return position;  
        }  
          
 
       @Override
		public View getView(int position, View convertView, ViewGroup parent) {  
            ImageView i = new ImageView(mContext);
            i.setImageResource(mThumbIds[position]);  
            i.setAdjustViewBounds(true);  
            i.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));   
            return i;  
        }  
  
    }  
  
}  
