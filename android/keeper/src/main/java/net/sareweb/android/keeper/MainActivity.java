
package net.sareweb.android.keeper;

import net.sareweb.android.keeper.model.SystemInfo;
import net.sareweb.android.keeper.rest.SystemInfoClient;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.rest.RestService;

@EActivity(R.layout.activity_main)
public class MainActivity
    extends SherlockActivity
{

    @ViewById
    TextView hello;
    @ViewById
    ListView images_list_view;
    @RestService
    SystemInfoClient systemInfoClient;
    SystemInfo systemInfo;

    @AfterViews
    void afterViews() {
    	Log.d(tag, "Lets fetch!");
    	fetchSystemInfo();
    }

    @Background
    void fetchSystemInfo() {
    	try {
    		systemInfo = systemInfoClient.getSystemInfo();
        	if(systemInfo==null){
        		Log.d(tag, "Did not find any data! :(");
        	}
        	else{
        		drawSystemInfo();
        	}
		} catch (Exception e) {
			Log.e(tag, "Something is really wrong!");
			e.printStackTrace();
		}
    	
    }
    
    @UiThread
    void drawSystemInfo(){
    	if(systemInfo.getInfo_date()!=null){
    		hello.setText(systemInfo.getInfo_date().toString());
    	}
    	ImageAdapter imageAdapter = new ImageAdapter(this, systemInfo.getImages());
    	images_list_view.setAdapter(imageAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater();
        return true;
    }

    private final String tag = MainActivity.class.getName();
}
