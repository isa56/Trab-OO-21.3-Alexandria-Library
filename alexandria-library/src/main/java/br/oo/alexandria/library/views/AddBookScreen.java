package br.oo.alexandria.library.views;

import br.oo.alexandria.library.controllers.BookCreate;
import br.oo.alexandria.library.models.Employee;
import br.oo.alexandria.library.models.Genre;
import br.oo.alexandria.library.models.Manager;
import br.oo.alexandria.library.models.User;
import br.oo.alexandria.library.util.Constants;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddBookScreen extends Screen {

    private User user;
    private JPanel formPanel;
    private JPanel buttonPanel;
    private JTextField nameField;
    private JTextField authorField;
    private JTextField releaseYearField;
    private JTextField editorField;
    private JComboBox<Genre> genreBox;

    private JButton addBookButton;
    private JButton backButton;

    public AddBookScreen(User user) {

        super(Constants.SIGNUP_LABEL);

        this.user = user;
        this.nameField = new JTextField(Constants.FIELD_SIZE);
        this.authorField = new JTextField(Constants.FIELD_SIZE);
        this.releaseYearField = new JTextField(Constants.FIELD_SIZE);
        this.editorField = new JTextField(Constants.FIELD_SIZE);

        DefaultComboBoxModel<Genre> model = new DefaultComboBoxModel<>();

        for (Genre genre : Genre.values()) {
            model.addElement(genre);
        }

        this.genreBox = new JComboBox<>(model);

        this.addBookButton = new JButton(Constants.SIGNUP_LABEL);
        this.backButton = new JButton(Constants.GOBACK_LABEL);

        draw();

    }

    public void draw() {

        getFrame().setSize(Constants.WINDOW_DIMENSION);

        getMainPanel().setLayout(new BorderLayout());

        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 1));
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
        formPanel.add(genreBox);

        this.addBookButton.addActionListener(new BookCreate(this, user));
        buttonPanel.add(addBookButton, BorderLayout.EAST);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);

                if (user instanceof Manager) {
                    new ManagerScreen((Manager) user);
                } else {
                    new EmployeeScreen((Employee) user);
                }
            }
        });
        
        buttonPanel.add(backButton, BorderLayout.WEST);

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

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JTextField getAuthorField() {
        return authorField;
    }

    public void setAuthorField(JTextField authorField) {
        this.authorField = authorField;
    }

    public JTextField getReleaseYearField() {
        return releaseYearField;
    }

    public void setReleaseYearField(JTextField releaseYearField) {
        this.releaseYearField = releaseYearField;
    }

    public JTextField getEditorField() {
        return editorField;
    }

    public void setEditorField(JTextField editorField) {
        this.editorField = editorField;
    }

}
