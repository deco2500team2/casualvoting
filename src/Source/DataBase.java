package Source;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataBase {

	static List<Account> accounts;
	static List<Vote> votes;
	static Account userAccount;
	static Vote currentVote;
	static Question currentQuestion;
	
	static Boolean edit = false;
	static Boolean loadQuestion = false;
	
	//just used for creating votes
	static String currentAnswer;
	static List<Question> currentQuestions;
	
	public static void setupDatabase() {
		accounts = new ArrayList<Account>();
		votes = new ArrayList<Vote>();
		try{
			BufferedReader accountsReader = new BufferedReader(new FileReader("accounts.txt"));
			BufferedReader infomationReader = new BufferedReader(new FileReader("vote_information.txt"));
			BufferedReader questionsReader = new BufferedReader(new FileReader("vote_questions.txt"));
			String line = accountsReader.readLine();
			while(line != null){
				Scanner sc = new Scanner(line);
				sc.useDelimiter(",");
				Account a = new Account();
				a.username = sc.next();
				a.password = sc.next();
				a.email = sc.next();
				a.title = sc.next();
				a.firstname = sc.next();
				a.surname = sc.next();
				a.DoB = sc.next();
				accounts.add(a);
				sc.close();
				line = accountsReader.readLine();
			}
			line = infomationReader.readLine();
			while(line != null) {
				Scanner sc = new Scanner(line);
				sc.useDelimiter(",");
				Vote v = new Vote();
				v.votename = sc.next();
				String author = sc.next();
				for(Account a:accounts){
					if(a.username.equals(author)){
						v.author = a;
					}
				}
				if(sc.next().equals("true")) {
					v.privacy = true;
				} else {
					v.privacy = false;
				}
				v.opentime = sc.next();
				v.closetime = sc.next();
				v.url = sc.next();
				v.description = sc.next();
				votes.add(v);
				sc.close();
				line = infomationReader.readLine();
			}
			line = questionsReader.readLine();
			while(line != null){
				Scanner sc = new Scanner(line);
				sc.useDelimiter(",");
				String votename = sc.next();
				for(Vote v: votes){
					if(v.votename.equals(votename)){
						Question q = new Question();
						q.questionTitle = sc.next();
						while(sc.hasNext()){
							String answername = sc.next();
							int answeramount = Integer.parseInt(sc.next());
							q.answers.put(answername, answeramount);
						}
						v.questions.add(q);
						break;
					}
				}
				sc.close();
				line = questionsReader.readLine();
			}
			accountsReader.close();
			infomationReader.close();
			questionsReader.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			
		}
	}
	
	public static void saveDatabase(){
		try {
			BufferedWriter accountsWriter = new BufferedWriter(new FileWriter("accounts.txt"));
			for(Account a:accounts){
				accountsWriter.write(a.toString());
				accountsWriter.write(System.lineSeparator());
			}
			accountsWriter.close();
			BufferedWriter infomationWriter = new BufferedWriter(new FileWriter("vote_information.txt"));
			BufferedWriter questionsWriter = new BufferedWriter(new FileWriter("vote_questions.txt"));
		
			for(Vote v: votes) {
				infomationWriter.write(v.toString());
				infomationWriter.write(System.lineSeparator());
				for(Question q:v.questions){
					String s = v.votename+","+q.questionTitle;
					for(String s1:q.answers.keySet()){
						s = s+","+s1+","+q.answers.get(s1);
					}
					questionsWriter.write(s);
					questionsWriter.write(System.lineSeparator());
				}
			}
			infomationWriter.close();
			questionsWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Account checkLogin(String username, String password) {
		for(Account a:accounts){
			if(username.equals(a.username) && password.equals(a.password)){
				userAccount = a;
				return a;
			}
		}
		return null;
	}
	
	public static void addAccount(String username, String password, String email, String title,
			String firstname, String surname, String DoB){
		Account a = new Account();
		a.DoB = DoB;
		a.email = email;
		a.username = username;
		a.firstname = firstname;
		a.password = password;
		a.surname = surname;
		a.title = title;
		accounts.add(a);
	}
	
	public static List<Vote> getCreatedVotes(Account account, String username){
		List<Vote> votesCreatedBy = new ArrayList<Vote>();
		for(Vote v:votes){
			if(v.author.username.equals(username) || v.author.username.equals(account.username)){
				votesCreatedBy.add(v);
			}
		}
		return votesCreatedBy;
	}
	
	public static Account getAccount(String username){
		for(Account a:accounts){
			if(a.username.equals(username)){
				return a;
			}
		}
		return null;
	}
	
	public static void addVote(String votename, Account author, String decription){
		Vote v = new Vote();
		v.author = author;
		v.votename = votename;
		if(votename==null | votename.equals("")){
			v.description = "no description";
		}else{
			v.description = decription;
		}
		votes.add(v);
	}
	
	public static void updateVote(String votename, Account author, String description){
		for (Vote v: votes){
			if(v.votename.equals(votename) && v.author.equals(author)){
				v.description = description;
			}
		}
		
	}
	
	public static void addQuestion(String votename, String questionname) {
		for(Vote v: votes){
			if(v.votename.equals(votename)){
				Question q = new Question();
				q.questionTitle = questionname;
				v.questions.add(q);
			}
		}
	}
	
	public static void addAnswer(String votename, String questionname, String answername) {
		for(Vote v:votes){
			if(v.votename.equals(votename)){
				for(Question q:v.questions){
					if(q.questionTitle.equals(questionname)){
						q.answers.put(answername, 0);
					}
				}
			}
		}
	}
	
	public static void incrementQuestionCount(String votename, String questionname, String answername){
		for(Vote v:votes){
			if(v.votename.equals(votename)){
				for(Question q:v.questions){
					if(q.questionTitle.equals(questionname)){
						int currentcount = q.answers.get(answername);
						currentcount++;
						q.answers.remove(questionname);
						q.answers.put(answername, currentcount);
					}
				}
			}
		}
	}
	
	public static Vote getVote(String votename){
		for(Vote v:votes){
			if(v.votename.equals(votename)){
				return v;
			}
		}
		return null;
	}
	
	public static Question getQuestion(String questionname,String votename){
		Vote v = getVote(votename);
		for (Question q:v.questions){
			if(q.questionTitle.equals(questionname)){
				return q;
			}
		}
		return null;
		
	}
}
