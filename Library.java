import java.util.List;
import java.util.ArrayList;

public class Library {

	private final String address;
	private List<MainBook> mainbooks;

	public Library(String address) {
		this.address = address;
		this.mainbooks = new ArrayList<MainBook>();
	}

	public void addbook(MainBook mainbook) {
		this.mainbooks.add(mainbook);
	}

	public void borrowbook(String bookTitle) {
		boolean existbook = false;
		for (MainBook book : this.mainbooks) {
		
			if (book.getTitle().equals(bookTitle)) {

				if (book.isBorrowed()) {
					System.out.println("Sorry It's Taken");
				} else {
					book.borrowed();
					System.out.println("You've got a Book!");
				}
				existbook = true;
				break;
			}
			if (!existbook) {
				System.out.println("Sorry not Available!");
			}
		}
	}

	public void returnbook(String bookTitle) {
		boolean existbook = false;
		for (MainBook mainbook : this.mainbooks) {
			if (mainbook.getTitle().equals(bookTitle)) {
				mainbook.returned();
				System.out.println("Its been returned");
			} else {
				System.out.println("Already returned");

			}
			existbook = true;
			break;
		}
		if (!existbook) {
			System.out.println("Not in store");
		}

	}

	public static void printOpeningHours() {
		System.out.println("Library opens from 9 to 5");
	}

	public void printAddress() {
		System.out.println(""+ this.address);
	}

	public void printAvailablebooks() {
		boolean mainAvailablebooks = false;
		for (MainBook mainbook : this.mainbooks) {
			if (!mainbook.isBorrowed()) {
				System.out.println("" + mainbook.getTitle());
			}
		}
		if (!mainAvailablebooks) {
			System.out.println("No Books for you!");
		}

	}
}
