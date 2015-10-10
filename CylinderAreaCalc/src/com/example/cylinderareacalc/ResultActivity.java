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
	
	
	//Werte von String in Double umwandeln
		  String r = et1.getText().toString(); 
		  double radius = Double.parseDouble(r);
		  String h = et2.getText().toString();
		  double hoehe = Double.parseDouble(h);
	
	//Berechnungen durchführen
		  double _umfang = 2*radius*Math.PI;
		  double _grundflaeche = radius*radius*Math.PI;
		  double _mantelflaeche = 2*radius*hoehe*Math.PI;
		  double _oberflaeche = 2*_grundflaeche+_mantelflaeche;
		  double _volumen = Math.PI*radius*radius*hoehe;
		  
	//Ergebnisse runden
		  _umfang = Math.round(_umfang*1000)/1000.0;
		  _grundflaeche = Math.round(_grundflaeche*1000)/1000.0;
		  _mantelflaeche = Math.round(_mantelflaeche*1000)/1000.0;
		  _oberflaeche = Math.round(_oberflaeche*1000)/1000.0;
		  _volumen = Math.round(_volumen*1000)/1000.0;
		  
	//Werte von Double in String umwandeln
		  String umfang = String.valueOf(_umfang);
		  String grundflaeche = String.valueOf(_grundflaeche);
		  String mantelflaeche = String.valueOf(_mantelflaeche);
		  String oberflaeche = String.valueOf(_oberflaeche);
		  String volumen = String.valueOf(_volumen);

	//Werte zur Anzeige bringen
		  EditText et3 = (EditText) findViewById(R.id.editText3);
	  	  et3.setText(umfang);
	  	  EditText et4 = (EditText) findViewById(R.id.editText4);
	  	  et4.setText(grundflaeche);
	  	  EditText et5 = (EditText) findViewById(R.id.editText5);
	  	  et5.setText(mantelflaeche);
	  	  EditText et6 = (EditText) findViewById(R.id.editText6);
	  	  et6.setText(oberflaeche);
	  	  EditText et7 = (EditText) findViewById(R.id.editText7);
	  	  et7.setText(volumen);
	  	  		  	
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
		
		//Der Zurück-Button gibt die vom Nutzer auf der MainActivity angegebenen Werte wieder zurück
		if ( view == R.id.backbutton1){
			EditText et1 = (EditText) findViewById(R.id.editText1);
			String radiusZurueckgeben = et1.getText().toString();
			
			EditText et2 = (EditText) findViewById(R.id.editText2);
	  		String hoeheZurueckgeben = et2.getText().toString();
	  		
	  		Intent intent = new Intent();
	  		intent.putExtra("rueckgabeRadius", radiusZurueckgeben);
	  		intent.putExtra("rueckgabeHoehe", hoeheZurueckgeben);
	  		setResult(RESULT_OK, intent);
	  		finish();			
		}
		
		//Der "neue Berechnung" Button ruft die MainActivity mit leeren Eingabefeldern auf
		else if ( view == R.id.backbutton2){
			Intent i = new Intent(ResultActivity.this, MainActivity.class);
			startActivity(i);
			finish();
		}
	}
	//Zurück-Button des Systems soll dasselbe bewirken wie backbutton1
	@Override
	public void onBackPressed(){
		EditText et1 = (EditText) findViewById(R.id.editText1);
		String radiusZurueckgeben = et1.getText().toString();
		
		EditText et2 = (EditText) findViewById(R.id.editText2);
  		String hoeheZurueckgeben = et2.getText().toString();
  		
  		Intent intent = new Intent();
  		intent.putExtra("rueckgabeRadius", radiusZurueckgeben);
  		intent.putExtra("rueckgabeHoehe", hoeheZurueckgeben);
  		setResult(RESULT_OK, intent);
  		finish();
	}
}
