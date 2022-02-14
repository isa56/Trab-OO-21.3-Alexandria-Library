package br.oo.alexandria.library.views;

import br.oo.alexandria.library.controllers.BookReturn;
import br.oo.alexandria.library.models.Book;
import br.oo.alexandria.library.models.Loan;
import br.oo.alexandria.library.util.Constants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConfirmBookReturnScreen extends Screen {
    
    private Book bookToReturn;
    private Loan loanToFinish;
    private JPanel textPanel;
    private JPanel buttonsPanel;
    private JButton yesButton;
    private JButton noButton;
    
    public ConfirmBookReturnScreen(Book bookReturned, Loan loanToFinish) {
        
        super("Devolver Livro");
        
        this.bookToReturn = bookReturned;
        this.loanToFinish = loanToFinish;
        
        yesButton = new JButton(Constants.YES_LABEL);
        noButton = new JButton(Constants.NO_LABEL);
        
        draw();
        
    }
    
    private void draw() {
        
        getFrame().setSize(Constants.WINDOW_DIMENSION);
        
        getMainPanel().setLayout(new BorderLayout());
        
        textPanel = new JPanel();
        textPanel.setPreferredSize(new Dimension(Constants.MENU_WIDTH, 100));
        textPanel.add(new JLabel("Deseja devolver o livro " + bookToReturn.getBookName() + "?"));
        
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(0, 2));
        buttonsPanel.setPreferredSize(new Dimension(Constants.MENU_WIDTH, 200));
        
        yesButton.addActionListener(new BookReturn(this, this.loanToFinish));
        
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);
                new BookListingScreen();
            }
        });
        
        buttonsPanel.add(yesButton);
        buttonsPanel.add(noButton);
        
        getMainPanel().add(textPanel, BorderLayout.NORTH);
        getMainPanel().add(buttonsPanel, BorderLayout.CENTER);
        
        getFrame().add(getMainPanel());
        
        getFrame().setVisible(true);
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().repaint();
        
    }
    
}
