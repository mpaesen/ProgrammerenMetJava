package unit10;

public class Exam
{
	// Static members shared by all instances
	static int questionNum = 1; // static (class) variable

	static public int getQuestionNum()
	{ // Static (class) method
		return questionNum;
	}

	public static void main(final String[] args)
	{
		// Access static field from this class
		System.out.print(questionNum);
		// Access static method from this class
		System.out.print(Exam.getQuestionNum());
		final Exam exam = new Exam();
		// Access static field from instance of this class
		System.out.print(Exam.questionNum);
		// Access static method from instance of this class
		System.out.print(Exam.getQuestionNum());
	}
}