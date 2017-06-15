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
			JSONObject root1 = new JSONObject();
			root1.put("id", userinfo.getUserid());
			root1.put("fname", userinfo.getFname());
			root1.put("lname", userinfo.getLname());
			root1.put("address", userinfo.getAddress());
			root1.put("contact", userinfo.getContact());
			JSONArray.add(root1);		
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", JSONArray);
		return jsonObject;
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
