package com.jeremp.handsign.core;

import java.util.List;
import java.util.Random;

/**
 * A computer player choose himself his sign
 * @author jpasseron
 */
public class ComputerPlayer extends Player {

	Random rand = new Random();

	public ComputerPlayer(String nickname) {
		super(nickname);
	}

	/**
	 * We just got to tell him what are the allowed signs
	 * @param availableSigns 
	 */
	public void play(List<Sign> availableSigns) {
		super.play(availableSigns.get(randInt(0, availableSigns.size()-1)));
	}

	private int randInt(int min, int max) {
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
}
