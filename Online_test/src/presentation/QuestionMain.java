package presentation;
import bean.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class QuestionMain {
static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
public static void main(String args[])
{QuestionDao obj=new QuestionDao();
	Set<Question> questionSet = new HashSet<Question>();
	try {
		while(true) {
			System.out.println("1.Add Question");
			System.out.println("2.Delete Question");
			System.out.println("3.Display Question");
			System.out.println("Enter Your Choice");
		int choice = Integer.parseInt(br.readLine());
		switch(choice)
		{
		case 1 : obj.addQuestions(questionSet); 
			break;
		case 2: System.out.println("Enter QuestionId you want to Delete. ");
				BigInteger qid=new BigInteger(br.readLine());
				obj.deleteQuestions(qid,questionSet );
		
		case 3:obj.displayQuestion(questionSet);
		break;
		
		default : System.out.println("try Again.Please Enter Valid Choice.");
					QuestionMain.main(null);
		}
		System.out.println("Do you want to continue....");
		if(br.readLine().equalsIgnoreCase("yes"))
			continue;
		else
			break;
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(NumberFormatException e1)
	{
		System.out.println("Please only enter in digits");
		
	}
}

}
