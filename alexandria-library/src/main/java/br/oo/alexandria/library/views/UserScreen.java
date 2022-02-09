package br.oo.alexandria.library.views;

import br.oo.alexandria.library.controllers.BooksListing;
import br.oo.alexandria.library.controllers.LoansListing;
import br.oo.alexandria.library.util.Constants;
import java.awt.BorderLayout;
import javax.swing.*;

public class UserScreen extends Screen {

//  private JButton goBackButton;
    private JButton booksButton;
    private JButton myLoansButton;

    public UserScreen() {

        super(Constants.SCREEN_USER);

        this.booksButton = new JButton(Constants.BOOKS_LABEL);
        this.myLoansButton = new JButton(Constants.MYLOAN_LABEL);

        draw();

    }

    private void draw() {

        getFrame().setSize(Constants.WINDOW_DIMENSION);
        getFrame().setVisible(true);

        getMainPanel().setLayout(new BorderLayout());

        this.booksButton.addActionListener(new BooksListing(this));
        getMainPanel().add(booksButton);

        this.myLoansButton.addActionListener(new LoansListing(this));
        getMainPanel().add(myLoansButton);

        getFrame().add(getMainPanel());

        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().repaint();

    }

    /*
    public JButton getGoBackButton() {
        return goBackButton;
    }

    public void setGoBackButton(JButton goBackButton) {
        this.goBackButton = goBackButton;
    }
     */
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
