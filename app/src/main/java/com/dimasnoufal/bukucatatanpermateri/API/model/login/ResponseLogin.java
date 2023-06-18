package com.dimasnoufal.bukucatatanpermateri.API.model.login;

import com.google.gson.annotations.SerializedName;

public class ResponseLogin{

	@SerializedName("loginResult")
	private LoginResult loginResult;

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	public void setLoginResult(LoginResult loginResult){
		this.loginResult = loginResult;
	}

	public LoginResult getLoginResult(){
		return loginResult;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"ResponseLogin{" + 
			"loginResult = '" + loginResult + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}