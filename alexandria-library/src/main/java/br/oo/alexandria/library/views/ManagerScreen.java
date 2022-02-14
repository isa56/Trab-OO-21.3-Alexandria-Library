package br.oo.alexandria.library.views;

import br.oo.alexandria.library.util.Constants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ManagerScreen extends Screen {

    private JPanel buttonsPanel;
    
    private JButton booksButton;
    private JButton loansButton;
    private JButton addBookButton;
    private JButton addManagerButton;
    private JButton addEmployeeButton;

    public ManagerScreen() {
        super(Constants.MANAGER_LABEL);

        this.booksButton = new JButton(Constants.BOOKS_LABEL);
        this.loansButton = new JButton(Constants.MYLOAN_LABEL);
        this.addBookButton = new JButton(Constants.ADD_BOOK_LABEL);
        this.addManagerButton = new JButton(Constants.ADD_MANAGER_LABEL);
        this.addEmployeeButton = new JButton(Constants.ADD_EMPLOYEE_LABEL);

        draw();
        
    }
    
        private void draw() {

        getFrame().setSize(Constants.WINDOW_DIMENSION);
        getMainPanel().setLayout(new BorderLayout());

        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3, 1));
        buttonsPanel.setPreferredSize(new Dimension(Constants.MENU_WIDTH, 300));

        this.booksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);
                new BookListingScreen();
            }
        });
        buttonsPanel.add(booksButton);

        this.loansButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);
                new LoanListingScreen();
            }
        });
        buttonsPanel.add(loansButton);

        this.addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);
                new AddBookScreen();
            }
        }
        );
        buttonsPanel.add(addBookButton);

        this.addManagerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);
                new SignUpManagerScreen();
            }
        });
        buttonsPanel.add(addManagerButton);

        this.addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);
                new SignUpEmployeeScreen();
            }
        });
        buttonsPanel.add(addEmployeeButton);
        
        
        getMainPanel().add(buttonsPanel);

        getFrame().add(getMainPanel());

        getFrame().setVisible(true);
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().repaint();

    }


}
