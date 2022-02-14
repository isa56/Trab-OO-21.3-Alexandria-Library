package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.models.Employee;
import br.oo.alexandria.library.models.Manager;
import br.oo.alexandria.library.models.User;
import br.oo.alexandria.library.views.EmployeeScreen;
import br.oo.alexandria.library.views.ManagerScreen;
import br.oo.alexandria.library.views.SignupManagerScreen;
import br.oo.alexandria.library.views.Screen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ManagerCreate implements ActionListener {

    SignupManagerScreen screen;
    User user;
    
    public ManagerCreate(SignupManagerScreen screen, User user) {
        this.screen = screen;
        this.user = user;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        List<Manager> model = Screen.getManagerList();

        model.add(
                new Manager(
                        screen.getNameField().getText(),
                        screen.getPhoneField().getText(),
                        screen.getEmailField().getText(),
                        screen.getPasswordField().getText()
                )
        );

        Screen.setManagerList(model);

        screen.getFrame().setVisible(false);
        WindowEvents.saveFile();
        if (user instanceof Manager) {
            new ManagerScreen((Manager) user);
        } else {
            new EmployeeScreen((Employee) user);
        }

        screen.getFrame().repaint();
    }

}
