
class Book {
    private String callNo;
    private String name;
    private String author;
    private int quantity;
    private int issued;

    public Book(String callNo, String name, String author, int quantity) {
        this.callNo = callNo;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
        this.issued = 0;
    }

    public String getCallNo() {
        return callNo;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getIssued() {
        return issued;
    }

    public void issueBook() {
        if (quantity > issued) {
            issued++;
        }
    }

    public void returnBook() {
        if (issued > 0) {
            issued--;
        }
    }

    @Override
    public String toString() {
        return String.format("Call No: %s, Name: %s, Author: %s, Quantity: %d, Issued: %d",
                callNo, name, author, quantity, issued);
    }
}
