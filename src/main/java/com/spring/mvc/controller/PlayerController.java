package com.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mvc.api.PlayerManager;
import com.spring.mvc.api.domain.Player;

@RestController
@RequestMapping("/players")
public class PlayerController {
	
	@Autowired
	private PlayerManager playerManger;
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public Player addUser(@RequestBody Player player){
		return this.playerManger.addNew(player);
	}

}
