package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.views.LoginScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLogin implements ActionListener {

    LoginScreen screen;

    public UserLogin(LoginScreen screen) {
        this.screen = screen;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
