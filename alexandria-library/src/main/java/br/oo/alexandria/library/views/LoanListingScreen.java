package br.oo.alexandria.library.views;

import br.oo.alexandria.library.models.Employee;
import br.oo.alexandria.library.models.Loan;
import br.oo.alexandria.library.models.Manager;
import br.oo.alexandria.library.models.User;
import br.oo.alexandria.library.util.Constants;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LoanListingScreen extends Screen {

    private User user;
    private JPanel listingPanel;
    private JTable listingTable;
    private JPanel buttonsPanel;
    private JButton backButton;
    private DefaultTableModel loansTableModel;

    private int lastIndex;

    public LoanListingScreen(User user) {
        super(Constants.LOAN_LABEL);

        this.user = user;
        loansTableModel = new DefaultTableModel(Constants.LOANS_LISTING, 0);

        List<Loan> loanList = Screen.getLoansList();

        for (Loan loan : loanList) {

            String available;

            if (loan.isLoanFinished()) {
                available = Constants.NO_LABEL;
            } else {
                available = Constants.YES_LABEL;
            }

            Object[] tableRow = {loan.getBook().getBookName(), loan.getLentDate(), loan.getUser().getName(), available};
            loansTableModel.addRow(tableRow);
        }

        System.out.println(loansTableModel);

        listingTable = new JTable(loansTableModel);

        buttonsPanel = new JPanel();
        backButton = new JButton(Constants.GOBACK_LABEL);

        draw();

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
                if (user instanceof Manager) {
                    new ManagerScreen((Manager) user);
                } else if (user instanceof Employee) {
                    new EmployeeScreen((Employee) user);
                }
            }
        });

        buttonsPanel.add(backButton, BorderLayout.CENTER);

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
