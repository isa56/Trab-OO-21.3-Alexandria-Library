package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.models.LibraryUser;
import br.oo.alexandria.library.models.Employee;
import br.oo.alexandria.library.models.Manager;
import br.oo.alexandria.library.views.EmployeeScreen;
import br.oo.alexandria.library.views.LoginScreen;
import br.oo.alexandria.library.views.ManagerScreen;
import br.oo.alexandria.library.views.Screen;
import br.oo.alexandria.library.views.UserScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class UserLogin implements ActionListener {

    LoginScreen screen;

    public UserLogin(LoginScreen screen) {
        this.screen = screen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String email = screen.getEmailField().getText();
        String password = screen.getPasswordField().getText();

        List<LibraryUser> libUserList = Screen.getLibraryUsersList();
        List<Employee> employeeList = Screen.getEmployeeList();
        List<Manager> managerList = Screen.getManagerList();

        for (LibraryUser libUser : libUserList) {
            if (libUser.getEmail().equals(email)) {
                if (libUser.getPassword().equals(password)) {
                    this.screen.getFrame().setVisible(false);
                    new UserScreen(libUser);
                } else {
                    JOptionPane.showMessageDialog(screen.getFrame(), "A senha do usuário está errada!");
                }
            }
        }

        for (Employee employee : employeeList) {
            if (employee.getEmail().equals(email)) {
                if (employee.getPassword().equals(password)) {
                    this.screen.getFrame().setVisible(false);
                    new EmployeeScreen(employee);
                } else {
                    JOptionPane.showMessageDialog(screen.getFrame(), "A senha do funcionário está errada!");
                }
            }
        }

        for (Manager manager : managerList) {
            if (manager.getEmail().equals(email)) {
                if (manager.getPassword().equals(password)) {
                    this.screen.getFrame().setVisible(false);
                    new ManagerScreen(manager);
                } else {
                    JOptionPane.showMessageDialog(screen.getFrame(), "A senha do gerente está errada!");
                }
            }
        }

    }

}
