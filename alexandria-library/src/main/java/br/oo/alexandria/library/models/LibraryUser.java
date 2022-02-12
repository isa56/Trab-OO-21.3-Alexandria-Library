package br.oo.alexandria.library.models;

import br.oo.alexandria.library.models.User;

public class LibraryUser extends User {

    public LibraryUser(String name, String phone, String email) {
        super(name, phone, email);
    }

    public void returnBook(Book book) {
        book.returnBook();
    }

    public void lendBook(Book book) {
        book.lendBook();
    }

}
