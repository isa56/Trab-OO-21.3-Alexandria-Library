package br.oo.alexandria.library.views;

import br.oo.alexandria.library.controllers.BookCreate;
import br.oo.alexandria.library.models.Genre;
import br.oo.alexandria.library.util.Constants;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddBookScreen extends Screen {

    private JPanel formPanel;
    private JPanel buttonPanel;
    private JTextField nameField;
    private JTextField authorField;
    private JTextField releaseYearField;
    private JTextField editorField;
    private JComboBox<Genre> genreBox;

    private JButton addBookButton;

    public AddBookScreen() {

        super(Constants.SIGNUP_LABEL);

        this.nameField = new JTextField(Constants.FIELD_SIZE);
        this.authorField = new JTextField(Constants.FIELD_SIZE);
        this.releaseYearField = new JTextField(Constants.FIELD_SIZE);
        this.editorField = new JTextField(Constants.FIELD_SIZE);
        
        DefaultComboBoxModel<Genre> model = new DefaultComboBoxModel<>();
        this.genreBox = new JComboBox<>(model);
        
        this.addBookButton = new JButton(Constants.SIGNUP_LABEL);

        draw();

    }

    private void draw() {

        getFrame().setSize(Constants.WINDOW_DIMENSION);

        getMainPanel().setLayout(new BorderLayout());
        
        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5,1));
        buttonPanel = new JPanel();

        JLabel nameLabel = new JLabel(Constants.BOOKS_LABEL);
        formPanel.add(nameLabel);
        formPanel.add(nameField);

        JLabel authorLabel = new JLabel(Constants.BOOK_AUTHOR_LABEL);
        formPanel.add(authorLabel);
        formPanel.add(authorField);

        JLabel releaseYearLabel = new JLabel(Constants.BOOK_RELEASEDATE_LABEL);
        formPanel.add(releaseYearLabel);
        formPanel.add(releaseYearField);

        JLabel editorLabel = new JLabel(Constants.BOOK_EDITOR_LABEL);
        formPanel.add(editorLabel);
        formPanel.add(editorField);

        JLabel genreLabel = new JLabel(Constants.BOOK_GENRE_LABEL);
        formPanel.add(genreLabel);
        formPanel.add(genreField);

        this.addBookButton.addActionListener(new BookCreate(this));
        buttonPanel.add(addBookButton);

        getMainPanel().add(formPanel, BorderLayout.CENTER);
        getMainPanel().add(buttonPanel, BorderLayout.SOUTH);
        
        getFrame().add(getMainPanel());

        getFrame().setVisible(true);

        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().repaint();

    }

    public JComboBox<Genre> getGenreBox() {
        return genreBox;
    }

    public void setGenreBox(JComboBox<Genre> genreBox) {
        this.genreBox = genreBox;
    }


}
