/*
 * Created on 19-mei-05
 *
 */
package utilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author benjr
 * 
 */
public class FileController {
	private static String FILENAME = "file.conf";
	
	public static String getType() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILENAME)));	
			String line = "";
			while((line = br.readLine()) != null) {
				String param = line.substring(0, line.indexOf('='));
				if (param.equals("type")) {
					return line.substring(line.indexOf('=')+1, line.length()).trim();
				}
			}
		}
		catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return "";
	}
	
	public static String getHost() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILENAME)));	
			String line = "";
			while((line = br.readLine()) != null) {
				String param = line.substring(0, line.indexOf('='));
				if (param.equals("host")) {
					return line.substring(line.indexOf('=')+1, line.length()).trim();
				}
			}
		}
		catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return "";
	}
	
	public static String getLibrary() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILENAME)));	
			String line = "";
			while((line = br.readLine()) != null) {
				String param = line.substring(0, line.indexOf('='));
				if (param.equals("library")) {
					return line.substring(line.indexOf('=')+1, line.length()).trim();
				}
			}
		}
		catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return "";
	}
		
	public static String getUsername() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILENAME)));	
			String line = "";
			while((line = br.readLine()) != null) {
				String param = line.substring(0, line.indexOf('='));
				if (param.equals("username")) {
					return line.substring(line.indexOf('=')+1, line.length()).trim();
				}
			}
		}
		catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return "";
	}
		
	public static String getPassword() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILENAME)));	
			String line = "";
			while((line = br.readLine()) != null) {
				String param = line.substring(0, line.indexOf('='));
				if (param.equals("password")) {
					return line.substring(line.indexOf('=')+1, line.length()).trim();
				}
			}
		}
		catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return "";
	}
	
}
