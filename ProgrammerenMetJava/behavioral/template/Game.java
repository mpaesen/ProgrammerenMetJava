package behavioral.template;

/**
 * An abstract class that is common to several games in
 * which players play against the others, but only one is
 * playing at a given time.
 */
 
public abstract class Game {
 
    private int playersCount;
 
    public abstract void initializeGame();
 
    public abstract void makePlay(int player);
 
    public abstract boolean endOfGame();
 
    public abstract void printWinner();
 
    /* A template method : */
    final void playOneGame(int playersCount) {
        this.setPlayersCount(playersCount);
        initializeGame();
        int j = 0;
        while (!endOfGame()) {
            makePlay(j);
            j = (j + 1) % playersCount;
        }
        printWinner();
    }

	public void setPlayersCount(int playersCount) {
		this.playersCount = playersCount;
	}

	public int getPlayersCount() {
		return playersCount;
	}
}