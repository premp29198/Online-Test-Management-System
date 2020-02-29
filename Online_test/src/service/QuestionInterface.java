package service;

import java.math.BigInteger;
import java.util.Set;
import bean.*;
public interface QuestionInterface {

	
	public Set<Question> addQuestions(Set<Question> questionset);
	public Question deleteQuestions(BigInteger questionid,Set<Question> question);
	public void displayQuestion(Set<Question> question);
}
