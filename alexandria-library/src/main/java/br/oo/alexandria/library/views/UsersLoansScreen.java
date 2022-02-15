package br.oo.alexandria.library.views;

import br.oo.alexandria.library.controllers.BookReturn;
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
    private JButton returnButton;

    private int lastIndex;

    public UsersLoansScreen(User user) {
        super(Constants.LOAN_LABEL);

        this.user = user;

        buttonsPanel = new JPanel();
        backButton = new JButton(Constants.GOBACK_LABEL);
        returnButton = new JButton(Constants.RETURN_LABEL);

        myLoansList = findUserLoans();

        loansTableModel = new DefaultTableModel(Constants.LOANS_LISTING, 0);

        for (Loan loan : myLoansList) {
            
            String available;
            
            if(loan.isLoanFinished())
                available = Constants.NO_LABEL;
            else
                available = Constants.YES_LABEL;
            
            Object[] tableRow = {
                loan.getBook().getBookName(), 
                loan.getLentDate(), 
                loan.getUser().getName(), 
                available
            };
            
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
        
        returnButton.addActionListener(new BookReturn(this));

        buttonsPanel.add(backButton, BorderLayout.WEST);
        buttonsPanel.add(returnButton, BorderLayout.EAST);

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Loan> getMyLoansList() {
        return myLoansList;
    }

    public void setMyLoansList(List<Loan> myLoansList) {
        this.myLoansList = myLoansList;
    }

    public JPanel getButtonsPanel() {
        return buttonsPanel;
    }

    public void setButtonsPanel(JPanel buttonsPanel) {
        this.buttonsPanel = buttonsPanel;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JButton getReturnButton() {
        return returnButton;
    }

    public void setReturnButton(JButton returnButton) {
        this.returnButton = returnButton;
    }

}
