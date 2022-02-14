package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.models.Employee;
import br.oo.alexandria.library.models.LibraryUser;
import br.oo.alexandria.library.views.Screen;
import br.oo.alexandria.library.views.SignupEmployeeScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;

public class EmployeeCreate implements ActionListener {

    SignupEmployeeScreen screen;

    public EmployeeCreate(SignupEmployeeScreen screen) {
        this.screen = screen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        List<Employee> model = Screen.getEmployeeList();

        model.add(
                new Employee(
                        screen.getNameField().getText(),
                        screen.getPhoneField().getText(),
                        screen.getEmailField().getText(),
                        screen.getPasswordField().getText()
                )
        );

        Screen.setEmployeeList(model);

        screen.getFrame().repaint();
    }

}
