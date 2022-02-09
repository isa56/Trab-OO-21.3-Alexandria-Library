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
    
    public static final String BOOK_AVAILABLE_LABEL = "Disponível";
    public static final String BOOK_UNAVAILABLE_LABEL = "Indisponível";
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

    
    // DIMENSIONS:
    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 300;
    public static final Dimension WINDOW_DIMENSION = new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
    
}
