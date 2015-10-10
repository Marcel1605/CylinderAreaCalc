package com.example.cylinderareacalc;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
				EditText et1 = (EditText)findViewById(R.id.editText1);
				String text1 = et1.getText().toString();
				EditText et2 = (EditText)findViewById(R.id.editText2);
				String text2 = et2.getText().toString();
				
				//User benachrichtigen falls dieser ein Eingabefeld nicht ausgefüllt hat
				if (text1 == null || text2 == null || text1.isEmpty() || text2.isEmpty()){
					Toast toast1 = 
							Toast.makeText(getApplicationContext(), "Bitte sowohl für Radius als auch für Höhe Eingaben vornehmen", Toast.LENGTH_LONG);
					toast1.show();
				}
				
				//User benachrichtigen falls eines der Eingabefelder mit der Höhe 0 ausgefüllt wurde -->unzulässig
				else if (text1.equals("0") || text2.equals("0")) {
					Toast toast2 = 
							Toast.makeText(getApplicationContext(), "Die Berechnung kann für die Eingabe 0 nicht durchgeführt werden", Toast.LENGTH_LONG);
					toast2.show();
				}
				
				//Übergabe der Eingabewerte an ResultActivity bei korrekten Angaben
				else {
				Intent intent = new Intent(MainActivity.this, ResultActivity.class);
				
				intent.putExtra("eingabeRadius", text1);
				intent.putExtra("eingabeHoehe", text2);
				
				startActivityForResult(intent, 69);
				}
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
	
	//Trägt die Werte die zuvor an die ResultActivity übergeben wurden wieder in der MainActivity ein
	@Override
	protected void onActivityResult(int resquestCode, int resultCode, Intent intent) {
		String zurueckkommenderRadius = intent.getStringExtra("rueckgabeRadius");
  		EditText et1 = (EditText) findViewById(R.id.editText1);
  		et1.setText(zurueckkommenderRadius);
  		String zurueckkommendeHoehe = intent.getStringExtra("rueckgabeHoehe");
  		EditText et2 = (EditText) findViewById(R.id.editText2);
  		et2.setText(zurueckkommendeHoehe);
		}
		
	//Menüleiste mit Hilfe-Icon und Impressum
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        MenuInflater inflater = getMenuInflater();
	        inflater.inflate(R.menu.actions, menu);
	 
	        return super.onCreateOptionsMenu(menu); 
	    }
	 
	 //Aufrufen der HelpActivity bzw. der ImpressumActivity falls entsprechende Option im Menü gewählt wird
	 @Override
		public boolean onOptionsItemSelected(MenuItem item) {
		    switch (item.getItemId()) {
		        case R.id.help_button:
		        		Intent intent1 = new Intent(this, HelpActivity.class);
		        		startActivity(intent1);
		        		return true;
		        	
		        	//Impressum Activity aufrufen
			/*
			            case R.id.impressum_button:
			        	Intent intent2 = new Intent(this, ImpressumActivity.class);
			        	startActivity(intent2);	
			        	return true;
			*/
		        default:
		            return super.onOptionsItemSelected(item);
		    }
		}
	
	 //Der System-Zurück-Button auf der MainActivity ruft ein Dialogfeld hervor, dass den User fragt ob er die App wirklich beenden möchte
	 @Override
	 public void onBackPressed(){
		 DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
			    @Override
			    public void onClick(DialogInterface dialog, int which) {
			        switch (which){
			        case DialogInterface.BUTTON_POSITIVE:
			            //Yes button clicked
			        	finish();
			            break;

			        case DialogInterface.BUTTON_NEGATIVE:
			            //No button clicked
			        	//do nothing
			            break;
			        }
			    }
			};

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Soll die Applikation wirklich beendet werden?").setPositiveButton("Ja", dialogClickListener)
			    .setNegativeButton("Nein", dialogClickListener).show();
	 }
}
