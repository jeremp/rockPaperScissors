package com.jeremp.handsign.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jeremp.handsign.core.Game;
import com.jeremp.handsign.core.Sign;
import com.jeremp.handsign.services.HandGameService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jpasseron
 */
@Controller
@RequestMapping("/game")
public class HandSignController {
	
	@Autowired
	private HandGameService gameService ;
	
	@Autowired
	private ObjectMapper objectMapper ;
	
	@RequestMapping(path = "/new", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Game> startANewGame(){
		gameService.newGame();
		return new ResponseEntity<>(gameService.getGame(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/submit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ObjectNode> submit(@RequestParam String playerName, @RequestParam String sign){
		Game game = gameService.submit(playerName, sign);
		ObjectNode objectNode = objectMapper.createObjectNode();
		objectNode.put("isOver", game.isOver());
		objectNode.put("winnerName", game.getWinnerName());
		return new ResponseEntity<>(objectNode, HttpStatus.OK);
	}
	
}
