package com.example.apams.util;

import java.io.Serializable;

public class apams_network_package implements Serializable {
	private String username;
	private String password;
	private String CID;
	public apams_network_package(String username,String password,String CID){
		this.username = username;
		this.password = password;
		this.CID = CID;
	}

}
