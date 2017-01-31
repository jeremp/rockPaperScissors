package com.jeremp.handsign.core;

import org.junit.Assert;
import org.junit.Test;

import static com.jeremp.handsign.core.RockPaperScissorRuleEngine.* ;

/**
 *
 * @author jpasseron
 */
public class RockPaperScissorRuleEngineTest {

	public RockPaperScissorRuleEngine engine = new RockPaperScissorRuleEngine();
	
	@Test
	public void scissorsTest(){
		Assert.assertTrue("scissors cuts Paper", engine.beats(SCISSORS, PAPER).equals(SCISSORS));
	}
	
}
