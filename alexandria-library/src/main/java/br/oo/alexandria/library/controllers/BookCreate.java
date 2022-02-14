package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.models.Book;
import br.oo.alexandria.library.views.AddBookScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;

public class BookCreate implements ActionListener {

    AddBookScreen screen;

    public BookCreate(AddBookScreen screen) {
        this.screen = screen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        DefaultListModel<Book> model = (DefaultListModel<Book>) screen.getBookList().getModel();

        model.addElement(
                new Book(
                    screen.getNameField().getText(),
                    screen.getAuthorField().getText(),
                    screen.getEditorField().getText(),
                    Integer.parseInt(screen.getReleaseYearField().getText()),
                    (screen.getGenreField().getText())
                )
        );

        screen.getBookList().setModel(model);
        screen.getFrame().repaint();

    }

}
