package br.oo.alexandria.library;

import br.oo.alexandria.library.models.Book;
import java.util.*;

public abstract class Library {

    public static List<Book> bookList = new ArrayList<>();

    public void listBooks() {
        bookList.forEach(book -> {
            System.out.println(book.getBookName() + ";");
        });
    }

    public static Book findBookByName(String bookName) {
        /*
        Book b = new Book();
        
        // Isso está errado!!! O que tá acontecendo???? -> Usar o equals
        // Tirar a arrow function
        bookList.forEach(book -> {
            if(book.getBookName() == bookName) {
                b = book;
                break;
            }
        });
        
        if(b != null) {
            return b;
        }
        
        System.out.println("O livro não foi encontrado!");
        return null;
         */
    }

    public static Book findBookByAuthor(String bookAuthor) {
        /*
        Book b = new Book();
        
        // Isso está errado!!! O que tá acontecendo???? -> Usar o equals
        bookList.forEach(book -> {
            if(book.getAuthorName() == bookAuthor) {
                b = book;
                break;
            }
        });
        
        if(b != null) {
            return b;
        }
        
        System.out.println("O livro não foi encontrado!");
        return null;
         */
    }

    public boolean isBookAvailable(String bookName) {
        return true;
    }

    public boolean isBookAvailable(String bookAuthor, int releaseYear) {    // Polimorfismo de isBookAvailable
        return true;
    }

    public static void addBook(Book book) {
        try {
            bookList.add(book);
        } catch (Exception e) {
            System.out.println("O livro não pôde ser adicionado!\n" + e);
        }
    }

    public static void removeBook(Book book) {
        try {
            bookList.remove(book);
        } catch (Exception e) {
            System.out.println("O livro não pôde ser removido!\n" + e);
        }
    }

}
