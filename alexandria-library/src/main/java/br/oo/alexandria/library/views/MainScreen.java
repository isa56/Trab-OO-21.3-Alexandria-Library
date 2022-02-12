package br.oo.alexandria.library.views;

import br.oo.alexandria.library.models.Book;
import br.oo.alexandria.library.models.User;
import javax.swing.JList;

public class MainScreen {

    private JList<Book> bookList;
    private JList<User> usersList;

    public JList<Book> getBookList() {
        return bookList;
    }

    public void setBookList(JList<Book> bookList) {
        this.bookList = bookList;
    }

    public JList<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(JList<User> usersList) {
        this.usersList = usersList;
    }
    
    public static void main(String[] args) {
        LoginScreen screen = new LoginScreen();
        
    }
    
    
    
}
