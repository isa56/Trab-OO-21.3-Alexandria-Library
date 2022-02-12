package br.oo.alexandria.library.views;

import br.oo.alexandria.library.util.Constants;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LoanListingScreen extends Screen {
    
    private JPanel listingPanel;
    private JTable listingTable;
    private DefaultTableModel loansTableModel;

    private int lastIndex;

    public LoanListingScreen() {
        super(Constants.LOAN_LABEL);

        loansTableModel = new DefaultTableModel(Constants.LOANS_LISTING, 0);
        listingTable = new JTable();

        draw();

    }

    private void draw() {

        getFrame().setSize(Constants.WINDOW_DIMENSION);

        getMainPanel().setLayout(new BorderLayout());
        
        this.listingPanel = new JPanel();
        this.listingPanel.setBorder(BorderFactory.createTitledBorder(Constants.LOAN_LABEL));
        this.listingPanel.setPreferredSize(Constants.MENU_DIMENSION);
        
        this.listingPanel.add(new JScrollPane(listingTable));
        
        
        getMainPanel().add(listingPanel);
        
        
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
