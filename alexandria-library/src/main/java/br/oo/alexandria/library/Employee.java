package br.oo.alexandria.library;

import java.util.*;

public class Employee extends User {

    private String loginPassword;

    public void lendBook(Book book, LibraryUser user) {
        book.addReader(user);
    }

    public void findBookLenders(String bookName) {
        Book book = Library.findBookByName(bookName);
        List<LibraryUser> readerList = book.getReaderList();
        readerList.forEach(reader -> {
            System.out.println("Usuário: " + reader.getName() + "\nTelefone: " + reader.getPhone() + "\nE-Mail: " + reader.getEmail() + "\n");
        });
    }

    public void addBook(String name, String author, String editor, int releaseYear, Genre genre) {

        Book b = new Book();

        b.setBookName(name);
        b.setBookAuthor(author);
        b.setEditorName(editor);
        b.setReleaseYear(releaseYear);
        b.setBookGenre(genre);

        Library.addBook(b);

    }

    public void removeBook(Book book) {
        
        
        
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

}
