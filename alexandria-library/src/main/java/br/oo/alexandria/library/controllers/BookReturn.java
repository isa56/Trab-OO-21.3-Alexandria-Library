package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.models.Loan;
import br.oo.alexandria.library.views.Screen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class BookReturn implements ActionListener {

    Screen screen;
    Loan loan;

    public BookReturn(Screen screen, Loan loan) {
        this.screen = screen;
        this.loan = loan;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        loan.setLoanFinished(true);
        loan.setReturnedDate(new Date());
        
    }
    
    
    
}
