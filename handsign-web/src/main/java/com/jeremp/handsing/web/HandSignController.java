package com.jeremp.handsing.web;

import com.jeremp.handsign.core.Game;
import com.jeremp.handsing.services.HandGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jpasseron
 */
@Controller
@RequestMapping("/game")
public class HandSignController {
	
	@Autowired
	private HandGameService gameService ;
	
	@RequestMapping(path = "/new", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Game> startANewGame(){
		gameService.newGame();
		return new ResponseEntity<>(gameService.getGame(), HttpStatus.OK);
	}
	
}
