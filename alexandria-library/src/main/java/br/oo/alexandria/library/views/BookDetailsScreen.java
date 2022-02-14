package br.oo.alexandria.library.views;

/*******************************************************************************
ESTA TELA FOI FEITA POR NÉLIO, QUE, POR MOTIVOS PESSOAIS, NÃO PÔDE PARTICIPAR 
ATIVAMENTE DESTA PARTE DO TRABALHO
*******************************************************************************/

import br.oo.alexandria.library.models.Book;
import br.oo.alexandria.library.models.LibraryUser;
import br.oo.alexandria.library.util.Constants;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class BookDetailsScreen extends Screen {

    private Book book;
    private JPanel infoPanel;
    private JPanel buttonPanel;
    private JPanel titlePanel;
    private JButton backButton;
    private JButton loanButton;
    private int lastIndex;

    public BookDetailsScreen(Book book) {
        super(Constants.BOOK_LABEL);

        this.book = book;
        this.lastIndex = 0;

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

        infoPanel = new JPanel();
        titlePanel = new JPanel();
        buttonPanel = new JPanel();

        JLabel nameLabel = new JLabel(book.getBookName());
        titlePanel.add(nameLabel);

        JLabel authorLabel = new JLabel(book.getBookAuthor());
        infoPanel.add(authorLabel);

        JLabel releaseYear = new JLabel(Integer.toString(book.getReleaseYear()));
        infoPanel.add(releaseYear);

        JLabel editor = new JLabel(book.getEditorName());
        infoPanel.add(editor);

        JLabel genre = new JLabel(book.getBookGenre().name());
        infoPanel.add(genre);

        String sAvaiable;
        if (book.isIsAvailable()) {
            sAvaiable = Constants.YES_LABEL;
        } else {
            sAvaiable = Constants.NO_LABEL;
        }
        JLabel avaiable = new JLabel(sAvaiable);
        infoPanel.add(avaiable);
        DefaultListModel<Book> model = new DefaultListModel<>();

    }
}