import static org.junit.Assert.*;

import org.junit.Test;

public class TestKitty {

	//test default values of new object
	@Test
	public void newKitty(){
		Kitty kit=new Kitty();
		assertTrue(kit.chips==0);
	}
	
	//test clearing of kitty
	@Test
	public void clearKitty(){
		Kitty kit=new Kitty();
		kit.chips=5;
		kit.clearKitty();
		assertTrue(kit.chips==0);
	}
	
	//test adding chips to kitty
	@Test
	public void addChips(){
		Kitty kit=new Kitty();
		kit.chips=5;
		kit.addChips(15);
		assertTrue(kit.chips==20);
	}
}
