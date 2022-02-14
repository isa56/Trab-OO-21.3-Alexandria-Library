package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.models.Book;
import br.oo.alexandria.library.util.Constants;
import br.oo.alexandria.library.util.FileIO;
import br.oo.alexandria.library.util.JSON;
import br.oo.alexandria.library.views.Screen;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

public class WindowEvents implements WindowListener {

    Screen screen;

    public WindowEvents(Screen screen) {
        this.screen = screen;
    }

    @Override
    public void windowOpened(WindowEvent e) {

        // Ler arquivo de livros:
        try {
            // Ler arquivo de livros:
            String readBookFile = FileIO.readFile(Constants.DATA_PATH + "bookdata.json");
            Screen.setBookList(JSON.toBooks(readBookFile));

            // Ler arquivo de usuários da biblioteca:
            String readUserFile = FileIO.readFile(Constants.DATA_PATH + "userdata.json");
            Screen.setLibraryUsersList(JSON.toLibraryUsers(readUserFile));

            // Ler arquivo de funcionários:
            String readEmployeeFile = FileIO.readFile(Constants.DATA_PATH + "employeedata.json");
            Screen.setEmployeeList(JSON.toEmployees(readEmployeeFile));

            // Ler arquivo de administradores:
            String readManagerFile = FileIO.readFile(Constants.DATA_PATH + "managerdata.json");
            Screen.setManagerList(JSON.toManagers(readManagerFile));

            // Ler arquivo de empréstimos:
            String readLoanFile = FileIO.readFile(Constants.DATA_PATH + "loandata.json");
            Screen.setLoansList(JSON.toLoans(readLoanFile));

            this.screen.getFrame().repaint();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this.screen.getFrame(), "Não foi possível abrir os arquivos dos dados");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this.screen.getFrame(), "Ocorreu um erro na leitura dos dados");
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            // Salvando a lista de livros:
            String booksToJSON = JSON.toJSON(Screen.getBookList());
            System.out.println(booksToJSON);
            FileIO.writeFile(Constants.DATA_PATH + "bookdata.json", booksToJSON);

            
            // Salvando a lista de usuários:
            String libUserToJSON = JSON.toJSON(Screen.getLibraryUsersList());
            System.out.println(libUserToJSON);
            FileIO.writeFile(Constants.DATA_PATH + "userdata.json", libUserToJSON);
            

            // Salvando a lista de funcionários:
            String employeeToJSON = JSON.toJSON(Screen.getEmployeeList());
            System.out.println(employeeToJSON);
            FileIO.writeFile(Constants.DATA_PATH + "employeedata.json", employeeToJSON);

            
            // Salvando a lista de gerentes:
            String managerToJSON = JSON.toJSON(Screen.getManagerList());
            System.out.println(managerToJSON);
            FileIO.writeFile(Constants.DATA_PATH + "managerdata.json", managerToJSON);

            
            // Salvando a lista de empréstimos:
            String loanToJSON = JSON.toJSON(Screen.getLoansList());
            System.out.println(loanToJSON);
            FileIO.writeFile(Constants.DATA_PATH + "loandata.json", loanToJSON);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this.screen.getFrame(), "Ocorreu um erro ao salvar os dados");
        }
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
                try {
            // Salvando a lista de livros:
            String booksToJSON = JSON.toJSON(Screen.getBookList());
            System.out.println(booksToJSON);
            FileIO.writeFile(Constants.DATA_PATH + "bookdata.json", booksToJSON);

            
            // Salvando a lista de usuários:
            String libUserToJSON = JSON.toJSON(Screen.getLibraryUsersList());
            System.out.println(libUserToJSON);
            FileIO.writeFile(Constants.DATA_PATH + "userdata.json", libUserToJSON);
            

            // Salvando a lista de funcionários:
            String employeeToJSON = JSON.toJSON(Screen.getEmployeeList());
            System.out.println(employeeToJSON);
            FileIO.writeFile(Constants.DATA_PATH + "employeedata.json", employeeToJSON);

            
            // Salvando a lista de gerentes:
            String managerToJSON = JSON.toJSON(Screen.getManagerList());
            System.out.println(managerToJSON);
            FileIO.writeFile(Constants.DATA_PATH + "managerdata.json", managerToJSON);

            
            // Salvando a lista de empréstimos:
            String loanToJSON = JSON.toJSON(Screen.getLoansList());
            System.out.println(loanToJSON);
            FileIO.writeFile(Constants.DATA_PATH + "loandata.json", loanToJSON);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao salvar os dados");
        }

    }


}
