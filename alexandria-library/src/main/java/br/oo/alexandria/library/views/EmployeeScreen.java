package br.oo.alexandria.library.views;

import br.oo.alexandria.library.controllers.AddBook;
import br.oo.alexandria.library.controllers.BooksListing;
import br.oo.alexandria.library.controllers.LoansListing;
import br.oo.alexandria.library.util.Constants;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class EmployeeScreen extends Screen {

    
//  private JButton goBackButton;
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
        getFrame().setVisible(true);

        getMainPanel().setLayout(new BorderLayout());
        
        this.booksButton.addActionListener(new BooksListing(this));
        getMainPanel().add(booksButton);

        this.loansButton.addActionListener(new LoansListing(this));
        getMainPanel().add(loansButton);

        this.addBookButton.addActionListener(new AddBook(this));
        getMainPanel().add(addBookButton);
        
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
