
public class Palindrome {

	public Boolean checkPalindrome(String str,int first,int last){
		if(first <= last){
			if(str.charAt(first) == str.charAt(last)){
				checkPalindrome(str, first+1, last-2);
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Palindrome palindrome = new Palindrome();
		String str = new String("fdgdh");
		System.out.println(palindrome.checkPalindrome(str, 0, str.length()-1));
	}
}
