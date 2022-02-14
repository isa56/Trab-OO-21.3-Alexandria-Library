package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.views.BookListingScreen;
import br.oo.alexandria.library.views.Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BookDelete implements ActionListener {

    BookListingScreen screen;

    public BookDelete(BookListingScreen screen) {
        this.screen = screen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = this.screen.getListingTable().getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this.screen.getFrame(), "Selecione um livro para remoção");
        } else {
            DefaultTableModel model = this.screen.getBooksTableModel();

            try {
                model.removeRow(selectedRow);
                Screen.getBookList().remove(selectedRow);
    
                this.screen.getFrame().repaint();
    
            } catch (Exception excep) {

            }
        }
    }

}
