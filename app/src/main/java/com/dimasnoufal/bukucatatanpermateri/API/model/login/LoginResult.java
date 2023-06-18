package com.dimasnoufal.bukucatatanpermateri.API.model.login;

import com.google.gson.annotations.SerializedName;

public class LoginResult{

	@SerializedName("name")
	private String name;

	@SerializedName("userId")
	private String userId;

	@SerializedName("token")
	private String token;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"LoginResult{" + 
			"name = '" + name + '\'' + 
			",userId = '" + userId + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}