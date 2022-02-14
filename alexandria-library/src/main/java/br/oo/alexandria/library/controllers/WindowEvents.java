package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.models.Book;
import br.oo.alexandria.library.util.Constants;
import br.oo.alexandria.library.util.FileIO;
import br.oo.alexandria.library.util.JSON;
import br.oo.alexandria.library.views.Screen;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;

public class WindowEvents implements WindowListener {

    Screen screen;

    public WindowEvents(Screen screen) {
        this.screen = screen;
    }

    @Override
    public void windowOpened(WindowEvent e) {

        // Ler arquivo de livros:
        try {
            String readBookFile = FileIO.readFile(Constants.DATA_PATH + "bookdata.json");
            Screen.setBookList(JSON.toBooks(readBookFile));

        } catch (FileNotFoundException ex) {
        }
        

        // Ler arquivo de usuários da biblioteca:
        try {
            String readUserFile = FileIO.readFile(Constants.DATA_PATH + "userdata.json");
            Screen.setLibraryUsersList(JSON.toLibraryUsers(readUserFile));

        } catch (FileNotFoundException ex) {
        }
        
        
        // Ler arquivo de funcionários:
        try {
            String readEmployeeFile = FileIO.readFile(Constants.DATA_PATH + "employeedata.json");
            Screen.setEmployeeList(JSON.toEmployees(readEmployeeFile));

        } catch (FileNotFoundException ex) {
        }
        
        
        // Ler arquivo de administradores:
        try {
            String readManagerFile = FileIO.readFile(Constants.DATA_PATH + "managerdata.json");
            Screen.setManagerList(JSON.toManagers(readManagerFile));

        } catch (FileNotFoundException ex) {}

        
        // Ler arquivo de empréstimos:
        try {
            String readManagerFile = FileIO.readFile(Constants.DATA_PATH + "loandata.json");
            Screen.setLoansList(JSON.toLoans(readManagerFile));

        } catch (FileNotFoundException ex) {}

        this.screen.getFrame().repaint();
    }

    @Override
    public void windowClosing(WindowEvent e) {

        for (Book book : Screen.getBookList()) {
            System.out.println(book.getBookName());
        }
        
        // Salvando a lista de livros:
        String booksToJSON = JSON.toJSON(Screen.getBookList());

        System.out.println(booksToJSON);
        // System.out.println("Livros salvos");

        FileIO.writeFile(Constants.DATA_PATH + "bookdata.json", booksToJSON);

        
        // Salvando a lista de usuários:
        String libUserToJSON = JSON.toJSON(Screen.getLibraryUsersList());

        // System.out.println(libUserToJSON);
        System.out.println("Usuários salvos");

        FileIO.writeFile(Constants.DATA_PATH + "userdata.json", libUserToJSON);

        
        // Salvando a lista de funcionários:
        String employeeToJSON = JSON.toJSON(Screen.getEmployeeList());

        // System.out.println(employeeToJSON);
        System.out.println("Funcionários salvos");


        FileIO.writeFile(Constants.DATA_PATH + "employeedata.json", employeeToJSON);

        
        // Salvando a lista de gerentes:
        String managerToJSON = JSON.toJSON(Screen.getManagerList());

        // System.out.println(managerToJSON);
        System.out.println("Gerentes salvos");

        FileIO.writeFile(Constants.DATA_PATH + "managerdata.json", managerToJSON);

        
        // Salvando a lista de empréstimos:
        String loanToJSON = JSON.toJSON(Screen.getLoansList());

        // System.out.println(loanToJSON);
        System.out.println("Empréstimos salvos");


        FileIO.writeFile(Constants.DATA_PATH + "loandata.json", loanToJSON);
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

    public static void saveFile() {
        
        for (Book book : Screen.getBookList()) {
            System.out.println(book.getBookName());
        }
        
        // Salvando a lista de livros:
        String booksToJSON = JSON.toJSON(Screen.getBookList());

        System.out.println(booksToJSON);
        // System.out.println("Livros salvos");

        FileIO.writeFile(Constants.DATA_PATH + "bookdata.json", booksToJSON);

        
        // Salvando a lista de usuários:
        String libUserToJSON = JSON.toJSON(Screen.getLibraryUsersList());

        // System.out.println(libUserToJSON);
        System.out.println("Usuários salvos");

        FileIO.writeFile(Constants.DATA_PATH + "userdata.json", libUserToJSON);

        
        // Salvando a lista de funcionários:
        String employeeToJSON = JSON.toJSON(Screen.getEmployeeList());

        // System.out.println(employeeToJSON);
        System.out.println("Funcionários salvos");


        FileIO.writeFile(Constants.DATA_PATH + "employeedata.json", employeeToJSON);

        
        // Salvando a lista de gerentes:
        String managerToJSON = JSON.toJSON(Screen.getManagerList());

        // System.out.println(managerToJSON);
        System.out.println("Gerentes salvos");

        FileIO.writeFile(Constants.DATA_PATH + "managerdata.json", managerToJSON);

        
        // Salvando a lista de empréstimos:
        String loanToJSON = JSON.toJSON(Screen.getLoansList());

        // System.out.println(loanToJSON);
        System.out.println("Empréstimos salvos");


        FileIO.writeFile(Constants.DATA_PATH + "loandata.json", loanToJSON);

    }


}
