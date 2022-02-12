package br.oo.alexandria.library.views;

import br.oo.alexandria.library.models.Book;
import br.oo.alexandria.library.util.Constants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConfirmBookLoanScreen extends Screen {

    private Book book;
    private JPanel textPanel;
    private JPanel buttonsPanel;
    private JButton yesButton;
    private JButton noButton;

    public ConfirmBookLoanScreen(Book book) {

        super("Emprestar Livro");
        
        this.book = book;

        yesButton = new JButton(Constants.YES_LABEL);
        noButton = new JButton(Constants.NO_LABEL);

        draw();

    }

    private void draw() {
        getFrame().setSize(Constants.WINDOW_DIMENSION);

        getMainPanel().setLayout(new BorderLayout());

        textPanel = new JPanel();
        textPanel.setPreferredSize(new Dimension(Constants.MENU_WIDTH, 100));
        textPanel.add(new JLabel("Deseja pegar o livro " + book.getBookName() + " emprestado?"));
        
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(0, 2));
        buttonsPanel.setPreferredSize(new Dimension(Constants.MENU_WIDTH, 200));

        buttonsPanel.add(yesButton);
        buttonsPanel.add(noButton);

        getMainPanel().add(textPanel, BorderLayout.NORTH);
        getMainPanel().add(buttonsPanel, BorderLayout.CENTER);
        
        getFrame().add(getMainPanel());

        getFrame().setVisible(true);
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().repaint();
    }

}
