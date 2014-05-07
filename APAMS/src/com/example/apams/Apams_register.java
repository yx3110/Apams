package com.example.apams;
import java.io.PrintWriter;
import java.net.Socket;

import android.*;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
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
		
		EditText username = (EditText) findViewById(R.id.editText_username);
		EditText password1 = (EditText) findViewById(R.id.editText_passwordFirst);
		EditText password2 = (EditText) findViewById(R.id.editText_passwordSecond);
	}
	
	public void confirmRegister(View view){
		EditText username = (EditText) findViewById(R.id.editText_username);
		EditText password1 = (EditText) findViewById(R.id.editText_passwordFirst);
		EditText password2 = (EditText) findViewById(R.id.editText_passwordSecond);
		String usernameStr = username.getText().toString();
		String password1Str =password1.getText().toString();
		String password2Str = password2.getText().toString();
		if(!password1Str.equals(password2Str)){
			Context context = getApplicationContext();
			CharSequence text = "Password not match!";
			int duration = Toast.LENGTH_SHORT;
			
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
		}else{
			try{
				 Socket client = new Socket();
				 PrintWriter printwriter = new PrintWriter(client.getOutputStream(),true);
				 printwriter.write(usernameStr);
			}catch(Exception e){
				System.out.print(e);
			}
		}
	}
}
