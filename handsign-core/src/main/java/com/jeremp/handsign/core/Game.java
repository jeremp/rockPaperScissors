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
import java.util.stream.Collectors;

/**
 * This class models a HandSigns Game
 * A game Observers his players
 * @author jeremp
 */
public class Game implements Observer {

    private static final Logger LOG = Logger.getLogger(Game.class.getName());

    /**
     * The first Player
     */
    private Player playerFoo = new Player("Foo");
    
    /**
     * The second Player
     */
    private Player playerBar = new Player("Bar");
    
    /**
     * A List to retrieve them directly
     */
    private List<Player> players = Arrays.asList(new Player[]{playerFoo, playerBar});

    /**
     * is this game over ?
     */
    private boolean over = false ;
    
    /**
     * When the game is Over it can exists a winner
     */
    private String winnerName;
    
    /**
     * At what game are we playing ?
     */
    private RuleEngine ruleEngine;

    /**
     * Constructs a game with with
     */
    public Game() {
        this(new RockPaperScissorRuleEngine());
    }

    public Game(RuleEngine engine) {
        initGame(engine);
    }
	
	public Game(RuleEngine engine, Player foo, Player bar) {
		this.playerBar = bar ;
		this.playerFoo = foo ;
		players = Arrays.asList(new Player[]{playerFoo, playerBar});
        initGame(engine);
    }

    private void initGame(RuleEngine engine) {
        playerFoo.addObserver(this);
        playerBar.addObserver(this);
        ruleEngine = engine;
		// computer plays without waiting anything
		if(playerFoo instanceof ComputerPlayer){
			((ComputerPlayer)playerFoo).play(engine.allowedSigns);
		}
		if(playerBar instanceof ComputerPlayer){
			((ComputerPlayer)playerBar).play(engine.allowedSigns);
		}
    }

    public List<Player> getPlayers() {
        return players;
    }

    /**
     * When somebody has played, the game is notified
     * @param o the player who played
     * @param arg the sign he choosed
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Player) {
            Player p = (Player) o;
            LOG.log(Level.INFO, "{0} has played", p.getNickname());
            if (everyOneHasPlayed()) {
                over = true ;
                final Sign beats = ruleEngine.beats(playerFoo.getPlayed(), playerBar.getPlayed());
                if (beats != null) {
                    List<Player> playersWithTheWinningSign = whoPlayedThat(beats);
                    if(playersWithTheWinningSign.size()==1){
                        winnerName = playersWithTheWinningSign.get(0).getNickname();
                    }else{
                        winnerName = "Foo and Bar";
                    }
                    LOG.log(Level.INFO, "Game over {0} won", winnerName);
                } else {
                    LOG.log(Level.INFO, "Game over TIE");
                }
            } else {
                LOG.info("Game not finished");
            }
        }
    }

    /**
     * Checks if every player has played
     * @return 
     */
    private boolean everyOneHasPlayed() {
        return players.stream().filter(p -> p.getPlayed() != null).count() == players.size();
    }

    /**
     * Convinience method to retrieve a player by it's nickname
     * @param nickName
     * @return 
     */
    public Player getPlayerByName(String nickName) {
		for(Player p : players){
			if(nickName.equalsIgnoreCase(p.getNickname())){
				return p ;
			}
		}
		return null ;
	}

    /**
     * Find players who played a particular sign
     * @param sign
     * @return 
     */
    public List<Player> whoPlayedThat(Sign sign) {
        List<Player> pList = new ArrayList<>();
		for(Player p : players){
			if(sign.equals(p.getPlayed())){
				pList.add(p);
			}
		}
		return pList ;
    }
    
    public String getWinnerName() {
        return winnerName;
    }
	
	public List<Sign> getAllowedSigns(){
		return ruleEngine.allowedSigns;
	}

	public boolean isOver() {
		return over;
	}
	
	public Sign findByName(String name){
		Optional<Sign> sign = ruleEngine.allowedSigns.stream().filter(s -> s.getName().equalsIgnoreCase(name)).findFirst();	
		if(sign.isPresent()){
			return sign.get();
		}else{
			return null ;
		}
	}

	
}
