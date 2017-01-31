package com.jeremp.handsign.core;

import org.junit.Assert;
import org.junit.Test;

import static com.jeremp.handsign.core.RockPaperScissorRuleEngine.*;

/**
 *
 * @author jpasseron
 */
public class RockPaperScissorRuleEngineTest {

    public RockPaperScissorRuleEngine engine = new RockPaperScissorRuleEngine();

    @Test
    public void scissorsTest() {
        Assert.assertTrue("Scissors cuts Paper", engine.beats(SCISSORS, PAPER).equals(SCISSORS));
        Assert.assertNull("Scissors doest NOT cuts Scissors", engine.beats(SCISSORS, SCISSORS));
    }
    
    @Test
    public void rockTest() {
        Assert.assertTrue("Rock smashes Scissors", engine.beats(ROCK, SCISSORS).equals(ROCK));
        Assert.assertNull("Rock doest NOT smashes Rock", engine.beats(ROCK, ROCK));
    }
    
    @Test
    public void paperTest() {
        Assert.assertTrue("Paper masks Rock", engine.beats(PAPER, ROCK).equals(PAPER));
        Assert.assertNull("Paper doest NOT masks Paper", engine.beats(PAPER, PAPER));
    }

}
