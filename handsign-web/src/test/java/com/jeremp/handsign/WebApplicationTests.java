package com.jeremp.handsign;

import com.jeremp.handsign.core.RockPaperScissorRuleEngine;
import com.jeremp.handsign.services.HandGameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebApplicationTests {
	
	private static final String PLAYER_1 = "Foo" ;
	private static final String PLAYER_2 = "Bar" ;

	@Autowired
	private MockMvc mockMvc ;
	
	@Autowired
	private HandGameService gameService ;
	
	@Test
	public void wholeGameTest() throws Exception {
		mockMvc.perform( get("/game/new") )
				.andExpect(jsonPath("$.allowedSigns").isArray())
				.andExpect(jsonPath("$.over").value(equals(false)))
				.andExpect(jsonPath("$.winnerName").isEmpty());
		
		Assert.isTrue(!gameService.getGame().isOver());
		
		mockMvc.perform( post("/game/submit")
				.param("sign", RockPaperScissorRuleEngine.PAPER.getName())
				.param("playerName", PLAYER_1))				
				.andExpect(jsonPath("$.isOver").value(false))
				.andExpect(jsonPath("$.winnerName").isEmpty());
		
		mockMvc.perform( post("/game/submit")
				.param("sign", RockPaperScissorRuleEngine.SCISSORS.getName())
				.param("playerName", PLAYER_2))				
				.andExpect(jsonPath("$.isOver").value(true))
				.andExpect(jsonPath("$.winnerName").isNotEmpty());
		
		Assert.isTrue(gameService.getGame().isOver());
		
	}

}
