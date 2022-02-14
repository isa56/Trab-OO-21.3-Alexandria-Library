package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.models.LibraryUser;
import br.oo.alexandria.library.views.LoginScreen;
import br.oo.alexandria.library.views.SignupUserScreen;
import br.oo.alexandria.library.views.Screen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

public class UserCreate implements ActionListener {

    SignupUserScreen screen;

    public UserCreate(SignupUserScreen screen) {
        this.screen = screen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        List<LibraryUser> model = Screen.getLibraryUsersList();
        
        model.add(
                new LibraryUser(
                        screen.getNameField().getText(),
                        screen.getPhoneField().getText(),
                        screen.getEmailField().getText(),
                        screen.getPasswordField().getText()
                )
        );

        Screen.setLibraryUsersList(model);

        screen.getFrame().setVisible(false);
        new LoginScreen();
        
        screen.getFrame().repaint();
    }

}
