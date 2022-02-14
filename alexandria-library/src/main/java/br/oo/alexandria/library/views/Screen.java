package br.oo.alexandria.library.views;

import br.oo.alexandria.library.controllers.WindowEvents;
import br.oo.alexandria.library.models.Loan;
import br.oo.alexandria.library.models.Book;
import br.oo.alexandria.library.models.Employee;
import br.oo.alexandria.library.models.Genre;
import br.oo.alexandria.library.models.LibraryUser;
import br.oo.alexandria.library.models.Manager;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen {

    private static List<Book> bookList = new ArrayList<>();
    private static List<LibraryUser> libraryUsersList = new ArrayList<>();
    private static List<Employee> employeeList = new ArrayList<>();
    private static List<Manager> managerList = new ArrayList<>();
    private static List<Loan> loansList = new ArrayList<>();

    private JFrame frame;
    private JPanel mainPanel;

    public Screen(String frameName) {
        this.frame = new JFrame(frameName);
        this.mainPanel = new JPanel();

        this.frame.addWindowListener(new WindowEvents(this));
    }

    public static List<Manager> getManagerList() {
        return managerList;
    }

    public static void setManagerList(List<Manager> managerList) {
        Screen.managerList = managerList;
    }

    public static List<Employee> getEmployeeList() {
        return employeeList;
    }

    public static void setEmployeeList(List<Employee> employeeList) {
        Screen.employeeList = employeeList;
    }

    public static List<LibraryUser> getLibraryUsersList() {
        return libraryUsersList;
    }

    public static void setLibraryUsersList(List<LibraryUser> libraryUsersList) {
        Screen.libraryUsersList = libraryUsersList;
    }

    public static List<Book> getBookList() {
        return bookList;
    }

    public static void setBookList(List<Book> bookList) {
        Screen.bookList = bookList;
    }

    public static List<Loan> getLoansList() {
        return loansList;
    }

    public static void setLoansList(List<Loan> list) {
        Screen.loansList = list;
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
        
        BookDetailsScreen screen = new BookDetailsScreen(new Book(
                "Conectadas",
                "Clara Alves",
                "Não sei",
                2020,
                Genre.ROMANCE
        ));

    }

}
