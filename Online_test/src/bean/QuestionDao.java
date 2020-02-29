package bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Set;
import service.*;
public class QuestionDao implements QuestionInterface {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	@Override
	 public  Set<Question> addQuestions(Set<Question> questionSet)
	 { 
		Question question=new Question();
			
		try {
			System.out.println("Enter QuestionId");
			BigInteger questionId = new BigInteger(br.readLine());
			System.out.println("Enter Question Title");
			String questionTitle = br.readLine();
			System.out.println("Enter Maximum marks for this question");
			BigDecimal questionMarks = new BigDecimal(br.readLine());
			System.out.println("Enter 4 question options");
			String options[] = new String[4];
			for(int i = 0; i < 4;i++)
				options[i] = br.readLine();
			System.out.println("Enter correct answer as Integer(1-4)");
			int questionOption = Integer.parseInt(br.readLine());
			question.setQuestionId(questionId);
			question.setQuestionTitle(questionTitle);
			question.setQuestionAnswer(questionOption);
			question.setQuestionMarks(questionMarks);
			question.setQuestionOptions(options);
			question.setChosenAnswer(0);
			
		questionSet.add(question);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questionSet;
	}

	@Override
	public Question deleteQuestions(BigInteger questionid, Set<Question> question) {
		// TODO Auto-generated method stub
		Iterator<Question> qit=question.iterator();
		Question deletedQuestion = null;
		while(qit.hasNext())
		{	
			Question q=qit.next();
			if(q.getQuestionId().equals(questionid))
			{
				deletedQuestion=q;
				question.remove(q);
				break;
			}
		}
		System.out.println("Question Deleted");
		return deletedQuestion;
	}
	
	@Override 
	public void displayQuestion(Set<Question> question)
	{Iterator<Question> qit=question.iterator();
		while(qit.hasNext())
		{	
			Question nextQuestion=qit.next();
			System.out.print("Question ID : "+nextQuestion.getQuestionId()+"\nQuestion Title : "+nextQuestion.getQuestionTitle());
			System.out.print("\nMaximum Marks : "+nextQuestion.getQuestionMarks()+"\n");
			for(int i=0;i<4;i++)
				System.out.println(i+1+"."+nextQuestion.getQuestionOptions()[i]);
			
		}
			
	}
}

