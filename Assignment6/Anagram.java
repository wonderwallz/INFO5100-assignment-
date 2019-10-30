package assignment6;

public class Anagram {
	public boolean isAnagram(String s, String t) {
		if(s.length()!=t.length()) {
			return false;
		}
		int[] counts = new int[26];
		for(int i=0;i<s.length();i++) {
			counts[s.charAt(i)-'a']++;
			counts[t.charAt(i)-'a']--;
		}
		for(int count:counts) {
			if(count!=0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "book";
		String t = "okob";
		Anagram anagram = new Anagram();
		System.out.println(anagram.isAnagram(s, t));
	}

}
