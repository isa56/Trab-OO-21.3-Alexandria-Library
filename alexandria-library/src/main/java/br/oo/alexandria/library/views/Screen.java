package br.oo.alexandria.library.views;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Screen {
    
    private JFrame frame;
    private JPanel mainPanel;

    public Screen(String frameName) {
        this.frame = new JFrame(frameName);
        this.mainPanel = new JPanel();
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
    
    
    
}

