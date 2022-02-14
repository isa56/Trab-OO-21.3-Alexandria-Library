package br.oo.alexandria.library.views;

import br.oo.alexandria.library.controllers.BookDelete;
import br.oo.alexandria.library.models.Book;
import br.oo.alexandria.library.models.Employee;
import br.oo.alexandria.library.models.LibraryUser;
import br.oo.alexandria.library.models.Manager;
import br.oo.alexandria.library.models.User;
import br.oo.alexandria.library.util.Constants;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class BookListingScreen extends Screen {

    private User user;
    private JPanel listingPanel;
    private JPanel buttonsPanel;
    private JTable listingTable;
    private JButton deleteBookButton;
    private JButton bookListingButton;
    private JButton backButton;
    private DefaultTableModel booksTableModel;

    private int lastIndex;

    public BookListingScreen(User user) {

        super(Constants.BOOKS_LABEL);

        this.user = user;

        buttonsPanel = new JPanel();
        deleteBookButton = new JButton(Constants.DELETE_LABEL);
        bookListingButton = new JButton(Constants.SEE_BOOKS_LABEL);
        booksTableModel = new DefaultTableModel(Constants.BOOKS_LISTING, 0);
        backButton = new JButton(Constants.GOBACK_LABEL);

        for (Book book : Screen.getBookList()) {
            Object[] tableRow = {book.getBookName(), book.getBookAuthor()};
            booksTableModel.addRow(tableRow);
        }

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

        getMainPanel().add(this.listingPanel);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);
                
                if(user instanceof Manager)
                    new ManagerScreen((Manager) user);
                else if (user instanceof Employee)
                    new EmployeeScreen((Employee) user);
                else
                    new UserScreen((LibraryUser) user);

            }
        });
        
        buttonsPanel.add(backButton, BorderLayout.WEST);

        if (!(user instanceof LibraryUser)) {
            deleteBookButton.addActionListener(new BookDelete(this));
            buttonsPanel.add(deleteBookButton, BorderLayout.WEST);
        }

        bookListingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);
                new BookDetailsScreen(
                        user,
                        Screen.getBookList().get(listingTable.getSelectedRow())
                );
            }
        });

        buttonsPanel.add(bookListingButton, BorderLayout.EAST);

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
