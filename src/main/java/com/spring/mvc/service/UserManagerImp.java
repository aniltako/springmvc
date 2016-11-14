package com.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.api.UserManager;
import com.spring.mvc.dao.UserRepository;
import com.spring.mvc.model.User;

@Service
public class UserManagerImp implements UserManager{

	@Autowired
	UserRepository userRepository;

	@Override
	public User addNew(User t) {
		return userRepository.save(t);
	}

	@Override
	public void addAll(List<User> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User update(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeBy(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findWithPaging(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
