package br.oo.alexandria.library.views;

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
    private JPanel formPanel;
    private JPanel titlePanel;
    private JPanel buttonPanel;
    private JButton backButton;
    private JButton loanButton;
    private JList<Book> lista;
    private int lastIndex;

    public BookDetailsScreen(Book book){
        super(Constants.BOOK_LABEL);
        this.lastIndex = 0;
        
        draw();
    }
    
     public int getLastIndex(){
        return lastIndex;
    }

    public void setLastIndex(int lastIndex){
        this.lastIndex = lastIndex;
    }
   
    
    private void draw(){
        getFrame().setSize(Constants.WINDOW_DIMENSION);
        
        getMainPanel().setLayout(new BorderLayout());
        
        formPanel = new JPanel();
        titlePanel = new JPanel();
        buttonPanel = new JPanel();
        
        JLabel nameLabel = new JLabel(book.getBookName());
        titlePanel.add(nameLabel);
        
        JLabel authorLabel = new JLabel(book.getBookAuthor());
        formPanel.add(authorLabel);
        
        JLabel releaseYear = new JLabel(Integer.toString(book.getReleaseYear()));
        formPanel.add(releaseYear);
        
        JLabel editor = new JLabel(book.getEditorName());
        formPanel.add(editor);
        
        JLabel genre = new JLabel(book.getBookGenre().name());
        formPanel.add(genre);
        
        String sAvaiable;
        if(book.isIsAvailable()){
            sAvaiable = "Sim";
        }else{
            sAvaiable = "NÃ£o";
        }
        JLabel avaiable = new JLabel(sAvaiable);
        formPanel.add(avaiable);
        DefaultListModel<Book> model = new DefaultListModel<>();
        
        lista = new JList<>(model);
        lista.setVisible(true);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.addListSelectionListener(new TratarLista(this));
        
        formPanel.add(new JScrollPane(lista), BorderLayout.WEST);
        
        }
}