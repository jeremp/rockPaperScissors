
package com.jeremp.handsign.core;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jeremp
 */
public class GameTest {
    
    @Test
    public void gameInitialization(){
        Game game = new Game(new RockPaperScissorRuleEngine());
        
        for(Player player : game.getPlayers()){            
            Assert.assertNull("when the game just starts nobodies have played", player.getPlayed());
            Assert.assertTrue("The player shoud have a name", TestUtils.isNotBlank(player.getNickname()));
        }
		Assert.assertNull("when the game starts there is no winner", game.getWinnerName());
    }
	
	@Test
	public void testWholeGame(){
		Game game = new Game(new RockPaperScissorRuleEngine());		
		game.getPlayerByName("Foo").play(RockPaperScissorRuleEngine.SCISSORS);
		Assert.assertNull(game.getWinnerName());
		game.getPlayerByName("Bar").play(RockPaperScissorRuleEngine.PAPER);
		Assert.assertNotNull(game.getWinnerName());
		
	}
	
	
    
}