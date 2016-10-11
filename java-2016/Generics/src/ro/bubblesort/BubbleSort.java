package ro.bubblesort;

public class BubbleSort<T extends Comparable<T>> {

	public void sort(T[] object) {

		boolean check = true;

		while (check) {
			check = false;
			for (int index = 0; index < object.length - 1; index++) {
				if (object[index].compareTo(object[index + 1]) > 0) {
					T temp = object[index];
					object[index] = object[index + 1];
					object[index + 1] = temp;
					check = true;

				}
			}
		}
	}
}
