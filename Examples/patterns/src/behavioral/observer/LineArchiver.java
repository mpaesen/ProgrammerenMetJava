package behavioral.observer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class LineArchiver implements LineObserver {
	private PrintWriter out;
	
	public LineArchiver()throws IOException{
		out = new PrintWriter(new FileOutputStream("archive.txt"));
	}
	
	public void close(){
		out.flush();
		out.close();
	}
	
	@Override
	public void handleLine(LineSubject source) {
		String line;
		
		try{
			line = source.getLine();
			save(line);
		}catch (Exception ioe){
			ioe.printStackTrace();
		}

	}

	private void save(String line){
		out.println(line);
	}
}
