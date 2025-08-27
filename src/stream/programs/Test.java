package stream.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abc";
		List<String> list = new ArrayList<>();
		char ch[] = s1.toCharArray();
		
		perm(ch, ch.length,0,list);
		System.out.println(list);
		
		String[] arr = {"anuj", "ravi", "hari", "ravi", "hari", "amit"};
		List<String> lists= Arrays.stream(arr).distinct().collect(Collectors.toList());
		System.out.println(lists);
		
		String freq = "anujamitabhineeraj";
		Map<Character, Long> frequency =  freq.chars().mapToObj(c -> (char) c)
									.collect(Collectors.groupingBy(Function.identity(), 
											Collectors.counting()));
		
		System.out.println(frequency);
		
		int[] ar = {6,8,3,5,2,9,4};
		
		int num = Arrays.stream(ar).mapToObj(c-> c).sorted(Collections.reverseOrder()).skip(1).findFirst().orElseThrow();
		System.out.println("Second highest number: "+num);
		
		String nonRep = "nurjopnjou";
		
		// using stream
		nonRep.chars().mapToObj(o-> (char) o).collect(Collectors.
		groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).
		entrySet().stream().filter(s-> s.getValue()==1).map(s->s.getKey()).findFirst().ifPresent(System.out::println);
		
		//using loop
		Map<Character, Integer> maps = new LinkedHashMap<>();
		for(char i : nonRep.toCharArray()) {
			maps.put(i, maps.getOrDefault(i, 0)+1);
		}
		for(Map.Entry<Character, Integer> m : maps.entrySet()) {
			if(m.getValue()==1) {
				System.out.print(m.getKey());
				break;
			}
		}

	}
	
	static void perm(char ch[], int len, int index, List<String> list) {
		if(index==ch.length) {
			list.add(new String(ch));
			return;
		}
		
		for(int i=index;i<len;i++) {
			swap(i, index, ch);
			perm(ch, len, index+1,list);
			swap(i, index, ch);
		}
	}
	private static void swap(int i, int j, char s1[]) {
		char temp = s1[i];
		s1[i] = s1[j];
		s1[j] = temp;
		
	}

}
