package com.example.crudProject.service;

//import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudProject.domain.Player;
import com.example.crudProject.domain.PlayersRepo;
import com.example.crudProject.exceptions.PlayerNotFoundException;

@Service
public class PlayersService {

	@Autowired
	private PlayersRepo repo;
	
	public PlayersService(PlayersRepo repo) {
		super();
		this.repo = repo;
	}
	
	public List<Player> getPlayersList(){
		return this.repo.findAll();
	} // converted the list to a JSON Array of Players Objects
	
	public Player createPlayers(Player player) {
		System.out.println(player);
		return this.repo.save(player); //whatever player sent will be added to this list (created by ArrayList)
	} //receive Player Object
	
	public Player updatePlayers(Player player, long id) {

		Player oldPlayer = this.repo.findById(id).orElseThrow(() -> new PlayerNotFoundException()); // If it doesn't find a matching player, throw exception
		oldPlayer.setName(player.getName());
		oldPlayer.setAge(player.getAge());
		oldPlayer.setPosition(player.getPosition());
		oldPlayer.setGoals(player.getGoals());
		
		Player saved = this.repo.save(oldPlayer);
		return saved;
	}
	
	public boolean deletePlayer(Long id) {
		//using index
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	public List<Player> getPlayerbyPosition(String position) {
		// TODO Auto-generated method stub
		return this.repo.findByPosition(position);
	}

	}

