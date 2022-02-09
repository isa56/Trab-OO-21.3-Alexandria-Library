package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.views.Screen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BooksListing implements ActionListener {

    Screen screen;
    
    public BooksListing(Screen screen) {
        this.screen = screen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
