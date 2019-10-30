package assignment6;

import java.util.HashMap;
import java.util.HashSet;

public class Occurrence {
	public boolean isUniqueOccurrence(int[] a) {
		HashMap<Integer,Integer> map = new HashMap();
		for(int num: a) {
			map.put(num, map.getOrDefault(num,0)+1);
		}
		HashSet<Integer> uniqValue = new HashSet();
		for(int count: map.values() ) {
			if(uniqValue.contains(count)) {
				return false;
			}
			uniqValue.add(count);
		}
		return true;
	}

	public static void main(String[] args) {
		Occurrence occur = new Occurrence();
		int[] a = {1,5,6,5,6,6};
		System.out.println(occur.isUniqueOccurrence(a));
	}

}
