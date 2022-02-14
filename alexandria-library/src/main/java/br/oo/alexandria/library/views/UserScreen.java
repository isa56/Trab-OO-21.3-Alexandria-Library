package br.oo.alexandria.library.views;

import br.oo.alexandria.library.models.LibraryUser;
import br.oo.alexandria.library.models.User;
import br.oo.alexandria.library.util.Constants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UserScreen extends Screen {

    private LibraryUser user;
    private JPanel buttonsPanel;
    private JButton booksButton;
    private JButton myLoansButton;

    public UserScreen(LibraryUser user) {

        super(Constants.SCREEN_USER);
        
        this.user = user;

        this.booksButton = new JButton(Constants.BOOKS_LABEL);
        this.myLoansButton = new JButton(Constants.MYLOAN_LABEL);

        getFrame().setSize(Constants.WINDOW_DIMENSION);

        draw();

        getFrame().add(getMainPanel());
        getFrame().setVisible(true);

        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().repaint();
    }

    private void draw() {

        buttonsPanel = new JPanel();

        buttonsPanel.setLayout(new GridLayout(2, 1));
        
        buttonsPanel.setPreferredSize(new Dimension(Constants.MENU_WIDTH, 300));

        this.booksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);
                new BookListingScreen();
            }
        });
        buttonsPanel.add(booksButton);

        this.myLoansButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);
                new UsersLoansScreen(user);
            }
        });
        buttonsPanel.add(myLoansButton);

        getMainPanel().add(buttonsPanel, BorderLayout.CENTER);
        
    }

    public JButton getBooksButton() {
        return booksButton;
    }

    public void setBooksButton(JButton booksButton) {
        this.booksButton = booksButton;
    }

    public JButton getMyLoans() {
        return myLoansButton;
    }

    public void setMyLoans(JButton myLoans) {
        this.myLoansButton = myLoans;
    }

}
