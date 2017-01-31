
package com.jeremp.handsign.core;

import java.util.Observable;

/**
 * Someone playing the HandSigns game
 * @author jeremp
 */
public class Player extends Observable {
    
    private String nickname ;
    private Sign played ;

    public Player(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

	public Sign getPlayed() {
		return played;
	}

	public void setPlayed(Sign played) {
		this.played = played;
	}
	
	public void play(Sign sign){
		this.played = sign;
		setChanged();
		notifyObservers(sign);
	}

    
}
