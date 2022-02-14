package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.models.Book;
import br.oo.alexandria.library.views.BookListingScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;

public class BookDelete implements ActionListener {

    BookListingScreen screen;

    public BookDelete(BookListingScreen screen) {
        this.screen = screen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int selectedBookIndex = screen.getBookList().getSelectedIndex();

        DefaultListModel<Book> model = (DefaultListModel<Book>) screen.getBookList().getModel();

        try {

            model.remove(selectedBookIndex);
            screen.getBookList().remove(selectedBookIndex);

            screen.getFrame().repaint();

        } catch (Exception excep) {}

    }

}
