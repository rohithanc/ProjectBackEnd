package com.example.crudProject.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//Java Persistence API

@Repository
public interface PlayersRepo extends JpaRepository<Player,Long>{

	// SELECT * FROM player WHERE position = {position};
	@Query(value = "SELECT * FROM Player WHERE position = ?1", nativeQuery = true)
	List<Player> findByPosition(String Position);

}
