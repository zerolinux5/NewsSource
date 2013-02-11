package com.zerolinux5.newssource;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MenuActivity extends Activity {
	private static final String LOG_TAG = "ChooserActivity";
	private RadioGroup r1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		View v;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(myhandler1);
	    r1 = (RadioGroup) findViewById(R.id.radioGroup1);
	}
	
	  View.OnClickListener myhandler1 = new View.OnClickListener() {
		    public void onClick(View v) {
		      causeReturn(v);
		    }
		  };

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_menu, menu);
		return true;
	}
	
	public void causeReturn(View v) {
		EditText simpleEditText = (EditText) findViewById(R.id.editText1);
		String newString = simpleEditText.getText().toString();
		EditText simpleEditText2 = (EditText) findViewById(R.id.editText2);
		String newURL = simpleEditText2.getText().toString();	
		if (simpleEditText.length() == 0){
	        Toast toast = Toast.makeText(this, "Need to enter a Label!", Toast.LENGTH_LONG);
	        toast.show();
		} else if(simpleEditText2.length() == 0){
	        Toast toast = Toast.makeText(this, "Need to enter a URL!", Toast.LENGTH_LONG);
	        toast.show();			
		} else if(getRadioButton() == -1){
	        Toast toast = Toast.makeText(this, "Need to pick a button to replace!", Toast.LENGTH_LONG);
	        toast.show();		
		} else {
			String buttonlabel = Integer.toString(getRadioButton());
			Intent result = new Intent();
			Log.d(LOG_TAG, "Chosen: " +  newString);
			result.putExtra(MainActivity.NEW_STRING, newString);
			if(getRadioButton() == 1){
				result.putExtra(MainActivity.NEW_URL1, newURL);				
			} else if(getRadioButton() == 2){
				result.putExtra(MainActivity.NEW_URL2, newURL);				
			} else if(getRadioButton() == 3){
				result.putExtra(MainActivity.NEW_URL3, newURL);				
			}
			Log.d(LOG_TAG, "Chosen: " +  newString);
			result.putExtra(MainActivity.LABEL_NUMBER, buttonlabel);
			setResult(RESULT_OK, result);
			finish();
		}
	}

	   private int getRadioButton() {
		      int checkedRadioId = r1.getCheckedRadioButtonId();
		      switch (checkedRadioId) {
		      case R.id.radio0:
		         return 1;
		      case R.id.radio1:
		         return 2;
		      case R.id.radio2:
		         return 3;
		      default:
		    	  return -1;
		      }
		   }
}
