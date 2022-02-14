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
import javax.swing.JTextField;
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
        super(book.getBookName());

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
        
        JLabel nameLabel = new JLabel(Constants.BOOK_LABEL + ": " + book.getBookName());
        titlePanel.add(nameLabel);

        JLabel authorLabel = new JLabel(Constants.BOOK_AUTHOR_LABEL + ": " + book.getBookAuthor());
        infoPanel.add(authorLabel);

        JLabel releaseYear = new JLabel(Constants.BOOK_RELEASEDATE_LABEL + ": " + Integer.toString(book.getReleaseYear()));
        infoPanel.add(releaseYear);

        JLabel editor = new JLabel(Constants.BOOK_EDITOR_LABEL + ": " + book.getEditorName());
        infoPanel.add(editor);

        JLabel genre = new JLabel(Constants.BOOK_GENRE_LABEL + ": " + book.getBookGenre().name());
        infoPanel.add(genre);

        String sAvaiable;
        if (book.isIsAvailable()) {
            sAvaiable = Constants.YES_LABEL;
        } else {
            sAvaiable = Constants.NO_LABEL;
        }
        JLabel avaiable = new JLabel(sAvaiable);
        infoPanel.add(avaiable);
        

    }
}