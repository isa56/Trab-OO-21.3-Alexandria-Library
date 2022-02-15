package br.oo.alexandria.library.views;

import br.oo.alexandria.library.models.LibraryUser;
import br.oo.alexandria.library.models.Loan;
import br.oo.alexandria.library.models.User;
import br.oo.alexandria.library.util.Constants;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UsersLoansScreen extends Screen {

    private User user;
    private List<Loan> myLoansList;
    private JPanel buttonsPanel;
    private JPanel listingPanel;
    private JTable listingTable;
    private DefaultTableModel loansTableModel;
    private JButton backButton;

    private int lastIndex;

    public UsersLoansScreen(User user) {
        super(Constants.LOAN_LABEL);

        this.user = user;

        buttonsPanel = new JPanel();
        backButton = new JButton(Constants.GOBACK_LABEL);

        myLoansList = findUserLoans();

        loansTableModel = new DefaultTableModel(Constants.LOANS_LISTING, 0);

        for (Loan loan : myLoansList) {
            Object[] tableRow = {loan.getBook().getBookName(), loan.getLentDate(), loan.getUser().getName()};
            loansTableModel.addRow(tableRow);
        }

        listingTable = new JTable(loansTableModel);

        draw();

    }

    private List<Loan> findUserLoans() {

        List<Loan> myLoanList = new ArrayList<>();
        List<Loan> loanList = Screen.getLoansList();

        for (Loan loan : loanList) {
            if (loan.getUser().getEmail().equals(user.getEmail())) {
                myLoanList.add(loan);
            }
        }

        return myLoanList;

    }

    public void draw() {

        getFrame().setSize(Constants.WINDOW_DIMENSION);

        getMainPanel().setLayout(new BorderLayout());

        this.listingPanel = new JPanel();
        this.listingPanel.setBorder(BorderFactory.createTitledBorder(Constants.LOAN_LABEL));
        this.listingPanel.setPreferredSize(Constants.MENU_DIMENSION);

        this.listingPanel.add(new JScrollPane(listingTable));

        getMainPanel().add(listingPanel, BorderLayout.CENTER);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);
                new UserScreen((LibraryUser) user);
            }
        });

        buttonsPanel.add(backButton, BorderLayout.WEST);

        getMainPanel().add(buttonsPanel, BorderLayout.SOUTH);
        
        getFrame().add(getMainPanel());

        getFrame().setVisible(true);

        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().repaint();

    }

    public JPanel getListingPanel() {
        return listingPanel;
    }

    public void setListingPanel(JPanel listingPanel) {
        this.listingPanel = listingPanel;
    }

    public JTable getListingTable() {
        return listingTable;
    }

    public void setListingTable(JTable listingTable) {
        this.listingTable = listingTable;
    }

    public DefaultTableModel getLoansTableModel() {
        return loansTableModel;
    }

    public void setLoansTableModel(DefaultTableModel loansTableModel) {
        this.loansTableModel = loansTableModel;
    }

    public int getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

}
