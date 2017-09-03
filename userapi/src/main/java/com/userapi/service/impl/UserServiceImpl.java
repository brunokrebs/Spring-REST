package com.userapi.service.impl;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userapi.entity.User;
import com.userapi.jpa.UserRepository;
import com.userapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void insert(User t) {
		userRepository.save(t);

	}

	@Override
	public User update(User t) {
		User updateUser = getOne(t.getUserid());
		if (updateUser == null) {
			return null;
		}
		updateUser.setFname(t.getFname());
		updateUser.setLname(t.getLname());
		updateUser.setContact(t.getContact());
		updateUser.setAddress(t.getContact());
		userRepository.save(updateUser);
		return updateUser;
	}

	@Override
	public void delete(int id) {
		User userdelete = getOne(id);
		if (userdelete != null) {
			userRepository.delete(id);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject findAll() {
		List<User> userList = userRepository.findAll();
		JSONArray jsonArray = new JSONArray();

		if (userList.isEmpty()) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("message", "No Content");
			jsonObject.put("developer message", "Table is empty");
			JSONObject jsonErrorObject = new JSONObject();
			jsonErrorObject.put("error", jsonObject);
			return jsonErrorObject;
		}

		for (User u : userList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", u.getUserid());
			jsonObject.put("fname", u.getFname());
			jsonObject.put("lname", u.getLname());
			jsonObject.put("address", u.getAddress());
			jsonObject.put("contact", u.getContact());
			jsonArray.add(jsonObject);
		}
		JSONObject userJsonObject = new JSONObject();
		userJsonObject.put("data", jsonArray);
		return userJsonObject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject findOne(int id) {
		JSONObject userJsonObject = new JSONObject();
		User user = getOne(id);
		if (user == null) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("message", "User with id " + id + " not found");
			jsonObject.put("developer message", "User with id " + id + " not found");
			JSONObject jsonErrorObject = new JSONObject();
			jsonErrorObject.put("error", jsonObject);
			return jsonErrorObject;
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", user.getUserid());
		jsonObject.put("fname", user.getFname());
		jsonObject.put("lname", user.getLname());
		jsonObject.put("address", user.getAddress());
		jsonObject.put("contact", user.getContact());
		userJsonObject.put("data", jsonObject);
		return userJsonObject;
	}

	@Override
	public User getOne(int id) {
		User user = userRepository.findOne(id);
		if (user == null) {
			return null;
		}
		return user;
	}

}
