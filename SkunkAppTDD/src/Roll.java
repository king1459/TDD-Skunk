
public class Roll {
	int die1;
	int die2;
	int total;

	public void roll() 
	{
		this.die1 = die();
		this.die2 = die();
		this.total = this.die1 + this.die2;

	}

	public static int die() {
		return ((int) (Math.random() * 6 + 1));
	}

}
