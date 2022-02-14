package br.oo.alexandria.library.controllers;

import br.oo.alexandria.library.models.Book;
import br.oo.alexandria.library.models.Loan;
import br.oo.alexandria.library.models.User;
import br.oo.alexandria.library.views.BookDetailsScreen;
import br.oo.alexandria.library.views.BookListingScreen;
import br.oo.alexandria.library.views.Screen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class LoanCreate implements ActionListener {

    BookDetailsScreen screen;
    Book book;
    User user;

    public LoanCreate(BookDetailsScreen screen, Book book, User user) {
        this.screen = screen;
        this.book = book;
        this.user = user;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        List<Loan> loansList = Screen.getLoansList();

        Loan loan = new Loan(
                user,
                book,
                new Date(),
                false
        );

        loansList.add(loan);

        Screen.setLoansList(loansList);

        screen.getFrame().setVisible(false);
        new BookListingScreen(user);

    }

}
