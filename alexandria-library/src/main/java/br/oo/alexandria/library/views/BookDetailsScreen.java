package br.oo.alexandria.library.views;

/**
 * *****************************************************************************
 * ESTA TELA FOI FEITA POR NÉLIO, QUE, POR MOTIVOS PESSOAIS, NÃO PÔDE PARTICIPAR
 * ATIVAMENTE DESTA PARTE DO TRABALHO
 * *****************************************************************************
 */
import br.oo.alexandria.library.controllers.LoanCreate;
import br.oo.alexandria.library.models.Book;
import br.oo.alexandria.library.models.User;
import br.oo.alexandria.library.util.Constants;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BookDetailsScreen extends Screen {

    private User user;
    private Book book;
    private JPanel infoPanel;
    private JPanel buttonPanel;
    private JButton backButton;
    private JButton loanButton;

    private int lastIndex;

    public BookDetailsScreen(User user, Book book) {

        super(book.getBookName());

        this.user = user;
        this.book = book;
        this.lastIndex = 0;

        infoPanel = new JPanel();
        buttonPanel = new JPanel();
        backButton = new JButton(Constants.GOBACK_LABEL);
        loanButton = new JButton(Constants.GETLOAN_LABEL);

        draw();
    }

    public int getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

    private void draw() {

        getFrame().setSize(Constants.WINDOW_DIMENSION);

        getMainPanel().setLayout(new BorderLayout());

        infoPanel.add(new JLabel(Constants.BOOK_LABEL + ": " + book.getBookName()));

        infoPanel.add(new JLabel(Constants.BOOK_AUTHOR_LABEL + ": " + book.getBookAuthor()));

        infoPanel.add(new JLabel(Constants.BOOK_RELEASEDATE_LABEL + ": " + Integer.toString(book.getReleaseYear())));

        infoPanel.add(new JLabel(Constants.BOOK_EDITOR_LABEL + ": " + book.getEditorName()));

        infoPanel.add(new JLabel(Constants.BOOK_GENRE_LABEL + ": " + book.getBookGenre().name()));

        String isAvailable;

        if (book.isIsAvailable()) {
            isAvailable = Constants.YES_LABEL;
        } else {
            isAvailable = Constants.NO_LABEL;
        }

        infoPanel.add(new JLabel(Constants.BOOK_AVAILABILITY_LABEL + ": " + isAvailable));

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setVisible(false);
                new BookListingScreen(user);
            }
        });

        loanButton.addActionListener(new LoanCreate(this, book, user));

        buttonPanel.add(backButton, BorderLayout.EAST);
        buttonPanel.add(loanButton, BorderLayout.WEST);

        getMainPanel().add(infoPanel, BorderLayout.CENTER);
        getMainPanel().add(buttonPanel, BorderLayout.SOUTH);

        getFrame().add(getMainPanel());

        getFrame().setVisible(true);
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().repaint();

    }
}
