package br.oo.alexandria.library.views;

import br.oo.alexandria.library.models.Book;
import br.oo.alexandria.library.models.Employee;
import br.oo.alexandria.library.models.LibraryUser;
import br.oo.alexandria.library.models.Manager;
import br.oo.alexandria.library.models.Loan;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public abstract class Screen {

    private static JList<Book> bookList;
    private static JList<LibraryUser> libraryUsersList;
    private static JList<Employee> employeeList;
    private static JList<Manager> managerList;
    private static JList<Loan> loansList;

    private JFrame frame;
    private JPanel mainPanel;

    public Screen(String frameName) {
        this.frame = new JFrame(frameName);
        this.mainPanel = new JPanel();
    }

    public JList<Book> getBookList() {
        return bookList;
    }

    public void setBookList(JList<Book> bookList) {
        this.bookList = bookList;
    }

    public JList<LibraryUser> getLibraryUsersList() {
        return libraryUsersList;
    }

    public void setLibraryUsersList(JList<LibraryUser> libraryUsersList) {
        this.libraryUsersList = libraryUsersList;
    }

    public JList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(JList<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public JList<Manager> getManagerList() {
        return managerList;
    }

    public void setManagerList(JList<Manager> managerList) {
        this.managerList = managerList;
    }

    public static JList<Loan> getLoansList() {
        return loansList;
    }

    public static void setLoansList(JList<Loan> loansList) {
        Screen.loansList = loansList;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public static void main(String[] args) {
        
        BookListingScreen screen = new BookListingScreen();

    }

}
