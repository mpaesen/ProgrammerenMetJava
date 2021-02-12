package unit10;

public class QuestionDriver
{

	public static void main(final String[] args)
	{
		final Question[] questions = new Question[4];

		for (int i = 0; i < questions.length; i++)
		{
			questions[i] = new Question();
		}

		System.out.println("Question numbers:\n");
		for (int i = 0; i < questions.length; i++)
		{
			System.out.println("[" + i + "]\t" + questions[i].getQuestionNumber());
		}
	}
}
