package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.models.Manager;
import br.oo.alexandria.library.views.SignupManagerScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;

public class ManagerCreate implements ActionListener {

    SignupManagerScreen screen;

    public ManagerCreate(SignupManagerScreen screen) {
        this.screen = screen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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

        screen.getFrame().repaint();
    }

}
