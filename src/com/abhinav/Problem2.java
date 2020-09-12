package com.abhinav;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Problem2 {
	
	public static void main(String[] args) {
		int [] delhi_to_mumbai = new int[] {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};
		int [] mumbai_to_delhi = new int[] {5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75};
		printCheapestFlights(delhi_to_mumbai, mumbai_to_delhi, 10);

	}
	private static void printCheapestFlights(int[] delhi_to_mumbai, int[] mumbai_to_delhi, int number) {
		List<int[]> kSmallestPairs = getShortestFlights(delhi_to_mumbai, mumbai_to_delhi, number);
		for (int[] elements : kSmallestPairs) {
			System.out.println("[" + elements[0] +  "," + elements[1] + "]");
		}
	}
	
    public static List<int[]> getShortestFlights(int[] first, int[] second, int k) {
        List<int[]> output = new ArrayList<>(k);
        Comparator<? super int[]> comparator = (firstElement, secondElement) -> (firstElement[0] + firstElement[1]) - (secondElement[0] + secondElement[1]);
		PriorityQueue<int[]> queue = new PriorityQueue<>(comparator);
        for(int i = 0; i < first.length; i++) {
            queue.offer(new int[]{first[i], second[0], 0});
        }
        for(int i = 0; i < k; i++) {
            int[] existingElement = queue.poll();
            output.add(new int[]{existingElement[0], existingElement[1]});
            if(existingElement[2] < second.length - 1)
                queue.offer(new int[]{existingElement[0], second[++existingElement[2]], existingElement[2]});
        }
        return output;
    }
}