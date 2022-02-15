package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.models.Loan;
import br.oo.alexandria.library.views.Screen;
import br.oo.alexandria.library.views.UsersLoansScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BookReturn implements ActionListener {

    UsersLoansScreen screen;

    public BookReturn(UsersLoansScreen screen) {
        this.screen = screen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int selectedRow = this.screen.getListingTable().getSelectedRow();
        List<Loan> loansList = Screen.getLoansList();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this.screen.getFrame(), "Selecione um livro para devolver");
        } else {

            DefaultTableModel model = this.screen.getLoansTableModel();

            try {

                this.screen.getMyLoansList().get(selectedRow).setLoanFinished(true);
                this.screen.getMyLoansList().get(selectedRow).setReturnedDate(new Date());
                this.screen.getMyLoansList().get(selectedRow).getBook().setIsAvailable(true);

                loansList.get(selectedRow).setLoanFinished(true);
                Screen.setLoansList(loansList);

                WindowEvents.saveFile();

                screen.getFrame().setVisible(false);
                new UsersLoansScreen(screen.getUser());
                this.screen.getFrame().repaint();

            } catch (Exception excep) {
                JOptionPane.showMessageDialog(this.screen.getFrame(), "Não foi possível devolver o livro");
            }

        }

    }

}
