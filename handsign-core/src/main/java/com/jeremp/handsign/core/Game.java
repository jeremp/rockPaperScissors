
package com.jeremp.handsign.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class models a HandSigns-game
 * @author jeremp
 */
public class Game implements Observer {
	
	private static final Logger LOG = Logger.getLogger(Game.class.getName());
    
    private final Player playerFoo = new Player("Foo");
	private final Player playerBar = new Player("Bar");
	private final List<Player> players = Arrays.asList(new Player[]{playerFoo, playerBar});

	private String winnerName ;
	private RuleEngine ruleEngine ;

    /**
     * Constructs a game with with {@value BASIC_NUMBER_OF_PLAYERS}
     */
    public Game() {
        this(new RockPaperScissorRuleEngine());
    }
    
    public Game(RuleEngine engine) {        
		initGame(engine);		
    }
	
	private void initGame(RuleEngine engine){
		playerFoo.addObserver(this);		
		playerBar.addObserver(this);
		ruleEngine = new RockPaperScissorRuleEngine();    
	}

	public List<Player> getPlayers() {
		return players;
	}

	@Override
	public void update(Observable o, Object arg) {		
		if(o instanceof Player){
			Player p = (Player)o;
			LOG.log(Level.INFO, "{0} has played", p.getNickname());
			if(everyOneHasPlayed()){
				final Sign beats = ruleEngine.beats(playerFoo.getPlayed(), playerBar.getPlayed());
				if(beats!=null){
					winnerName = whoPlayedThat(beats).getNickname();
					LOG.log(Level.INFO, "Game over {0} won", winnerName);		
				}else{
					LOG.log(Level.INFO, "Game over TIE");				
				}				
			}else{
				LOG.info("Game not finished");
			}
		}
	}
	
	private boolean everyOneHasPlayed(){		
		return players.stream().filter(p -> p.getPlayed()!=null).count()==players.size();
	}

	public String getWinnerName() {
		return winnerName;
	}
	
	public Player getPlayerByName(String nickName){
		return players.stream().filter(p -> p.getNickname().equals(nickName)==false).findFirst().get();
	}
	
	public Player whoPlayedThat(Sign sign){
		return players.stream().filter(p -> p.getPlayed().equals(sign)).findFirst().get();
	}
	
	
    
	
        
    
}
