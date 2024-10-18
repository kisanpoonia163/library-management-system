import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book findBookByCallNo(String callNo) {
        for (Book book : books) {
            if (book.getCallNo().equalsIgnoreCase(callNo)) {
                return book;
            }
        }
        return null;
    }

    public void issueBook(String callNo) {
        Book book = findBookByCallNo(callNo);
        if (book != null && book.getQuantity() > book.getIssued()) {
            book.issueBook();
            JOptionPane.showMessageDialog(null, "Book issued successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Book is not available for issuing.");
        }
    }

    public void returnBook(String callNo) {
        Book book = findBookByCallNo(callNo);
        if (book != null && book.getIssued() > 0) {
            book.returnBook();
            JOptionPane.showMessageDialog(null, "Book returned successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid return request.");
        }
    }
}
