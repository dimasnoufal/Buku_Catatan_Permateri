package com.dimasnoufal.bukucatatanpermateri.API.model;

import com.google.gson.annotations.SerializedName;

public class Origin{

	@SerializedName("name")
	private String name;

	@SerializedName("url")
	private String url;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Origin{" + 
			"name = '" + name + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}