package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.models.Book;
import br.oo.alexandria.library.models.Genre;
import br.oo.alexandria.library.views.AddBookScreen;
import br.oo.alexandria.library.views.Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookCreate implements ActionListener {

    AddBookScreen screen;

    public BookCreate(AddBookScreen screen) {
        this.screen = screen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Genre selectedGenre = (Genre) screen.getGenreBox().getSelectedItem();
        
        Screen.getBookList().add(
            new Book(
                screen.getNameField().getText(),
                screen.getAuthorField().getText(),
                screen.getEditorField().getText(),
                Integer.parseInt(screen.getReleaseYearField().getText()),
                selectedGenre
            )        
        );
        
        screen.getFrame().repaint();
    }

}
