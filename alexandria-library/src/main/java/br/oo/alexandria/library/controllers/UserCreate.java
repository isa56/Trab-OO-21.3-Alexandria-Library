package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.models.LibraryUser;
import br.oo.alexandria.library.views.SignupUserScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;

public class UserCreate implements ActionListener {

    SignupUserScreen screen;

    public UserCreate(SignupUserScreen screen) {
        this.screen = screen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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

        screen.getFrame().repaint();
    }

}
