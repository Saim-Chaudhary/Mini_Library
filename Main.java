import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class Book {
    private String title;
    private String author;
    private int yearPublished;
    private boolean isAvailable;

    public Book(String title, String author, int yearPublished, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBooks(Book book) {
        this.books.add(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Year Published: " + book.getYearPublished() + ", Availability: " + book.getIsAvailable());
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}

public class Main {
    static Library library = new Library();

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(320, 500);
        frame.setTitle("Mini Library");

        JLabel heading = new JLabel();
        heading.setText("**Welcome to Mini Library**");
        heading.setBounds(70, 10, 220, 30);

        JLabel bookTitle = new JLabel();
        bookTitle.setText("Book Title:");
        bookTitle.setBounds(70, 50, 100, 30);

        JTextField nameofBook = new JTextField();
        nameofBook.setBounds(65, 90, 180, 25);

        JLabel authorTitle = new JLabel();
        authorTitle.setText("Author:");
        authorTitle.setBounds(70, 130, 100, 30);

        JTextField nameofAuthor = new JTextField();
        nameofAuthor.setBounds(65, 170, 180, 25);

        JLabel yearPublishedLabel = new JLabel();
        yearPublishedLabel.setText("Year Published:");
        yearPublishedLabel.setBounds(70, 210, 100, 30);

        JTextField yearPublished = new JTextField();
        yearPublished.setBounds(65, 250, 180, 25);

        JLabel available = new JLabel();
        available.setText("Availability:");
        available.setBounds(70, 290, 100, 30);

        JTextField setAvailable = new JTextField();
        setAvailable.setBounds(65, 330, 180, 25);

        JButton toAddBook = new JButton();
        toAddBook.setText("Add Book");
        toAddBook.setBounds(65, 370, 90, 25);

        JButton toDisplay = new JButton();
        toDisplay.setText("Display Books");
        toDisplay.setBounds(160, 370, 90, 25);

        toAddBook.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String bookTitle = nameofBook.getText();
                String author = nameofAuthor.getText();
                String year = yearPublished.getText();
                String availability = setAvailable.getText();
                if (bookTitle.isEmpty() || author.isEmpty() || year.isEmpty() || availability.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields");
                } else {
                    Book book = new Book(bookTitle, author, Integer.parseInt(year), Boolean.parseBoolean(availability));
                    library.addBooks(book);
                    JOptionPane.showMessageDialog(null, "Book Added Successfully");
                    nameofBook.setText("");
                    nameofAuthor.setText("");
                    yearPublished.setText("");
                    setAvailable.setText("");
                }
            }
        });

        toDisplay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder bookList = new StringBuilder();
                library.displayBooks();
                for (Book book : library.getBooks()) {
                    bookList.append("Title: ").append(book.getTitle()).append(", Author: ").append(book.getAuthor()).append(", Year Published: ").append(book.getYearPublished()).append(", Availability: ").append(book.getIsAvailable()).append("\n");
                }
                JOptionPane.showMessageDialog(null, bookList.toString());
            }
        });
        frame.add(heading);
        frame.add(authorTitle);
        frame.add(bookTitle);
        frame.add(nameofBook);
        frame.add(yearPublishedLabel);
        frame.add(yearPublished);
        frame.add(available);
        frame.add(setAvailable);
        frame.add(nameofAuthor);
        frame.add(toAddBook);
        frame.add(toDisplay);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
