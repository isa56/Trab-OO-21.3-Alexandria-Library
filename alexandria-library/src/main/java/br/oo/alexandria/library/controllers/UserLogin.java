/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.views.LoginScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author isadora
 */
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
