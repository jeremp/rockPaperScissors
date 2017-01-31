
package com.jeremp.handsign.core;

import java.util.Arrays;

/**
 *
 * @author jpasseron
 */
public class RockPaperScissorRuleEngine extends RuleEngine {

	public static final Sign ROCK = new Sign("ROCK");
	public static final Sign PAPER = new Sign("PAPER");
	public static final Sign SCISSORS = new Sign("SCISSORS");

	public RockPaperScissorRuleEngine() {
		ROCK.setBeats(Arrays.asList(SCISSORS));	
		PAPER.setBeats(Arrays.asList(ROCK));	
		SCISSORS.setBeats(Arrays.asList(PAPER));
		this.allowedSigns.addAll(Arrays.asList(ROCK, PAPER, SCISSORS));
	}
	
	@Override
	public Sign beats(Sign a, Sign b) {
		if(a.equals(b)){
			return null ;
		}else{
			if(a.getBeats().contains(b)){
				return a ;
			}else if(b.getBeats().contains(a)){
				return b ;
			}
			return null ;
		}
	}
	
}
