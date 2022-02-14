package br.oo.alexandria.library.views;

import br.oo.alexandria.library.controllers.BookDelete;
import br.oo.alexandria.library.models.User;
import br.oo.alexandria.library.util.Constants;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class BookListingScreen extends Screen {
    
//    private User user;
    private JPanel listingPanel;
    private JTable listingTable;
    private JButton deleteBookButton;
    private DefaultTableModel booksTableModel;

    private int lastIndex;

    public BookListingScreen(/*User user*/) {

        super(Constants.BOOKS_LABEL);
        
//        this.user = user;

        deleteBookButton = new JButton(Constants.DELETE_LABEL);
        booksTableModel = new DefaultTableModel(Constants.BOOKS_LISTING, 0);
        listingTable = new JTable(booksTableModel);

        draw();

    }

    private void draw() {

        getFrame().setSize(Constants.WINDOW_DIMENSION);

        getMainPanel().setLayout(new BorderLayout());
        
        this.listingPanel = new JPanel();
        this.listingPanel.setBorder(BorderFactory.createTitledBorder(Constants.BOOKS_LABEL));
        this.listingPanel.setPreferredSize(Constants.MENU_DIMENSION);
        
        this.listingPanel.add(new JScrollPane(listingTable));
        
        deleteBookButton.addActionListener(new BookDelete(this));
        getMainPanel().add(deleteBookButton);
        
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
