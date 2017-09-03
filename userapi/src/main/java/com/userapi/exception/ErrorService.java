package com.userapi.exception;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class ErrorService {
	
	@SuppressWarnings("unchecked")
	public JSONObject getErrorJSON(ApiError apiError) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message", apiError.getMessage());
		jsonObject.put("developer message", apiError.getDeveloperMessage());
		JSONObject jsonErrorObject = new JSONObject();
		jsonErrorObject.put("error", jsonObject);
		return jsonErrorObject;
	}

}
