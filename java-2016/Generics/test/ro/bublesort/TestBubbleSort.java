package ro.bublesort;

import org.junit.Assert;
import org.junit.Test;
import ro.bubblesort.BubbleSort;

public class TestBubbleSort {

	@Test
	public void testString() {

		String[] unsortedNames = new String[] { "Ovidiu", "Paul", "Adrian", "Adrian", "Mihai", "Mircea" };
		String[] sortedNames = new String[] { "Adrian", "Adrian", "Mihai", "Mircea", "Ovidiu", "Paul" };
		BubbleSort<String> sorter = new BubbleSort<String>();
		sorter.sort(unsortedNames);
		Assert.assertArrayEquals(unsortedNames, sortedNames);

	}

	@Test
	public void testInteger() {

		Integer[] unsortedNumbers = new Integer[] { 4, 8, 1, 99, 0, 0, 24, 56 };
		Integer[] sortedNumbers = new Integer[] { 0, 0, 1, 4, 8, 24, 56, 99 };
		BubbleSort<Integer> sorter = new BubbleSort<Integer>();
		sorter.sort(unsortedNumbers);
		Assert.assertArrayEquals(unsortedNumbers, sortedNumbers);

	}

	@Test
	public void testChar() {

		Character[] unsortedChar = new Character[] { 'x', 'f', 'r', 'o', 'b', 'a' };
		Character[] sortedChar = new Character[] { 'a', 'b', 'f', 'o', 'r', 'x' };
		BubbleSort<Character> sorter = new BubbleSort<Character>();
		sorter.sort(unsortedChar);
		Assert.assertArrayEquals(unsortedChar, sortedChar);

	}

	@Test
	public void testDouble() {

		Double[] unsortedDouble = new Double[] { 3.22, 6.4, 7.25, 64.3, 683.2, 1.5, 6.3 };
		Double[] sortedDouble = new Double[] { 1.5, 3.22, 6.3, 6.4, 7.25, 64.3, 683.2 };
		BubbleSort<Double> sorter = new BubbleSort<Double>();
		sorter.sort(unsortedDouble);
		Assert.assertArrayEquals(unsortedDouble, sortedDouble);

	}

}
