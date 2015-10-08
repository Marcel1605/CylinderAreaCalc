package com.example.cylinderareacalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ResultActivity extends Activity implements OnClickListener{
	
	protected Button _button1 = null;
	protected Button _button2 = null;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_result);
	    // TODO Auto-generated method stub
	    
	  //Referenzen auf View Elemente abfragen
	  		_button1 = (Button) findViewById(R.id.backbutton1);
	  		_button2 = (Button) findViewById(R.id.backbutton2);
	  		
	  		_button1.setOnClickListener(this);
	  		_button2.setOnClickListener(this);
	}
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actions, menu);
 
        return super.onCreateOptionsMenu(menu); 
    }
	@Override
	public void onClick(View v) {
		int view = v.getId();
		// TODO Auto-generated method stub
		
		if ( view == R.id.backbutton1){
			finish();
		}
		else if ( view == R.id.backbutton2){
			Intent i = new Intent(ResultActivity.this, MainActivity.class);
			startActivity(i);
			finish();
		}
	}
	
}
