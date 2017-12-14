
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().go();
	}
	void go() {
		Scanner in = new Scanner(System.in);
		Library lib = new Library();
		char answer;
		lib.loadBooks();
		while (true) {
			System.out.println(
					"\nEnter Q)uit"
							+ "\nEnter L)ist all books in library"
							+ "\nEnter A)dd book to library");
			answer = in.nextLine().toUpperCase().charAt(0);
			switch (answer) {
				case 'Q':
					lib.saveBooks();
					System.exit(0);
					break;
				case 'L':
					lib.listBooks();
					break;
				case 'A':
					lib.addBook();
					break;
			}
		}
	}
}
