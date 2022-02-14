package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.models.Employee;
import br.oo.alexandria.library.models.LibraryUser;
import br.oo.alexandria.library.models.Manager;
import br.oo.alexandria.library.views.SignUpEmployeeScreen;
import br.oo.alexandria.library.views.SignUpManagerScreen;
import br.oo.alexandria.library.views.SignupScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;

public class UserCreate implements ActionListener {

    SignupScreen screen;

    public UserCreate(SignupScreen screen) {
        this.screen = screen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (screen instanceof SignUpManagerScreen) {

            DefaultListModel<Manager> model = new DefaultListModel<>();

            model.addElement(
                    new Manager(
                            screen.getNameField().getText(),
                            screen.getPhoneField().getText(),
                            screen.getEmailField().getText(),
                            screen.getPasswordField().getText()
                    )
            );

            screen.getManagerList().setModel(model);

        } else if (screen instanceof SignUpEmployeeScreen) {

            DefaultListModel<Employee> model = new DefaultListModel<>();

            model.addElement(
                    new Employee(
                            screen.getNameField().getText(),
                            screen.getPhoneField().getText(),
                            screen.getEmailField().getText(),
                            screen.getPasswordField().getText()
                    )
            );

            screen.getEmployeeList().setModel(model);

        } else {

            DefaultListModel<LibraryUser> model = new DefaultListModel<>();

            model.addElement(
                    new LibraryUser(
                            screen.getNameField().getText(),
                            screen.getPhoneField().getText(),
                            screen.getEmailField().getText(),
                            screen.getPasswordField().getText()
                    )
            );

            screen.getLibraryUsersList().setModel(model);

        }

        screen.getFrame().repaint();
    }

}
