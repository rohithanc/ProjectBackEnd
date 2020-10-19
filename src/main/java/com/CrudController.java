package com.example.crudProject;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudProject.domain.Player;
import com.example.crudProject.service.PlayersService;

// ctrl + space /// ctrl + shift + o

@CrossOrigin
@RestController
public class CrudController {
	
	private PlayersService service;

	public CrudController(PlayersService service) {
		super();
		this.service = service;
	}

	@GetMapping("/getlist") // Less noddy
	public ResponseEntity<List<Player>> getPlayersList(){
		return ResponseEntity.ok(this.service.getPlayersList());
	} // converted the list to a JSON Array of Players Objects

//	@GetMapping("/position/{position}")
//	public List<Player> getPlayerbyPosition(@PathVariable String Position) {
//		return this.service.getPlayerbyPosition(Position);
//	}
//	
	
	@PostMapping("/create")
	public ResponseEntity<Player> createPlayers(@RequestBody Player player) {
		System.out.println(player);
		return new ResponseEntity<Player>(this.service.createPlayers(player), HttpStatus.CREATED); //whatever player sent will be added to this list (created by ArrayList)
	} //receive Player Object

	
	@PutMapping("/update")
	public ResponseEntity<Player> updatePlayers(@RequestBody Player player, @PathParam("id") Long id) {
		//this.service.deletePlayer(id);
		return new ResponseEntity<Player>(this.service.updatePlayers(player, id), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("remove/{id}")
	public ResponseEntity<Object> deletePlayer(@PathVariable Long id) {
		//using index
		if (this.service.deletePlayer(id)) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	//Edits from SpareCrudController to this due to Single Responsibility
	}
}
