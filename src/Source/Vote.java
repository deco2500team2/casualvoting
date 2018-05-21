package Source;

import java.util.ArrayList;
import java.util.List;

public class Vote {
	String votename;
	Account author;
	boolean privacy;//true = public, false = private
	String opentime;
	String closetime;
	String url;
	String description;
	List<Question> questions;
	
	public Vote(){
		questions = new ArrayList<Question>();
	}
	
	@Override
	public String toString() {
		String p = "";
		if(privacy){
			p = "true";
		} else {
			p = "false";
		}
		return votename+","+author.username+","+p+","+opentime+","+closetime+","+url+","+description;
	}
}
