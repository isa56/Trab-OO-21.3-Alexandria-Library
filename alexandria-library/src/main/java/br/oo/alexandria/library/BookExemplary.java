package br.oo.alexandria.library;

import java.util.*;

public class BookExemplary extends Book {

    private int id;
    
    
    /*public Date lentFromDate(Date date, LibraryUser user) {
        
    }*/
    
    public void returnBook() {
        isAvailable = true;
    }

    public void lendBook() {

    }

}
