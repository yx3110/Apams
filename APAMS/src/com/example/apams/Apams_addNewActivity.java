package com.example.apams;

import android.app.Activity;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;
import android.provider.MediaStore;

public class Apams_addNewActivity extends Activity {
	private String itemType;
	private String user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_apams_add_new);

		Intent i = getIntent();
		this.user = i.getStringExtra("username");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.apams_add_new, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void newPic(View view) {
		Intent intent = new Intent();
		intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
		intent.addCategory(Intent.CATEGORY_DEFAULT);
	}

	public void chooseItemType(View view) {

		final String[] choices = new String[] { "PC", "Printer", "Mac",
				"Others" };
		new AlertDialog.Builder(this).setTitle("Choose Item type")
				.setIcon(android.R.drawable.ic_dialog_info)
				.setItems(choices, new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						itemType = choices[which];
					}
				}).setNegativeButton("Cancel", null).show();
		Button chooseButton = (Button) findViewById(R.id.addChooseType);
		chooseButton.setHint(itemType);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_apams_add_new,
					container, false);
			return rootView;
		}
	}

}
