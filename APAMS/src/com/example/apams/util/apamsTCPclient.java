package com.example.apams.util;
import java.io.*;
import java.net.*;

import android.os.AsyncTask;
import android.util.*;

public class apamsTCPclient extends AsyncTask<apams_network_package,Integer,String> {
	
	private boolean running;
	private apams_network_package pack;
	public static final String SERVERIP = "146.169.53.89";
	public static final int SERVERPORT = 8888;
	private String answer;
	
	private ObjectOutputStream Oout;
	private BufferedReader in;

	
	public void stopClient(){
		running = false;
	}
	
	public String getAnswer(){
		return answer;
	}

	@Override
	protected String doInBackground(apams_network_package... pack) {
		running = true;
		try{
			InetAddress serverAddr = InetAddress.getByName(SERVERIP);
			Log.e("TCP client", "C:Connecting...");
			Socket socket = new Socket(serverAddr,SERVERPORT);
			try{
				Oout = new ObjectOutputStream(socket.getOutputStream());
				Oout.writeObject(pack);
				Log.e("TCP","package send");
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				answer = in.readLine();

			}catch(Exception e){
				Log.e("TCP","S:Error",e);
			}finally{
				socket.close();
			}
			
		}catch(Exception e){
			Log.e("TCP","S:Error",e);
		}
		return answer;
	}
	
}
