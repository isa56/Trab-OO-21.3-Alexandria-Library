package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.models.Book;
import br.oo.alexandria.library.models.Employee;
import br.oo.alexandria.library.models.Genre;
import br.oo.alexandria.library.models.Manager;
import br.oo.alexandria.library.models.User;
import br.oo.alexandria.library.views.AddBookScreen;
import br.oo.alexandria.library.views.EmployeeScreen;
import br.oo.alexandria.library.views.ManagerScreen;
import br.oo.alexandria.library.views.Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class BookCreate implements ActionListener {

    AddBookScreen screen;
    User user;

    public BookCreate(AddBookScreen screen, User user) {
        this.screen = screen;
        this.user = user;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Genre selectedGenre = (Genre) screen.getGenreBox().getSelectedItem();

        List<Book> bookList = Screen.getBookList();

        try {

            bookList.add(
                    new Book(
                            screen.getNameField().getText(),
                            screen.getAuthorField().getText(),
                            screen.getEditorField().getText(),
                            Integer.parseInt(screen.getReleaseYearField().getText()),
                            selectedGenre
                    )
            );

            Screen.setBookList(bookList);

        } catch (NumberFormatException excep) {
            JOptionPane.showMessageDialog(screen.getFrame(), "Digite um ano válido!");

        }

        WindowEvents.saveFile();
        screen.getFrame().setVisible(false);
        if (user instanceof Manager) {
            new ManagerScreen((Manager) user);
        } else {
            new EmployeeScreen((Employee) user);
        }

        screen.getFrame().repaint();
    }

}
