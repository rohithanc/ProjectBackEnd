package com.example.crudProject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.crudProject.domain.Player;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts= {"classpath:tables.sql","classpath:data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD) //Every single test will run against the exact same database.
public class IntegrationTest {

	@Autowired
	private MockMvc mockMVC;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		Player newPlayer = new Player("Jack Wilshere", 28, "Midfielder", 19);
		String body = this.mapper.writeValueAsString(newPlayer);
		RequestBuilder request = post("/create").contentType(MediaType.APPLICATION_JSON).content(body);
				
		ResultMatcher checkStatus= status().isCreated();
		
		Player savedPlayer = new Player("Jack Wilshere", 28, "Midfielder", 19);
		savedPlayer.setId(2L);
		
		String resultBody = this.mapper.writeValueAsString(savedPlayer);
		ResultMatcher checkBody = content().json(resultBody);
		
		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
		
		MvcResult result = this.mockMVC.perform(request).andExpect(checkStatus).andReturn();
	
		String reqBody = result.getResponse().getContentAsString();
		
		Player playerResult = this.mapper.readValue(reqBody,Player.class);
	}
	
	@Test
	void testDelete() throws Exception {
		RequestBuilder request = delete("/remove/1");
		
		ResultMatcher checkStatus = status().is(200);
		
		this.mockMVC.perform(request).andExpect(checkStatus);
		
	}
	
	@Test
	void testRead() throws Exception {
		Player player = new Player("Jack Wilshere", 28, "Midfielder",19);
		player.setId(1L);
		List<Player> playerList = new ArrayList<>();
		playerList.add(player);
		String responseBody = this.mapper.writeValueAsString(playerList);
		
		System.out.println("JSON array is: " + responseBody);
		
		this.mockMVC.perform(get("/getlist")).andExpect(status().isOk());
	}

}
