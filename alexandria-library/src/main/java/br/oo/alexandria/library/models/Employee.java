package br.oo.alexandria.library.models;

import br.oo.alexandria.library.Library;
import java.util.*;

public class Employee extends User {

    public Employee(String name, String phone, String email, String password) {
        super(name, phone, email, password);
    }

    public void lendBook(Book book, LibraryUser user) {
        book.lendBook(user);
        
    }

    // Por enquanto printa
    public void findBookLenders(String bookName) {
        Book book = Library.findBookByName(bookName);
        List<LibraryUser> readerList = book.getReaderList();
        readerList.forEach(reader -> {
            System.out.println("Usuário: " + reader.getName() + "\nTelefone: " + reader.getPhone() + "\nE-Mail: " + reader.getEmail() + "\n");
        });
    }

}
