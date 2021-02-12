package lab8.solution.model;
public interface Testable {
	int computeScore();
	int getLimitSeconds();
	int getPassThreshold();
	public int getQuestionCount();
	public Question getQuestion(int index);


}