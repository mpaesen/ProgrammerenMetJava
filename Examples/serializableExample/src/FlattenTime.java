import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FlattenTime {
	public static void main(String[] args) {
		String filename = "time.ser";
		if (args.length > 0) {
			filename = args[0];
		}
		PersistentTime time = new PersistentTime();
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(time);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}