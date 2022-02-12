package br.oo.alexandria.library.util;

import java.awt.Dimension;

public abstract class Constants {

    // FRAME-RELATED:
    public static final String PROGRAM_NAME = "Alexandria";
    public static final String SCREEN_LOGIN = "Login";
    public static final String SCREEN_SIGNUP = "Cadastro";
    public static final String SCREEN_USER = "Cadastro";
    
    // LABELS:
    public static final String NAME_LABEL = "Nome";
    public static final String EMAIL_LABEL = "Email";
    public static final String PHONE_LABEL = "Telefone";
    public static final String PASSWORD_LABEL = "Senha";
    
    public static final String BOOK_NAME_LABEL = "Nome";
    public static final String BOOK_LABEL = "Livro";
    public static final String BOOKS_LABEL = "Livros";
    public static final String BOOK_AUTHOR_LABEL = "Autor";
    public static final String BOOK_RELEASEDATE_LABEL = "Ano de Lançamento";
    public static final String BOOK_EDITOR_LABEL = "Editora";
    public static final String BOOK_GENRE_LABEL = "Gênero";
    
    public static final String BOOK_AVAILABILITY_LABEL = "Disponibilidade";
    public static final String BOOK_AVAILABLE_LABEL = "Disponível";
    public static final String BOOK_UNAVAILABLE_LABEL = "Indisponível";
    public static final String BOOK_READER_LABEL = "Leitor";
    public static final String BOOK_READERS_LABEL = "Leitores";
    public static final String BOOK_LENTDATE_LABEL = "Data de empréstimo";
    public static final String BOOK_RETURNEDDATE_LABEL = "Data de devolução";
    public static final String MYLOAN_LABEL = "Meus Empréstimos";
    
    public static final String LOGIN_LABEL = "Entrar";
    public static final String SIGNUP_LABEL = "Cadastrar";
    public static final String GOBACK_LABEL = "Voltar";
    public static final String LOAN_LABEL = "Empréstimos";
    public static final String ADD_BOOK_LABEL = "Cadatrar Livro";
    public static final String YES_LABEL = "Sim";
    public static final String NO_LABEL = "Não";
    public static final String RETURNING_LABEL = "Devolução";
    public static final String RETURN_LABEL = "Devolver";
    public static final String DELETE_LABEL = "Deletar";

    // LISTING STRING ARRAYS:
    public static final String[] BOOKS_LISTING = {Constants.BOOK_LABEL, Constants.BOOK_AUTHOR_LABEL, Constants.DELETE_LABEL};
    public static final String[] BOOKS_USER_LISTING = {Constants.BOOK_LABEL, Constants.BOOK_AUTHOR_LABEL, Constants.BOOK_AVAILABILITY_LABEL};
    public static final String[] LOANS_LISTING = {Constants.BOOK_LABEL, Constants.BOOK_LENTDATE_LABEL, Constants.BOOK_READER_LABEL};
    public static final String[] LOANS_USER_LISTING = {Constants.BOOK_LABEL, Constants.BOOK_LENTDATE_LABEL, Constants.RETURNING_LABEL};

    // DIMENSIONS:
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 400;
    public static final int MENU_WIDTH = 400;
    public static final Dimension WINDOW_DIMENSION = new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
    public static final Dimension MENU_DIMENSION = new Dimension(Constants.MENU_WIDTH, Constants.WINDOW_HEIGHT);
    public static final int FIELD_SIZE = 10;
    
    
}
