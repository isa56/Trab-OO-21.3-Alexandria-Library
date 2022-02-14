package br.oo.alexandria.library.util;

import br.oo.alexandria.library.models.Book;
import br.oo.alexandria.library.models.Employee;
import br.oo.alexandria.library.models.LibraryUser;
import br.oo.alexandria.library.models.Loan;
import br.oo.alexandria.library.models.Manager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class JSON {

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

    
    public static Book toBook(String content) {
        Gson gson = new Gson();
        Book book = gson.fromJson(content, Book.class);

        return book;
    }
    
    public static List<Book> toBooks(String content) {
        Gson gson = new Gson();
        Type bookType = new TypeToken<ArrayList<Book>>() {
        }.getType();
        List<Book> books = gson.fromJson(content, bookType);

        return books;
    }

    public static LibraryUser toLibraryUser(String content) {
        Gson gson = new Gson();
        LibraryUser libraryUser = gson.fromJson(content, LibraryUser.class);

        return libraryUser;
    }
    
    public static List<LibraryUser> toLibraryUsers(String content) {
        Gson gson = new Gson();
        Type libraryUserType = new TypeToken<ArrayList<LibraryUser>>() {
        }.getType();
        List<LibraryUser> libraryUsers = gson.fromJson(content, libraryUserType);

        return libraryUsers;
    }
    
    public static Manager toManager(String content) {
        Gson gson = new Gson();
        Manager manager = gson.fromJson(content, Manager.class);

        return manager;
    }
    
    public static List<Manager> toManagers(String content) {
        Gson gson = new Gson();
        Type managerType = new TypeToken<ArrayList<Manager>>() {
        }.getType();
        List<Manager> managers = gson.fromJson(content, managerType);

        return managers;
    }
    
    public static Employee toEmployee(String content) {
        Gson gson = new Gson();
        Employee employee = gson.fromJson(content, Employee.class);

        return employee;
    }
    
    public static List<Employee> toEmployees(String content) {
        Gson gson = new Gson();
        Type employeeType = new TypeToken<ArrayList<Employee>>() {
        }.getType();
        List<Employee> employee = gson.fromJson(content, employeeType);

        return employee;
    }
    
    public static Loan toLoan(String content) {
        Gson gson = new Gson();
        Loan loan = gson.fromJson(content, Loan.class);

        return loan;
    }
    
    public static List<Loan> toLoans(String content) {
        Gson gson = new Gson();
        Type loanType = new TypeToken<ArrayList<Loan>>() {
        }.getType();
        List<Loan> loan = gson.fromJson(content, loanType);

        return loan;
    }

}
