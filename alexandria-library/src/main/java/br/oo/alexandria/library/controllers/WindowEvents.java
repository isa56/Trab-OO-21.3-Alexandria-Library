package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.models.Book;
import br.oo.alexandria.library.models.Employee;
import br.oo.alexandria.library.models.LibraryUser;
import br.oo.alexandria.library.models.Manager;
import br.oo.alexandria.library.util.FileIO;
import br.oo.alexandria.library.util.JSON;
import br.oo.alexandria.library.views.Screen;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class WindowEvents implements WindowListener {

    Screen screen;

    public WindowEvents(Screen screen) {
        this.screen = screen;
    }

    @Override
    public void windowOpened(WindowEvent e) {

        // Ler arquivo de livros:
        try {
            String readBookFile = FileIO.readFile("data/bookdata");
            List<Book> bookList = JSON.toBooks(readBookFile);

            DefaultListModel<Book> bookModel = new DefaultListModel<>();

            for (Book book : bookList) {
                bookModel.addElement(book);
            }

            screen.getBookList().setModel(bookModel);

        } catch (FileNotFoundException ex) {
        }

        // Ler arquivo de usuários da biblioteca:
        try {
            String readUserFile = FileIO.readFile("data/userdata");
            List<LibraryUser> userList = JSON.toLibraryUsers(readUserFile);

            DefaultListModel<LibraryUser> userModel = new DefaultListModel<>();

            for (LibraryUser user : userList) {
                userModel.addElement(user);
            }

            screen.getLibraryUsersList().setModel(userModel);

        } catch (FileNotFoundException ex) {
        }
        
        // Ler arquivo de funcionários:
        try {
            String readEmployeeFile = FileIO.readFile("data/employeedata");
            List<Employee> employeeList = JSON.toEmployees(readEmployeeFile);

            DefaultListModel<Employee> employeeModel = new DefaultListModel<>();

            for (Employee user : employeeList) {
                employeeModel.addElement(user);
            }

            screen.getEmployeeList().setModel(employeeModel);

        } catch (FileNotFoundException ex) {
        }
        
        // Ler arquivo de administradores:
        try {
            String readManagerFile = FileIO.readFile("data/managerdata");
            List<Manager> managerList = JSON.toManagers(readManagerFile);

            DefaultListModel<Manager> managerModel = new DefaultListModel<>();

            for (Manager user : managerList) {
                managerModel.addElement(user);
            }

            screen.getManagerList().setModel(managerModel);

        } catch (FileNotFoundException ex) {
        }

        screen.getFrame().repaint();
    }

    @Override
    public void windowClosing(WindowEvent e) {

        // Salvando a lista de livros:
        ListModel<Book> bookModel = screen.getBookList().getModel();
        List<Book> books = new ArrayList<>();

        for (int i = 0; i < bookModel.getSize(); i++) {
            books.add(bookModel.getElementAt(i));
        }

        String booksToJSON = JSON.toJSON(books);

        System.out.println(booksToJSON);

        FileIO.writeFile("data/bookdata", booksToJSON);

        // Salvando a lista de usuários:
        ListModel<LibraryUser> libUserModel = screen.getLibraryUsersList().getModel();
        List<LibraryUser> libUsers = new ArrayList<>();

        for (int i = 0; i < libUserModel.getSize(); i++) {
            libUsers.add(libUserModel.getElementAt(i));
        }

        String libUserToJSON = JSON.toJSON(libUsers);

        System.out.println(libUserToJSON);

        FileIO.writeFile("data/userdata", libUserToJSON);

        // Salvando a lista de funcionários:
        ListModel<Employee> employeeModel = screen.getEmployeeList().getModel();
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < employeeModel.getSize(); i++) {
            employees.add(employeeModel.getElementAt(i));
        }

        String employeeToJSON = JSON.toJSON(employees);

        System.out.println(employeeToJSON);

        FileIO.writeFile("data/employeedata", employeeToJSON);

        // Salvando a lista de gerentes:
        ListModel<Manager> managerModel = screen.getManagerList().getModel();
        List<Manager> managers = new ArrayList<>();

        for (int i = 0; i < managerModel.getSize(); i++) {
            managers.add(managerModel.getElementAt(i));
        }

        String managerToJSON = JSON.toJSON(managers);

        System.out.println(managerToJSON);

        FileIO.writeFile("data/managerdata", managerToJSON);

    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
