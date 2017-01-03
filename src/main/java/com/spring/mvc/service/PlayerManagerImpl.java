package com.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.api.PlayerManager;
import com.spring.mvc.api.domain.Player;
import com.spring.mvc.repository.PlayerRepository;

@Service
public class PlayerManagerImpl implements PlayerManager{
	
	@Autowired
	private PlayerRepository playerRepo;
	
	@Override
	public Player addNew(Player t) {
		return this.playerRepo.save(t);
	}

	@Override
	public void addAll(List<Player> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Player update(Player t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Player t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeBy(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Player find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> findWithPaging(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countRecord() {
		// TODO Auto-generated method stub
		return null;
	}

}
