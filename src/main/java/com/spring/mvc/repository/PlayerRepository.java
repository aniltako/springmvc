package com.spring.mvc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.api.domain.Player;

@Transactional
public interface PlayerRepository extends MongoRepository<Player, String>{

}
