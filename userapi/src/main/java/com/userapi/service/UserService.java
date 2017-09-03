package com.userapi.service;

import com.userapi.entity.User;

public interface UserService extends GenericService<User> {

//	public JSONObject getUserJSON(List<User> userList) {
//		JSONArray JSONArray = new JSONArray();
//		for (User userinfo : userList) {
//			JSONObject jsonObject = new JSONObject();
//			jsonObject.put("id", userinfo.getUserid());
//			jsonObject.put("fname", userinfo.getFname());
//			jsonObject.put("lname", userinfo.getLname());
//			jsonObject.put("address", userinfo.getAddress());
//			jsonObject.put("contact", userinfo.getContact());
//			JSONArray.add(jsonObject);
//		}
//		JSONObject userJsonObject = new JSONObject();
//		userJsonObject.put("data", JSONArray);
//		return userJsonObject;
//	}
//
//	public JSONObject getErrorJSON(ApiError apiError) {
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("message", apiError.getMessage());
//		jsonObject.put("developer message", apiError.getDeveloperMessage());
//		JSONObject jsonErrorObject = new JSONObject();
//		jsonErrorObject.put("error", jsonObject);
//		return jsonErrorObject;
//	}

}	
