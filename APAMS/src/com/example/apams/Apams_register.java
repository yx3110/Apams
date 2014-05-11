package com.example.apams;

import java.io.*;
import java.net.*;

import com.example.apams.util.apamsTCPclient;
import com.example.apams.util.apams_network_package;
import com.example.apams.util.apams_network_package.packageType;

import android.*;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Apams_register extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_apams_register);

	}

	public void confirmRegister(View view) {
		EditText username = (EditText) findViewById(R.id.editText_username);
		EditText password1 = (EditText) findViewById(R.id.editText_passwordFirst);
		EditText password2 = (EditText) findViewById(R.id.editText_passwordSecond);
		EditText CID = (EditText) findViewById(R.id.editText_CID);
		String CIDStr = CID.getText().toString();
		String usernameStr = username.getText().toString();
		String password1Str = password1.getText().toString();
		String password2Str = password2.getText().toString();
		if(password1Str.length()==0 || usernameStr.length()==0|| CIDStr.length()==0){
			Context context = getApplicationContext();
			CharSequence text = "Please fill in all the fields!";
			int duration = Toast.LENGTH_SHORT;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
		}
		if (!password1Str.equals(password2Str)) {
			Context context = getApplicationContext();
			CharSequence text = "Password not match!";
			int duration = Toast.LENGTH_SHORT;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
		} else {
			try {								
				apams_network_package pack = new apams_network_package(
						usernameStr, password1Str, CIDStr, packageType.REGISTER);
				new apamsTCPclient().execute(pack);
		/*		if(answer.equals("GOOD")){
					Context context = getApplicationContext();
					CharSequence text = "Register success!";
					int duration = Toast.LENGTH_SHORT;
					Toast toast = Toast.makeText(context, text, duration);
					toast.show();

				}else if(answer.equals("Username already exist")){
					Context context = getApplicationContext();
					CharSequence text = "Username already exist,please change username!";
					int duration = Toast.LENGTH_SHORT;
					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
					username.requestFocus();

				}else{
					Context context = getApplicationContext();
					CharSequence text = "Please try again!";
					int duration = Toast.LENGTH_SHORT;
					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}
*/
				
			} catch (Exception e) {
				Log.e("exception", e.getMessage());
			}
		}
	}
}
