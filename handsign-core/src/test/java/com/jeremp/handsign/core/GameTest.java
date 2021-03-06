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
	public void gameInitialization() {
		Game game = new Game(new RockPaperScissorRuleEngine());

		for (Player player : game.getPlayers()) {
			Assert.assertNull("when the game just starts nobodies have played", player.getPlayed());
			Assert.assertTrue("The player shoud have a name", TestUtils.isNotBlank(player.getNickname()));
		}
		Assert.assertNull("when the game starts there is no winner", game.getWinnerName());
	}

	@Test
	public void testWholeGame() {
		Game game = new Game(new RockPaperScissorRuleEngine());
		game.getPlayerByName("Foo").play(RockPaperScissorRuleEngine.SCISSORS);
		Assert.assertNull(game.getWinnerName());
		Assert.assertFalse(game.isOver());
		game.getPlayerByName("Bar").play(RockPaperScissorRuleEngine.PAPER);
		Assert.assertNotNull(game.getWinnerName());
		Assert.assertEquals(game.getWinnerName(), "Foo");
		Assert.assertTrue(game.isOver());
	}

	@Test
	public void testTieGame() {
		Game game = new Game(new RockPaperScissorRuleEngine());
		game.getPlayerByName("Foo").play(RockPaperScissorRuleEngine.SCISSORS);
		Assert.assertNull(game.getWinnerName());
		Assert.assertFalse(game.isOver());
		game.getPlayerByName("Bar").play(RockPaperScissorRuleEngine.SCISSORS);
		Assert.assertNull(game.getWinnerName());
		Assert.assertTrue(game.isOver());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSignNotAllowed() {
		Game game = new Game(new RockPaperScissorRuleEngine());
		game.getPlayerByName("Foo").play(new Sign("LIGHTSABER"));
		Assert.assertNull(game.getWinnerName());
		Assert.assertFalse(game.isOver());
		game.getPlayerByName("Bar").play(RockPaperScissorRuleEngine.SCISSORS);
	}
	
	@Test
	public void testComputerGame(){
		Game game = new Game(new RockPaperScissorRuleEngine(), new ComputerPlayer("D2R2"), new ComputerPlayer("ED-209"));
		Assert.assertTrue(game.isOver());
	}
	
	@Test
	public void testHumanVsComputerGame(){
		Game game = new Game(new RockPaperScissorRuleEngine(), new Player("Jeremy"), new ComputerPlayer("ED-209"));
		Assert.assertFalse(game.isOver());
		Player playerByName = game.getPlayerByName("Jeremy");
		game.getPlayerByName("Jeremy").play(RockPaperScissorRuleEngine.SCISSORS);
		Assert.assertTrue(game.isOver());
	}
	
	@Test
	public void testFindSignByName(){
		Game game = new Game(new RockPaperScissorRuleEngine());
		Assert.assertEquals(RockPaperScissorRuleEngine.SCISSORS, game.findByName(RockPaperScissorRuleEngine.SCISSORS.getName()));
	}


}
