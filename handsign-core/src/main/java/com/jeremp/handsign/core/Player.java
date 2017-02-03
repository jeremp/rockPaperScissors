
package com.jeremp.handsign.core;

import java.util.Objects;
import java.util.Observable;

/**
 * Someone playing the HandSign game
 *
 * @author jeremp
 */
public class Player extends Observable {

    /**
     * his nickname
     */
    private String nickname;

    /**
     * The sign he played, null ig he hasn't played yet
     */
    private Sign played;

    public Player(String nickname) {
        this.nickname = nickname;
    }
    
    public void play(Sign sign) {
        this.played = sign;
        // notify the observers
        setChanged();
        notifyObservers(sign);
    }

    /*-----GETTERS-AND-SETTERS----*/
    

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

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 67 * hash + Objects.hashCode(this.nickname);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Player other = (Player) obj;
		if (!Objects.equals(this.nickname, other.nickname)) {
			return false;
		}
		return true;
	}
	
	

}
