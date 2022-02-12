package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.models.Book;
import br.oo.alexandria.library.models.User;
import br.oo.alexandria.library.util.FileIO;
import br.oo.alexandria.library.util.JSON;
import br.oo.alexandria.library.views.MainScreen;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class WindowEvents implements WindowListener {

    MainScreen screen;

    public WindowEvents(MainScreen screen) {
        this.screen = screen;
    }

    @Override
    public void windowOpened(WindowEvent e) {

        // Ler arquivo de livros:
        try {
            String readBookFile = FileIO.readFile("data/bookdata");
            List<Book> bookList = JSON.toBooks(readBookFile);

            DefaultListModel<Book> bookModel = new DefaultListModel<>();

            for (Book book : bookList) {
                bookModel.addElement(book);
            }

            screen.getBookList().setModel(bookModel);

        } catch (FileNotFoundException ex) {
        }

        // Ler arquivo de usuários:
        try {
            String readUserFile = FileIO.readFile("data/userdata");
            List<User> userList = JSON.toUsers(readUserFile);

            DefaultListModel<User> userModel = new DefaultListModel<>();

            for (User user : userList) {
                userModel.addElement(user);
            }

            screen.getUsersList().setModel(userModel);

        } catch (FileNotFoundException ex) {
        }

//        screen.repaint();
    }

    @Override
    public void windowClosing(WindowEvent e) {

        // Salvando a lists de livros:
        ListModel<Book> bookModel = screen.getBookList().getModel();
        List<Book> books = new ArrayList<>();

        for (int i = 0; i < bookModel.getSize(); i++) {
            books.add(bookModel.getElementAt(i));
        }

        String booksToJSON = JSON.toJSON(books);

        System.out.println(booksToJSON);

        FileIO.writeFile("data/bookdata", booksToJSON);

        // Salvando a lists de usuários:
        ListModel<User> userModel = screen.getUsersList().getModel();
        List<User> users = new ArrayList<>();

        for (int i = 0; i < userModel.getSize(); i++) {
            users.add(userModel.getElementAt(i));
        }

        String userToJSON = JSON.toJSON(users);

        System.out.println(userToJSON);

        FileIO.writeFile("data/userdata", userToJSON);

    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
