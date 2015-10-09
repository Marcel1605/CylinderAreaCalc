package com.example.cylinderareacalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends Activity implements OnClickListener{
	
	protected Button _button1 = null;
	protected Button _button2 = null;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_result);
	  
	  //Referenzen auf View Elemente abfragen
	  		_button1 = (Button) findViewById(R.id.backbutton1);
	  		_button2 = (Button) findViewById(R.id.backbutton2);
	  		
	  		_button1.setOnClickListener(this);
	  		_button2.setOnClickListener(this);
	  		
	 //Von MainActivity übergebene Werte zur Anzeige bringen
	  		Intent intent = getIntent();
	  		Bundle bundleExtras = intent.getExtras();
	  		String uebergebenerRadius = bundleExtras.getString("eingabeRadius");
	  		EditText et1 = (EditText) findViewById(R.id.editText1);
	  		et1.setText(uebergebenerRadius);
	  		String uebergebeneHoehe = bundleExtras.getString("eingabeHoehe");
	  		EditText et2 = (EditText) findViewById(R.id.editText2);
	  		et2.setText(uebergebeneHoehe);
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
