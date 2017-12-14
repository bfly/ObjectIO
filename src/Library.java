
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Library {

	private List<Book> collection  = new ArrayList<>();
	private ObjectIO<List<Book>> objectIO = new ObjectIO<>(fn);
	private Scanner in = new Scanner(System.in);
	public static final String format = "%-35s %-25s %-15s %10s";
	private static String fn = "books";

	public void listBooks() {
		System.out.println();
		System.out.format(format, "Title", "Author", "ISBN", "Price");
		System.out.println();
		System.out.println(toString());
	}


	@Override
	public String toString() {
		StringBuilder total = new StringBuilder("");
		for (Book b: collection) total.append(b.toString());
		return new String(total);
	}

	void addBook() {
		String DOUBLE_PATTERN = "\\d+(\\.\\d+)?";
		String LONG_PATTERN = "^-?\\d{1,19}$";
		long isbn = 0;
		String title = "";
		String author = "";
		double price = 0.00;
		String temp;

		System.out.println("\nEnter Title: ");
		while (title.isEmpty())
			title = in.nextLine();

		System.out.println("\nEnter Author: ");
		while (author.isEmpty())
			author = in.nextLine();

		System.out.println("\nEnter ISBN: ");
		while(isbn == 0) {
			temp = in.nextLine();
			if (Pattern.matches(LONG_PATTERN, temp)) isbn = Long.parseLong(temp);
		}

		System.out.println("\nEnter Price: ");
		while(price == 0.00) {
			temp = in.nextLine();
			if (Pattern.matches(DOUBLE_PATTERN, temp)) price = Double.parseDouble(temp);
		}

		collection.add(new Book(isbn, title, author, price));
	}

	public void saveBooks() {
	    objectIO.save(collection);
    }

    public void loadBooks() {
	    collection = objectIO.load();
    }
/*

	public void saveBooks() {
		String fileName = fn + ".ser";
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(collection);
			fos.close();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings(value="unchecked")
	public void loadBooks() {
		String fileName = fn + ".ser";
		try {
			ObjectInputStream ois = new ObjectInputStream( new FileInputStream( fileName ) );
			collection = (List<Book>) ois.readObject();
		}
		catch (Exception ignored) {}
	}
*/
}
