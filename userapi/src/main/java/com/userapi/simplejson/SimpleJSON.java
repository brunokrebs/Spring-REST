package com.userapi.simplejson;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.userapi.entity.User;
import com.userapi.exception.ApiError;

@Service
@SuppressWarnings("unchecked")
public class SimpleJSON {
	
	
	public JSONObject getUserJSON(List<User> userList){
		JSONArray JSONArray = new JSONArray();
		for (User userinfo : userList){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", userinfo.getUserid());
			jsonObject.put("fname", userinfo.getFname());
			jsonObject.put("lname", userinfo.getLname());
			jsonObject.put("address", userinfo.getAddress());
			jsonObject.put("contact", userinfo.getContact());
			JSONArray.add(jsonObject);		
		}
		JSONObject userJsonObject = new JSONObject();
		userJsonObject.put("data", JSONArray);
		return userJsonObject;
	}
	
	public JSONObject getErrorJSON(ApiError apiError){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message", apiError.getMessage());
		jsonObject.put("developer message", apiError.getDeveloperMessage());
		JSONObject jsonErrorObject = new JSONObject();
		jsonErrorObject.put("error", jsonObject);
		return jsonErrorObject;
	}

}
