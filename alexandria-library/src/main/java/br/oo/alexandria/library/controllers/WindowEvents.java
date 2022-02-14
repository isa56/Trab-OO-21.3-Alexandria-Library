package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.models.Book;
import br.oo.alexandria.library.models.Employee;
import br.oo.alexandria.library.models.LibraryUser;
import br.oo.alexandria.library.models.Loan;
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
    private static String dataPath = "src/main/java/br/oo/alexandria/library/data/";

    public WindowEvents(Screen screen) {
        this.screen = screen;
    }

    @Override
    public void windowOpened(WindowEvent e) {

        
        // Ler arquivo de livros:
        try {
            String readBookFile = FileIO.readFile(dataPath + "bookdata.json");
            Screen.setBookList(JSON.toBooks(readBookFile));

        } catch (FileNotFoundException ex) {
        }
        

        // Ler arquivo de usuários da biblioteca:
        try {
            String readUserFile = FileIO.readFile(dataPath + "userdata.json");
            Screen.setLibraryUsersList(JSON.toLibraryUsers(readUserFile));

        } catch (FileNotFoundException ex) {
        }
        
        
        // Ler arquivo de funcionários:
        try {
            String readEmployeeFile = FileIO.readFile(dataPath + "employeedata.json");
            Screen.setEmployeeList(JSON.toEmployees(readEmployeeFile));

        } catch (FileNotFoundException ex) {
        }
        
        
        // Ler arquivo de administradores:
        try {
            String readManagerFile = FileIO.readFile(dataPath + "managerdata.json");
            Screen.setManagerList(JSON.toManagers(readManagerFile));

        } catch (FileNotFoundException ex) {}

        
        // Ler arquivo de empréstimos:
        try {
            String readManagerFile = FileIO.readFile(dataPath + "loandata.json");
            Screen.setLoansList(JSON.toLoans(readManagerFile));

        } catch (FileNotFoundException ex) {}

        screen.getFrame().repaint();
    }

    @Override
    public void windowClosing(WindowEvent e) {

        
        // Salvando a lista de livros:
        String booksToJSON = JSON.toJSON(Screen.getBookList());

        System.out.println(booksToJSON);

        FileIO.writeFile(dataPath + "bookdata.json", booksToJSON);

        
        // Salvando a lista de usuários:
        String libUserToJSON = JSON.toJSON(Screen.getLibraryUsersList());

        System.out.println(libUserToJSON);

        FileIO.writeFile(dataPath + "userdata.json", libUserToJSON);

        
        // Salvando a lista de funcionários:
        String employeeToJSON = JSON.toJSON(Screen.getEmployeeList());

        System.out.println(employeeToJSON);

        FileIO.writeFile(dataPath + "employeedata.json", employeeToJSON);

        
        // Salvando a lista de gerentes:
        String managerToJSON = JSON.toJSON(Screen.getManagerList());

        System.out.println(managerToJSON);

        FileIO.writeFile(dataPath + "managerdata.json", managerToJSON);

        
        // Salvando a lista de empréstimos:
        String loanToJSON = JSON.toJSON(Screen.getLoansList());

        System.out.println(loanToJSON);

        FileIO.writeFile(dataPath + "loandata.json", loanToJSON);
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
