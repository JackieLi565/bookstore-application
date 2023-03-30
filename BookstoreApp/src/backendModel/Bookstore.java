package backendModel;

import java.util.ArrayList;

/**
 *
 * @author lijac
 */
public class Bookstore {
    private final Query database;
    private static Bookstore instance;
    private static final String CF = "Customers.txt";
    private static final String BF = "Books.txt";
    private Account currentUser;
    public Bookstore() {
        database = Query.getInstance(CF, BF);
        this.currentUser = null;
    }
    
    
        public Bookstore getInstance() {
        if(instance == null) {
            instance = new Bookstore();
        }
        return instance;
    }
    
    
    private void setUser(Account user) {
        this.currentUser = user;
    }
    
    public Account getUser() {
        return this.currentUser;
    }
    
    public ArrayList<Account> loadUserData() {
        return database.getCustomers();
    }
    
    public ArrayList<Book> loadBookData() {
        return database.getBooks();
    }
    
    private void updateDatabase() {
        database.saveToDataBase();
    }
    
    public void addBook(Book book) {
        database.addBook(book);
    }
    
    public void addCustomer(Customer customer) {
        database.addCustomer(customer);
    }
    
    public void logout() {
        this.currentUser = null;
    }
    
    public Account searchCustomer(Customer customer) {
        // add search later
        return null;
    }
    
    public Book searchCustomer(Book book) {
        // add search later
        return null;
    }
    
    public boolean login(String username, String password) {
        ArrayList<Account> list = database.getCustomers();
        for(Account customer: list) {
            if(customer.getUserName().equals(username) && customer.getPassword().equals(password)){
                setUser(customer);
                return true;
            }
        }
        return false;
    }
}
