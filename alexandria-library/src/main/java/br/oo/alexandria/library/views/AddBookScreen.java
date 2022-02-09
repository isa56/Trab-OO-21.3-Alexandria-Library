package br.oo.alexandria.library.views;

import br.oo.alexandria.library.controllers.BookCreate;
import br.oo.alexandria.library.util.Constants;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddBookScreen extends Screen {

    private JTextField nameField;
    private JTextField authorField;
    private JTextField releaseYearField;
    private JTextField editorField;
    private JTextField genreField;

    private JButton addBookButton;

    public AddBookScreen() {

        super(Constants.SIGNUP_LABEL);

        this.nameField = new JTextField();
        this.authorField = new JTextField();
        this.releaseYearField = new JTextField();
        this.editorField = new JTextField();
        this.genreField = new JTextField();
        
        this.addBookButton = new JButton(Constants.SIGNUP_LABEL);

        draw();

    }

    private void draw() {

        getFrame().setSize(Constants.WINDOW_DIMENSION);
        getFrame().setVisible(true);

        getMainPanel().setLayout(new BorderLayout());

        JLabel nameLabel = new JLabel(Constants.BOOKS_LABEL);
        getMainPanel().add(nameLabel);
        getMainPanel().add(nameField);

        JLabel authorLabel = new JLabel(Constants.BOOK_AUTHOR_LABEL);
        getMainPanel().add(authorLabel);
        getMainPanel().add(authorField);

        JLabel releaseYearLabel = new JLabel(Constants.BOOK_RELEASEDATE_LABEL);
        getMainPanel().add(releaseYearLabel);
        getMainPanel().add(releaseYearField);

        JLabel editorLabel = new JLabel(Constants.BOOK_EDITOR_LABEL);
        getMainPanel().add(editorLabel);
        getMainPanel().add(editorField);

        JLabel genreLabel = new JLabel(Constants.BOOK_GENRE_LABEL);
        getMainPanel().add(genreLabel);
        getMainPanel().add(genreField);

        this.addBookButton.addActionListener(new BookCreate(this));
        getMainPanel().add(addBookButton);

        getFrame().add(getMainPanel());

        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().repaint();

    }

}
