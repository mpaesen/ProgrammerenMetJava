package behavioral.observer;

import java.io.IOException;

public class SillyTextProcesser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int				maxLines;
		LineArchiver	archiver;
		LineReader		reader;
		ProgressWindow	bar;
		UCWordCounter	counter;
		
		try{
			maxLines = Integer.parseInt(args[0]);
			
		}catch(NumberFormatException nfe){
			maxLines = 5;
		}
		try {
			reader = new LineReader(System.in, maxLines);
			bar = new ProgressWindow(maxLines);
			archiver = new LineArchiver();
			counter = new UCWordCounter();
			reader.addObserver(bar);
			reader.addObserver(archiver);
			reader.addObserver(counter);

			System.out.println("Enter " + maxLines + " lines of text (^Z to end):");
			reader.start(maxLines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
