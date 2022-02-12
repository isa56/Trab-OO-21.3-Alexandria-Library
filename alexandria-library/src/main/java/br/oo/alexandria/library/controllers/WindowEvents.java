package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.models.Book;
import br.oo.alexandria.library.models.Employee;
import br.oo.alexandria.library.models.LibraryUser;
import br.oo.alexandria.library.models.Manager;
import br.oo.alexandria.library.models.User;
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
            Screen.setBookList(JSON.toBooks(readBookFile));

        } catch (FileNotFoundException ex) {
        }

        // Ler arquivo de usuários da biblioteca:
        try {
            String readUserFile = FileIO.readFile("data/userdata");
            Screen.setLibraryUsersList(JSON.toLibraryUsers(readUserFile));

        } catch (FileNotFoundException ex) {
        }
        
        // Ler arquivo de funcionários:
        try {
            String readEmployeeFile = FileIO.readFile("data/employeedata");
            Screen.setEmployeeList(JSON.toEmployees(readEmployeeFile));

        } catch (FileNotFoundException ex) {
        }
        
        // Ler arquivo de administradores:
        try {
            String readManagerFile = FileIO.readFile("data/managerdata");
            Screen.setManagerList(JSON.toManagers(readManagerFile));

        } catch (FileNotFoundException ex) {
        }

        screen.getFrame().repaint();
    }

    @Override
    public void windowClosing(WindowEvent e) {

        // Salvando a lista de livros:
        String booksToJSON = JSON.toJSON(Screen.getBookList());

        System.out.println(booksToJSON);

        FileIO.writeFile("data/bookdata", booksToJSON);

        // Salvando a lista de usuários:
        String libUserToJSON = JSON.toJSON(Screen.getLibraryUsersList());

        System.out.println(libUserToJSON);

        FileIO.writeFile("data/userdata", libUserToJSON);

        // Salvando a lista de funcionários:
        String employeeToJSON = JSON.toJSON(Screen.getEmployeeList());

        System.out.println(employeeToJSON);

        FileIO.writeFile("data/employeedata", employeeToJSON);

        // Salvando a lista de gerentes:
        String managerToJSON = JSON.toJSON(Screen.getManagerList());

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
