import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class User {

	public String name;
	public LocalDate dateOfBirth;
	public ArrayList<Book> books = new ArrayList<Book>();

	
	User(String name, String dateOfBirth){
		this.name = name;
		this.dateOfBirth = LocalDate.parse(dateOfBirth);
	
	}
public void borrow (Book book){
		this.books.add(book);
	}

	public int age(){

		int age	= Period.between(this.dateOfBirth, LocalDate.now()).getYears();
		return age;
	}

}