import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestTurn {

	@Test
	public void testIndexLoop(){
		int index=0; int players=3;
		index=Turn.nextIndex(index, players);
		assertTrue(index==1);
		index=Turn.nextIndex(index, players);
		assertTrue(index==2);
		index=Turn.nextIndex(index, players);
		assertTrue(index==0);
		
	}
	
	@Test
	public void runTest(){
		ArrayList<Player> players =new ArrayList<Player>();
		Player p1=new Player("John");
		Player p2=new Player("Bob");
		players.add(p1);
		players.add(p2);
		Kitty kit=new Kitty();
		Turn.startTurn(players, kit);
		
		
		
		
		
	}
	
	@Test
	public void testRegularTurn(){
		Player curPlayer=new Player("Bob");
		Kitty kitty=new Kitty();
		
		Turn.regularTurn(kitty, curPlayer);
	}
	
	@Test
	public void testSkunkType(){
		Player curPlayer=new Player("Bob");
		Roll roll=new Roll(); 
		Kitty kitty=new Kitty();
		
		//test snakeeyes
		roll.die1=1; roll.die2=1; roll.total=roll.die1+roll.die2;
		Turn.skunkType(curPlayer, roll, kitty);
		assertTrue(kitty.chips==4);
		assertTrue(curPlayer.curTotal==0);
		assertTrue(curPlayer.gameTotal==0);
		assertTrue(curPlayer.chips==46);
		
		//test 
		roll.die1=1; roll.die2=2; roll.total=roll.die1+roll.die2;
		Turn.skunkType(curPlayer, roll, kitty);
		assertTrue(kitty.chips==6);
		assertTrue(curPlayer.curTotal==curPlayer.gameTotal);
		assertTrue(curPlayer.chips==44);
		
		//test 
		roll.die1=1; roll.die2=5; roll.total=roll.die1+roll.die2;
		Turn.skunkType(curPlayer, roll, kitty);
		assertTrue(kitty.chips==7);
		assertTrue(curPlayer.curTotal==curPlayer.gameTotal);
		assertTrue(curPlayer.chips==43);		
			
	}
	
	@Test
	public void testIfSkunk(){
		Roll roll=new Roll(); 
		//test snakeeyes
		roll.die1=1; roll.die2=1; roll.total=roll.die1+roll.die2;
		assertTrue(Turn.isSkunk(roll));

		roll.die1=1; roll.die2=5; roll.total=roll.die1+roll.die2;
		assertTrue(Turn.isSkunk(roll));
		
		roll.die1=5; roll.die2=1; roll.total=roll.die1+roll.die2;
		assertTrue(Turn.isSkunk(roll));
		
		roll.die1=3; roll.die2=5; roll.total=roll.die1+roll.die2;
		assertFalse(Turn.isSkunk(roll));
	}
}
