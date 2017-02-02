package com.jeremp.handsign.services;

import com.jeremp.handsign.core.Game;
import com.jeremp.handsign.core.Sign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpasseron
 */
@Service
public class HandGameService {
	
	private final Logger log = LoggerFactory.getLogger(HandGameService.class);
	
	private Game game = new Game();

	public void newGame(){
		log.info("Starting a new Game");
		game = new Game();
	}
	
	public Game getGame() {
		return game;
	}
	
	public Game submit(String playerName, String sign){
		game.getPlayerByName(playerName).play( game.findByName(sign) );
		return game ;
	}

}
