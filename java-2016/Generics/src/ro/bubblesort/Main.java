package ro.bubblesort;

import java.util.logging.Logger;

/*
 * This a simple program wich can sort different object using Bubble Sort method of sorting.
 * 
 * @author Ovidiu Pacurar
 */

public class Main {

	public static void main(String[] args) {

		// For the logger to work properly you have to create the folder Temp 
		// (e.g C:\Temp) and start the virtual machine with arguments 
		// -Djava.util.logging.config.file=logging.properties

		Logger logger = Logger.getLogger("Log");

		logger.info("Start logging");

		logger.info("Start sorting");

		// Compare integers

		BubbleSort<Integer> sorter = new BubbleSort<Integer>();
		Integer[] unsortedNumbers = new Integer[] { 1, 43, 78, 10, 2, 99, 6, 364, 2, 0, 3, 0 };
		sorter.sort(unsortedNumbers);

		for (int i = 0; i < unsortedNumbers.length; i++) {
			System.out.println(unsortedNumbers[i]);

		}

		logger.info("End of sorting");

	}

}
