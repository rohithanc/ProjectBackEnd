package com.example.crudProject;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.crudProject.domain.Player;
import com.example.crudProject.domain.PlayersRepo;
import com.example.crudProject.service.PlayersService;

@SpringBootTest
public class CrudServiceUnitTest {

	@Autowired
	private PlayersService service;
	
	@MockBean
	private PlayersRepo repo;
	
	// GIVEN - WHEN - THEN
	@Test
	void TestCreate() {
	// GIVEN
		Long id = 1L;
		Player newPlayer = new Player("Jack Wilshere", 28, "Midfielder", 29);
		Player savedPlayer = new Player("Jack Wilshere", 28, "Midfielder", 29);
		savedPlayer.setId(id);
		
	// WHEN
		Mockito.when(this.repo.save(newPlayer)).thenReturn(savedPlayer);
		
	// THEN
		assertThat(this.service.createPlayers(newPlayer)).isEqualTo(savedPlayer); //actual test
		//assert that the player created in createPlayers is same as the one here in savedPlayer
	}
	
	@Test
	void testUpdate() {
		//Given
		Long id= 1L;
		Player newPlayer = new Player("Jack Wilshere", 28, "Midfielder", 29); // will be saved
		Player oldPlayer= new Player("John Willock", 22, "Defender", 5); // will be found by findById()
		oldPlayer.setId(id);
		
		Player updatedPlayer = new Player("Jack Wilshere", 28, "Midfielder", 29); // will be saved back to database and returned by this method.
		updatedPlayer.setId(id);
		
		//When
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(oldPlayer));
		Mockito.when(this.repo.save(updatedPlayer)).thenReturn(updatedPlayer);
		
		///Then
		assertThat(this.service.updatePlayers(newPlayer, id)).isEqualTo(updatedPlayer);
	}
	
	
}

