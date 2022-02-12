package br.oo.alexandria.library.views;

import br.oo.alexandria.library.controllers.AddBook;
import br.oo.alexandria.library.controllers.BooksListing;
import br.oo.alexandria.library.controllers.LoansListing;
import br.oo.alexandria.library.util.Constants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EmployeeScreen extends Screen {

//  private JButton goBackButton;
    private JPanel buttonsPanel;
    private JButton booksButton;
    private JButton loansButton;
    private JButton addBookButton;

    public EmployeeScreen() {

        super(Constants.SCREEN_USER);

        this.booksButton = new JButton(Constants.BOOKS_LABEL);
        this.loansButton = new JButton(Constants.MYLOAN_LABEL);
        this.addBookButton = new JButton(Constants.ADD_BOOK_LABEL);

        draw();

    }

    private void draw() {

        getFrame().setSize(Constants.WINDOW_DIMENSION);
        getMainPanel().setLayout(new BorderLayout());

        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3, 1));
        buttonsPanel.setPreferredSize(new Dimension(Constants.MENU_WIDTH, 300));

        this.booksButton.addActionListener(new BooksListing(this));
        buttonsPanel.add(booksButton);

        this.loansButton.addActionListener(new LoansListing(this));
        buttonsPanel.add(loansButton);

        this.addBookButton.addActionListener(new AddBook(this));
        buttonsPanel.add(addBookButton);

        getMainPanel().add(buttonsPanel);
        
        getFrame().add(getMainPanel());

        getFrame().setVisible(true);
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
        return loansButton;
    }

    public void setMyLoans(JButton myLoans) {
        this.loansButton = myLoans;
    }

}
