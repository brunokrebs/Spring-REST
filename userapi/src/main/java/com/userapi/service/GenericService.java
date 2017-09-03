package com.userapi.service;

import org.json.simple.JSONObject;

public interface GenericService <T> {
	
	public void insert(T t);

	public T update(T t);

	public void delete(int id);

	public JSONObject findAll();

	public JSONObject findOne(int id);
	
	public T getOne(int id);

}
