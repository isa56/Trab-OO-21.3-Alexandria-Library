package br.oo.alexandria.library.views;

import br.oo.alexandria.library.models.Employee;
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

public class EmployeeScreen extends Screen {

//  private JButton goBackButton;
    private Employee employee;
    private JPanel buttonsPanel;
    private JButton booksButton;
    private JButton loansButton;
    private JButton addBookButton;
    private JLabel message;

    public EmployeeScreen(Employee employee) {

        super(Constants.SCREEN_USER);

        this.employee = employee;

        this.message = new JLabel(Constants.MESSAGE + employee.getName());

        this.booksButton = new JButton(Constants.BOOKS_LABEL);
        this.loansButton = new JButton(Constants.LOAN_LABEL);
        this.addBookButton = new JButton(Constants.ADD_BOOK_LABEL);

        draw();

    }

    public void draw() {

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
                new BookListingScreen(employee);
            }
        });
        buttonsPanel.add(booksButton);

        this.loansButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);
                new LoanListingScreen(employee);
            }
        });
        buttonsPanel.add(loansButton);

        this.addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);
                new AddBookScreen(employee);
            }
        }
        );
        buttonsPanel.add(addBookButton);

        getMainPanel().add(buttonsPanel);

        getFrame().add(getMainPanel());

        getFrame().setVisible(true);
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().repaint();

    }

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
