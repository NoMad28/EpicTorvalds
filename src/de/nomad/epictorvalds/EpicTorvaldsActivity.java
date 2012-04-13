package de.nomad.epictorvalds;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class EpicTorvaldsActivity extends Activity {
	
    private ViewPager awesomePager;
    private int NUM_AWESOME_VIEWS;
    private String[] quotes;
    private Context cxt;
    private AwesomePagerAdapter awesomeAdapter;

	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        quotes = getResources().getStringArray(R.array.quotes);
        NUM_AWESOME_VIEWS = quotes.length;
        cxt = this;
    	awesomePager = (ViewPager) findViewById(R.id.viewpager1);
    	awesomeAdapter = new AwesomePagerAdapter();
    	awesomePager.setAdapter(awesomeAdapter);
    }
    
    private class AwesomePagerAdapter extends PagerAdapter{
        
    	String[] quotes = getResources().getStringArray(R.array.quotes);
    	
        @Override
        public int getCount() {
                return NUM_AWESOME_VIEWS;
        }

    /**
     * Create the page for the given position.  The adapter is responsible
     * for adding the view to the container given here, although it only
     * must ensure this is done by the time it returns from
     * {@link #finishUpdate()}.
     *
     * @param container The containing View in which the page will be shown.
     * @param position The page position to be instantiated.
     * @return Returns an Object representing the new page.  This does not
     * need to be a View, but can be some other container of the page.
     */
        @Override
        public Object instantiateItem(View collection, int position) {
                TextView tv = new TextView(cxt);
                tv.setText(quotes[position]);
                tv.setTextColor(Color.WHITE);
                tv.setTextSize(20);
                tv.setPadding(10, 10, 10, 10);
                tv.setGravity(Gravity.CENTER);
                
                ((ViewPager) collection).addView(tv,0);
                
                return tv;
        }

    /**
     * Remove a page for the given position.  The adapter is responsible
     * for removing the view from its container, although it only must ensure
     * this is done by the time it returns from {@link #finishUpdate()}.
     *
     * @param container The containing View from which the page will be removed.
     * @param position The page position to be removed.
     * @param object The same object that was returned by
     * {@link #instantiateItem(View, int)}.
     */
        @Override
        public void destroyItem(View collection, int position, Object view) {
                ((ViewPager) collection).removeView((TextView) view);
        }

        
        
        @Override
        public boolean isViewFromObject(View view, Object object) {
                return view==((TextView)object);
        }

        
    /**
     * Called when the a change in the shown pages has been completed.  At this
     * point you must ensure that all of the pages have actually been added or
     * removed from the container as appropriate.
     * @param container The containing View which is displaying this adapter's
     * page views.
     */
        @Override
        public void finishUpdate(View arg0) {}
        

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {}

        @Override
        public Parcelable saveState() {
                return null;
        }

        @Override
        public void startUpdate(View arg0) {}

}

}