package javaOne.com.ibm.wd150.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserPrompter {

	protected String prompt = "?";
	protected BufferedReader lineReader;

	public UserPrompter() {
		lineReader = new BufferedReader(new InputStreamReader(System.in));
	}

	public UserPrompter(String prompt) {
		this();
		setPrompt(prompt);
	}

	public String getAnswer() {
		try {
			String answer = null;
			while (answer == null || answer.length() < 1) {
				System.out.print(prompt + " ");
				answer = lineReader.readLine().trim();
			}
			return answer;
		} catch (IOException ioe) {
			// if console I/O fails there is no recovery
			return null;
		}
	}

	public boolean getYesNoAnswer() {
		for (int i = 0; i < 3; i++) {
			String answer = getAnswer();
			if (answer == null)
				return false;
			char ans = answer.toUpperCase().charAt(0);
			if (ans == 'Y')
				return true;
			if (ans == 'N')
				return false;
			setPrompt(getPrompt() + ". Please answer Y or N: ");
		}
		return false;
	}

	public static void main(String[] args) {
		UserPrompter up = new UserPrompter();
		up.setPrompt("What is your name?");
		System.out.println("hello " + up.getAnswer());
		UserPrompter confirmer = new UserPrompter("Are you ready?");
		if (confirmer.getYesNoAnswer()) {
			System.out.println("OK, let's go!");
		} else {
			System.out.println("Sorry to hear that.");
		}
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

}
