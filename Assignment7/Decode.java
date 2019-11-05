package assignment7;

import java.util.Stack;

public class Decode {
	public String decodeString(String s) {
		Stack<String> str = new Stack();
		Stack<Integer> counts = new Stack();
		int index = 0;
		String result = "";
		
		while(index<s.length()) {
			if(Character.isDigit(s.charAt(index))) {
				int count = 0;
				while(Character.isDigit(s.charAt(index))) {
					count = 10*count+(s.charAt(index)-'0');
					index=index+1;
				}
				counts.push(count);
			}else if(s.charAt(index)=='[') {
				str.push(result);
				result="";
				index=index+1;
			}else if(s.charAt(index)==']') {
				StringBuilder sb = new StringBuilder(str.pop());
				int count = counts.pop();
				for(int i=0;i<count;i++) {
					sb.append(result);
				}
				result = sb.toString();	
				index=index+1;
			}else {
				result = result+s.charAt(index);
				index=index+1;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Decode decode = new Decode();
		String s = "10[a]3[b]";
		System.out.println(s);
		System.out.println(decode.decodeString(s));
	}

}
