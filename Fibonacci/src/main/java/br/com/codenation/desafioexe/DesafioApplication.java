package br.com.codenation.desafioexe;

import java.util.List;
import java.util.ArrayList;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < 15; i++) {
			if (i < 2) {
				list.add(i);
			} else {
				int fiboNum = list.get(i - 1) + list.get(i - 2);
				list.add(fiboNum);
			}
		}
		return list;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}

}