package br.oo.alexandria.library.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSON {

    public static String toJSON(Object o) {
        Gson gson = new Gson();
        String json = gson.toJson(o);
        return json;
    }

    public static String toJSON(List<Object> o) {
        Gson gson = new Gson();
        String json = gson.toJson(o);
        return json;
    }

    /*
    public static Book toBook(String content) {
        Gson gson = new Gson();
        Book book = gson.fromJson(content, Book.class);

        return book;
    }
    
    public static List<Book> toBook(String content) {
        Gson gson = new Gson();
        Type bookType = new TypeToken<ArrayList<Book>>() {
        }.getType();
        List<Book> books = gson.fromJson(content, bookType);

        return books;
    }

    public static User toUser(String content) {
        Gson gson = new Gson();
        User user = gson.fromJson(content, User.class);

        return user;
    }
    
    public static List<User> toUser(String content) {
        Gson gson = new Gson();
        Type userType = new TypeToken<ArrayList<User>>() {
        }.getType();
        List<User> users = gson.fromJson(content, userType);

        return users;
    }
    
     */
}
