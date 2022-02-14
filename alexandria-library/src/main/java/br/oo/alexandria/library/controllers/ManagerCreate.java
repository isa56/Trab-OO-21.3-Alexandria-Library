package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.models.LibraryUser;
import br.oo.alexandria.library.models.Manager;
import br.oo.alexandria.library.views.SignupManagerScreen;
import br.oo.alexandria.library.views.Screen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;

public class ManagerCreate implements ActionListener {

    SignupManagerScreen screen;

    public ManagerCreate(SignupManagerScreen screen) {
        this.screen = screen;
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

        screen.getFrame().repaint();
    }

}
