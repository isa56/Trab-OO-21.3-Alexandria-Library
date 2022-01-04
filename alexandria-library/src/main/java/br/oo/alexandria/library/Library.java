package br.oo.alexandria.library;

public class Library {

    
    public void listBooks() {
        
    }
    
    public boolean findBookByName(String bookName) {
        return true;
    }
    
    public boolean findBookByAuthor (String bookAuthor) {
        return true;
    }
    
    public boolean isBookAvailable(String bookName) {
        return true;
    }
    
    public boolean isBookAvailable(String bookAuthor, int releaseYear) {    // Sobrecarga de isBookAvailable
        return true;
    }
    
    
}
