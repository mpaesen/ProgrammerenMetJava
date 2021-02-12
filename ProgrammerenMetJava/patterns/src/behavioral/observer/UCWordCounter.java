package behavioral.observer;

import java.util.StringTokenizer;

public class UCWordCounter implements LineObserver {
    private int lastCount;


    public UCWordCounter() {
        super();
        lastCount = 0;
    }

    public int count(String line) {
        int ucCount = 0;
        StringTokenizer tokenizer = new StringTokenizer(line);
        String letter, letterUC, word;

        while (tokenizer.hasMoreTokens()) {
            word = tokenizer.nextToken();
            letter = word.substring(0, 1);
            letterUC = letter.toUpperCase();
            if (letter.equals(letterUC)) {
                ++ucCount;
            }
        }

        return ucCount;
    }


    @Override
    public void handleLine(LineSubject source) {
        String line = source.getLine();

        lastCount = count(line);
        displayCount();

    }

    private void displayCount() {
        System.out.print("Start with uppercase " + lastCount);
    }

}
