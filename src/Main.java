import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insertion_sort insertion = new insertion_sort();
		merge_sort merge = new merge_sort();
		int student_counter = 0;
		String[] splitWords = null;
		Student[] studentArray = new Student[calculate_student_counter() - 1];
		int[] insertionArray = new int[calculate_student_counter() - 1];
		int[] mergeArray = new int[calculate_student_counter() - 1];

		try {
			File Obj = new File("student.txt");
			Scanner Reader = new Scanner(Obj);
			while (Reader.hasNextLine()) {
				splitWords = Reader.nextLine().split(",");
				if (student_counter != 0) {
					studentArray[student_counter - 1] = new Student(splitWords[0], splitWords[1],
							Integer.parseInt(splitWords[2])); // yeni bir öğrenci oluşturuyor
					insertionArray[student_counter - 1] = Integer.parseInt(splitWords[2]);
					mergeArray[student_counter - 1] = Integer.parseInt(splitWords[2]);
				}
				student_counter++;
			}
			Reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error has occurred.");
			e.printStackTrace();
		}

		// P A R T 1
		System.out.println("Part 1 Insertion Sort:");
		int[] part1Array = { 4, 3, 2, 10, 12, 1, 5, 6 };
		insertion.insertion_sort_method(part1Array);
		for (int i = 0; i < part1Array.length; i++) {
			System.out.println(part1Array[i]);
		}

		// P A R T 2
		System.out.println("\nPart 2 Merge Sort:");
		int[] part2Array = { 4, 3, 2, 10, 12, 1, 5, 6 };
		insertion.insertion_sort_method(part2Array);
		for (int i = 0; i < part2Array.length; i++) {
			System.out.println(part2Array[i]);
		}

		// P A R T 3
		// I N S E R T I O N S O R T
		System.out.println("\nInsertion Sort:");
		insertion.insertion_sort_method(insertionArray);
		for (int i = 0; i < insertionArray.length; i++) {
			for (int j = 0; j < studentArray.length; j++) {
				if (insertionArray[i] == studentArray[j].getId()) // id'leri karşılaştırarak student'daki kişileri
																	// sıralı şekilde ekrana yazdırıyor
					System.out.println(studentArray[j].getId() + " " + studentArray[j].getName() + " "
							+ studentArray[j].getSurname());
			}
		}

		// P A R T 3
		// M E R G E S O R T
		System.out.println("\n\nMerge Sort:");
		merge.merge_sort_method(mergeArray, 0, mergeArray.length - 1);
		for (int i = 0; i < mergeArray.length; i++) {
			for (int j = 0; j < studentArray.length; j++) {
				if (mergeArray[i] == studentArray[j].getId())// id'leri karşılaştırarak student'daki kişileri sıralı
																	// şekilde ekrana yazdırıyor
					System.out.println(studentArray[j].getId() + " " + studentArray[j].getName() + " "
							+ studentArray[j].getSurname());
			}
		}

	}

	static int calculate_student_counter() {
		int counter = 0;

		try {
			File Obj = new File("student.txt");
			Scanner Reader = new Scanner(Obj);
			while (Reader.hasNextLine()) {
				Reader.nextLine();
				counter++;
			}
			Reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error has occurred.");
			e.printStackTrace();
		}
		return counter;
	}

}
