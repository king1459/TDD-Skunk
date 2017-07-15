

import java.util.ArrayList;

public class Game {
	public static void startGame() {

		ArrayList<Player> players = new ArrayList<Player>();

		// create player list, should be done in Game when going through again
		genPlayerList(players);

		validatePlayerList(players);

		Round.startRound(players);
	}

	static void validatePlayerList(ArrayList<Player> players) {
		if (players.size() < 2) {
			SkunkApp.tooFewPlayers();
		}
	}

	public static void genPlayerList(ArrayList<Player> players) {
		Player curPlayer = null;
		String name;
		do {
			name = SkunkApp.getNewPlayers();
			if (name.isEmpty()) {
				break;
			}
			curPlayer = new Player(name);
			players.add(curPlayer);
		} while (!(name.isEmpty()));
	}
}
