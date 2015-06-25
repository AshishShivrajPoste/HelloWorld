import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
public class CandidateCode 
{ 
	public static void main(String[] args) {
//		String result = validString("({{dgdf[]dfgfdg[[]dsfsdf}{dfgfdg()dfgfdg()}}dfgfdg12312)");
		String result = validString("[]");
		System.out.println("Result -->"+result);
	}
//   
}






//public static String validString(String input1)
//{
//	Stack stack = new Stack();
//	Map<Character,Character> map = new HashMap<Character, Character>();
//	map.put('}', '{');
//	map.put(')', '(');
//	map.put(']', '[');
//	map.put('>', '<');
//	for(int i = 0; i < input1.length();i++){
//		Character c = input1.charAt(i);
//		if(c == '{' || c == '(' || c == '[' || c == '<'){
//			stack.push(c);
//		}else if(c == '}' || c == ')' || c == ']' || c == '>'){
//			if(stack.empty()){
//				return "Incorrect"; 
//			}
//			Character c1 = (Character) stack.pop();
//			if(c1 != map.get(c)){
//				return "Incorrect";
//			}
//		}	
//	}
//	if(!stack.empty()){
//		return "Incorrect";
//	}else{
//		return "Correct";
//	}
//}