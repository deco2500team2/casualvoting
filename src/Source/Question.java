package Source;

import java.util.HashMap;
import java.util.Map;

public class Question {
	String questionTitle;
	Map<String, Integer> answers;
	
	public Question(){
		answers = new HashMap<String, Integer>();
	}
}
