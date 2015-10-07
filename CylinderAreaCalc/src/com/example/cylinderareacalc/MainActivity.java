package com.example.cylinderareacalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	protected Button _button1 = null;
	protected Button _button2 = null;
	protected EditText _editText1 = null;
	protected EditText _editText2 = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Referenzen auf View Elemente abfragen
		_button1 = (Button) findViewById(R.id.button1);
		_button2 = (Button) findViewById(R.id.button2);
		_editText1 = (EditText) findViewById(R.id.editText1);
		_editText2 = (EditText) findViewById(R.id.editText2);
		
		_button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, ResultActivity.class);
				startActivity(intent);
			}
		});
		_button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				_editText1.setText("");
				_editText2.setText("");				
			}
		});
	}
		
	
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        MenuInflater inflater = getMenuInflater();
	        inflater.inflate(R.menu.actions, menu);
	 
	        return super.onCreateOptionsMenu(menu); 
	    }
}
