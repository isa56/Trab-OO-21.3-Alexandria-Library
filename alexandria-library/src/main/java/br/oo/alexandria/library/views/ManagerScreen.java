package br.oo.alexandria.library.views;

import br.oo.alexandria.library.models.Manager;
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

public class ManagerScreen extends Screen {

    private Manager manager;

    private JPanel buttonsPanel;
    private JButton booksButton;
    private JButton loansButton;
    private JButton addBookButton;
    private JButton addManagerButton;
    private JButton addEmployeeButton;
    private JLabel message;

    public ManagerScreen(Manager manager) {
        super(Constants.MANAGER_LABEL);

        this.manager = manager;

        this.message = new JLabel(Constants.MESSAGE + manager.getName());

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

        getMainPanel().add(message, BorderLayout.NORTH);

        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3, 1));
        buttonsPanel.setPreferredSize(new Dimension(Constants.MENU_WIDTH, 300));

        this.booksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);
                new BookListingScreen(manager);
            }
        });
        buttonsPanel.add(booksButton);

        this.loansButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);
                new LoanListingScreen(manager);
            }
        });
        buttonsPanel.add(loansButton);

        this.addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);
                new AddBookScreen(manager);
            }
        }
        );
        buttonsPanel.add(addBookButton);

        this.addManagerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);
                new SignupManagerScreen(manager);
            }
        });
        buttonsPanel.add(addManagerButton);

        this.addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);
                new SignupEmployeeScreen(manager);
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
