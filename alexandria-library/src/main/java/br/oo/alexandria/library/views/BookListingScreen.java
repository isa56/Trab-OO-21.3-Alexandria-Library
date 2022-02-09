package br.oo.alexandria.library.views;

import br.oo.alexandria.library.util.Constants;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookListingScreen extends Screen {

    private JPanel listingPanel;
    private JTable listingTable;
    private DefaultTableModel booksTableModel;

    private int lastIndex;

    public BookListingScreen() {
        super(Constants.BOOKS_LABEL);

        booksTableModel = new DefaultTableModel(Constants.BOOKS_LISTING, 0);
        listingTable = new JTable();

        draw();

    }

    private void draw() {

        getFrame().setSize(Constants.WINDOW_DIMENSION);
        getFrame().setVisible(true);

        getMainPanel().setLayout(new BorderLayout());
        
        this.listingPanel = new JPanel();
        this.listingPanel.setBorder(BorderFactory.createTitledBorder(Constants.BOOKS_LABEL));
        this.listingPanel.setPreferredSize(Constants.MENU_DIMENSION);
        
        this.listingPanel.add(new JScrollPane(listingTable));
        
        
        getMainPanel().add(listingPanel);
        
        
        getFrame().add(getMainPanel());

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

    public DefaultTableModel getBooksTableModel() {
        return booksTableModel;
    }

    public void setBooksTableModel(DefaultTableModel booksTableModel) {
        this.booksTableModel = booksTableModel;
    }

    public int getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

    
    
}
