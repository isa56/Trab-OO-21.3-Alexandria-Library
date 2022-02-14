package br.oo.alexandria.library.models;

import br.oo.alexandria.library.models.LibraryUser;
import java.util.*;

public class Book {
    
    protected String bookName;
    protected String bookAuthor;
    protected String editorName;
    protected int releaseYear;
    protected Genre bookGenre;
    protected List<LibraryUser> readerList = new ArrayList<>(); 
    protected boolean isAvailable;

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Book(String bookName, String bookAuthor, String editorName, int releaseYear, Genre bookGenre) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.editorName = editorName;
        this.releaseYear = releaseYear;
        this.bookGenre = bookGenre;
        this.isAvailable = true;
    }
    
    // Getters and Setters:
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getEditorName() {
        return editorName;
    }

    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Genre getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(Genre bookGenre) {
        this.bookGenre = bookGenre;
    }

    public List<LibraryUser> getReaderList() {
        return readerList;
    }

    public void addReader(LibraryUser user) {
        readerList.add(user);
    }
    
    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    
    
}

