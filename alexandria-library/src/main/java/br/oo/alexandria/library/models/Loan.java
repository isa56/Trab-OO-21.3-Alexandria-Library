package br.oo.alexandria.library.models;

import java.util.Calendar;
import java.util.Date;

public class Loan {

    private User user;
    private Book book;
    private Date lentDate;
    private Date returnedDate;
    private boolean loanFinished;

    public Loan(User user, Book book, Date lentDate, boolean loanFinished) {
        this.user = user;
        this.book = book;
        this.lentDate = lentDate;
        this.loanFinished = loanFinished;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getLentDate() {
        return lentDate;
    }

    public void setLentDate(Date lentDate) {
        this.lentDate = lentDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public Date getReturnDate() {
        if (returnedDate == null) {
            Calendar c = Calendar.getInstance();
            c.setTime(this.lentDate);
            c.add(Calendar.DATE, 14);
            return (c.getTime());
        }
        else {
            return returnedDate;
        }
    }

    public boolean isLoanFinished() {
        return loanFinished;
    }

    public void setLoanFinished(boolean loanFinished) {
        this.loanFinished = loanFinished;
    }

}
