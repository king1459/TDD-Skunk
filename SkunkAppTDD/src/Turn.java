import java.util.ArrayList;

public class Turn {

	public static void startTurn(ArrayList<Player> players, Kitty kit) {
		int index = 0, size = players.size();
		Player curPlayer = players.get(index);

		while (!(curPlayer.gameTotal > 99 && curPlayer.isFinal == true)) {

			boolean cont = false;
			do {
				Roll curRoll = new Roll();
				curRoll.roll();
				boolean skunk = isSkunk(curRoll);

				SkunkApp.printRoll(curPlayer, curRoll);
				if (skunk == true) {
					Turn.skunkType(curPlayer, curRoll, kit);
					break;
				} else {
					curPlayer.updateCurScore(curRoll.total);
					SkunkApp.playerStats(curPlayer);
					cont = SkunkApp.contRoll();
				}

			} while (cont == true);

			if (curPlayer.gameTotal > 99) {
				curPlayer.isFinal = true;
			}
			curPlayer.updateGameTotal();
			SkunkApp.turnSummary(curPlayer, kit);
			index = nextIndex(index, size);
			curPlayer = players.get(index);
		}
	}

	public static int nextIndex(int index, int size) {
		if (index + 1 == size) {
			index = 0;
		} else {
			index++;
		}

		return index;
	}

	public static void skunkType(Player curPlayer, Roll roll, Kitty kit) {
		SkunkApp.printSkunk();
		int chips = 0;
		if (roll.total == 2) {
			curPlayer.gameTotal = 0;
			chips = 4;
		} else if (roll.total == 3) {
			chips = 2;
		} else {
			chips = 1;
		}
		curPlayer.loseChips(chips);
		kit.addChips(chips);
		curPlayer.skunkReset();

	}

	public static boolean isSkunk(Roll roll) {
		boolean check = false;
		if (roll.die1 == 1 || roll.die2 == 1)
			check = true;
		return check;
	}
}
