public class CardGameSimulator {
	// private static final Player[] players = new Player[2];

	public static void simulateCardGame(String inputA, String inputB) {
		String[] pr = inputA.split(" ");
		String[] nx = inputB.split(" ");

		// Define two 'players'
		Player[] players = new Player[2];
		players[0] = new Player();
		players[1] = new Player();
		players[0].name = "A";
		players[1].name = "B";

		for(int i=0;i<10;i++){
			(players[0].deck)[i] = new Card();
			(players[0].deck)[i].number = Integer.parseInt(pr[i].substring(0,1));
			(players[0].deck)[i].shape = pr[i].charAt(1);
			(players[0].deck)[i].usedCard = false;
		}

		for(int i=0;i<10;i++){
			(players[1].deck)[i] = new Card();
			(players[1].deck)[i].number = Integer.parseInt(nx[i].substring(0,1));
			(players[1].deck)[i].shape = nx[i].charAt(1);
			(players[1].deck)[i].usedCard = false;
		}

		int currentPlayer = 0;
		int tmp = -1;
		int currPos = 0; // the position of current card
		for(int i=0;i<10;i++){
			if(tmp<(players[currentPlayer].deck)[i].number){
				tmp = (players[currentPlayer].deck)[i].number;
				currPos = i;
			}
			if(tmp==(players[currentPlayer].deck)[i].number){
				if((players[currentPlayer].deck)[i].shape=='X'){
					currPos = i;
				}
			}
		}

		players[currentPlayer].playCard((players[currentPlayer].deck)[currPos]);

		int previousNum = tmp;
		char previousShape = (players[currentPlayer].deck)[currPos].shape;
		(players[currentPlayer].deck)[currPos].usedCard = true;

		while(true){
			tmp = -1;
			currPos = 0;
			int currStatus=0;
			currentPlayer = 1-currentPlayer;

			for(int i=0;i<10;i++){
				if(previousNum==(players[currentPlayer].deck)[i].number && !(players[currentPlayer].deck)[i].usedCard){
					currPos = i;
					(players[currentPlayer].deck)[currPos].usedCard = true;
					previousNum = (players[currentPlayer].deck)[currPos].number;
					previousShape = (players[currentPlayer].deck)[currPos].shape;
					currStatus = 1;
					break;
				}
			}

			if(currStatus==1){
				players[currentPlayer].playCard((players[currentPlayer].deck)[currPos]);
				continue;
			}

			for(int i=0;i<10;i++){
				if(previousShape==(players[currentPlayer].deck)[i].shape && !(players[currentPlayer].deck)[i].usedCard){
					currStatus=1;
					if(tmp<(players[currentPlayer].deck)[i].number){
						tmp = (players[currentPlayer].deck)[i].number;
						currPos = i;
					}
				}
			}

			if(currStatus==1){
				previousNum = tmp;
				previousShape = (players[currentPlayer].deck)[currPos].shape;
				(players[currentPlayer].deck)[currPos].usedCard = true;
				players[currentPlayer].playCard((players[currentPlayer].deck)[currPos]);
				continue;
			}

			printWinMessage(players[1-currentPlayer]);
			break;
		}


	}

	private static void printWinMessage(Player player) {
		System.out.printf("Player %s wins the game!\n", player);
	}
}


class Player {
	String name;
	Card[] deck;

	public Player(){
		deck = new Card[10];
	}

	public void playCard(Card card) {
		System.out.printf("Player %s: %s\n", name, card);
	}

	@Override
	public String toString() {
		return name;
	}
}


class Card {
	public int number;
	public char shape;
	public boolean usedCard;

	@Override
	public String toString() {
		return "" + number + shape;
	}
}
