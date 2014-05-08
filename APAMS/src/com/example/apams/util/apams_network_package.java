package com.example.apams.util;

import java.io.Serializable;


public class apams_network_package implements Serializable {
	public enum packageType{
		REGISTER,LOGIN,QUERY,IMAGE
	}
	private packageType type;
	private String username;
	private String password;
	private String CID;
	public apams_network_package(String username,String password,String CID,packageType type){
		this.username = username;
		this.password = password;
		this.CID = CID;
		this.type = type;
	}

}
