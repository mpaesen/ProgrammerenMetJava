package unit10;

public class Question
{
	private static int nextQuestionNum = 1;
	private int questionNumber = 0;

	public Question()
	{
		questionNumber = nextQuestionNum;
		nextQuestionNum++;
	}

	/**
	 * Gets the questionNumber
	 * @return Returns a int
	 */
	public int getQuestionNumber()
	{
		return questionNumber;
	}

	/**
	 * Sets the questionNumber
	 * @param questionNumber The questionNumber to set
	 */
	public void setQuestionNumber(final int questionNumber)
	{
		this.questionNumber = questionNumber;
	}

}