package br.oo.alexandria.library;

public class LibraryUser extends User {

    public void returnBook(BookExemplary book) {

        book.returnBook();

    }

    public void lendBook(BookExemplary book) {

        book.lendBook();

    }

}
