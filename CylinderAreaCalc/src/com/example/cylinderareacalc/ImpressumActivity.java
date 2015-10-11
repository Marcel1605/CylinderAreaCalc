package com.example.cylinderareacalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ImpressumActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_impressum);
	}

	// Menüleiste mit Hilfe-Icon und Impressum
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.actions, menu);

		return super.onCreateOptionsMenu(menu);
	}

	// Aufrufen der HelpActivity bzw. der ImpressumActivity falls entsprechende
	// Option im Menü gewählt wird
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.help_button:
			Intent intent1 = new Intent(this, HelpActivity.class);
			startActivity(intent1);
			return true;

			// Impressum Activity aufrufen
		case R.id.impressum_button:
			// Activity bereits geöffnet, deshalb kein erneuter Aufruf der
			// Activity Impressum
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
