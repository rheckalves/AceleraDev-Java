package br.com.codenation;

import java.util.*;

public class StatisticUtil {

	public static int average(int[] elements) {
		List<Integer> intList = new ArrayList<>();
		for (int num : elements) {
			intList.add(num);
		}
		Integer sum = intList.stream().reduce(0, Integer::sum);
		return sum / intList.size();
	}

	public static int mode(int[] elements) {
		int mode = 0;
		List<Integer> intList = new ArrayList<>();
		List<Integer> repeteadTimes = new ArrayList<>();
		for (int num : elements) {
			intList.add(num);
		}
		for (int num : intList) {
			int repeated = 0;
			for (Integer integer : intList) {
				if (num == integer) {
					repeated++;
				}
			}
			repeteadTimes.add(repeated);
		}
		int maxRepeat = Collections.max(repeteadTimes);
		int indexMaxRepeat = repeteadTimes.indexOf(maxRepeat);
		mode = intList.get(indexMaxRepeat);
		return mode;
	}

	public static int median(int[] elements) {
		int median = 0;
		List<Integer> intList = new ArrayList<>();
		for (int num : elements) {
			intList.add(num);
		}
		double listSize = (double) intList.size();
		if (listSize % 2 == 0) {
			int middleNum = (int) listSize / 2;
			median = (intList.get(middleNum) + intList.get(middleNum - 1)) / 2;
		} else {
			median = (int) Math.ceil(listSize / 2);
		}
		return median;
	}
}