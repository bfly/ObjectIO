
import java.io.Serializable;
import java.text.DecimalFormat;


public class Book implements Serializable{

	private long isbn;
	private String title, author;
	private double price;

	public Book(long isbn, String title, String author, double price){
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	@Override
	public String toString(){
		DecimalFormat df = new DecimalFormat("0.00");
		return (String.format(Library.format, title, author, isbn, df.format(price)) + "\n");
	}

}
