import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class LibraryManagementSystem {
    private Library library = new Library();

    public LibraryManagementSystem() {
        JFrame frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());

        JLabel headerLabel = new JLabel("Library Management System", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 22));
        frame.add(headerLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        JButton addBookButton = new JButton("Add Book");
        addBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addBookDialog();
            }
        });

        JButton viewBooksButton = new JButton("View Books");
        viewBooksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewBooksDialog();
            }
        });

        JButton issueBookButton = new JButton("Issue Book");
        issueBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                issueBookDialog();
            }
        });

        JButton returnBookButton = new JButton("Return Book");
        returnBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                returnBookDialog();
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(addBookButton);
        panel.add(viewBooksButton);
        panel.add(issueBookButton);
        panel.add(returnBookButton);
        panel.add(exitButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void addBookDialog() {
        JTextField callNoField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JTextField authorField = new JTextField(10);
        JTextField quantityField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Call No:"));
        panel.add(callNoField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Author:"));
        panel.add(authorField);
        panel.add(new JLabel("Quantity:"));
        panel.add(quantityField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add New Book", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String callNo = callNoField.getText();
            String name = nameField.getText();
            String author = authorField.getText();
            int quantity = Integer.parseInt(quantityField.getText());

            library.addBook(new Book(callNo, name, author, quantity));
            JOptionPane.showMessageDialog(null, "Book added successfully.");
        }
    }

    private void viewBooksDialog() {
        List<Book> books = library.getBooks();
        StringBuilder booksList = new StringBuilder();
        for (Book book : books) {
            booksList.append(book.toString()).append("\n");
        }

        JTextArea textArea = new JTextArea(10, 40);
        textArea.setText(booksList.toString());
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollPane, "View Books", JOptionPane.INFORMATION_MESSAGE);
    }

    private void issueBookDialog() {
        String callNo = JOptionPane.showInputDialog("Enter Call No of the Book to Issue:");
        if (callNo != null) {
            library.issueBook(callNo);
        }
    }

    private void returnBookDialog() {
        String callNo = JOptionPane.showInputDialog("Enter Call No of the Book to Return:");
        if (callNo != null) {
            library.returnBook(callNo);
        }
    }

    public static void main(String[] args) {
        new LibraryManagementSystem();
    }
}
