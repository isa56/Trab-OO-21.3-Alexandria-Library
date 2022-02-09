package br.oo.alexandria.library.views;

import br.oo.alexandria.library.util.Constants;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class BookReturnScreen extends Screen {

    private JButton yesButton;
    private JButton noButton;
    
    public BookReturnScreen() {
        
        super("Devolver Livro");
        
        yesButton = new JButton(Constants.YES_LABEL);
        noButton = new JButton(Constants.NO_LABEL);
        
        draw();
        
    }
    
    private void draw() {
        
        // Colocar o texto :/

        getFrame().setSize(Constants.WINDOW_DIMENSION);
        getFrame().setVisible(true);

        getMainPanel().setLayout(new BorderLayout());
        
        getMainPanel().add(yesButton);
        getMainPanel().add(noButton);
        
        packScreen();
        
    }
    

    
}
