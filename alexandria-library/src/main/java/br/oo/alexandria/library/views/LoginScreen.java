package br.oo.alexandria.library.views;

import br.oo.alexandria.library.controllers.UserLogin;
import java.awt.*;
import javax.swing.*;

import br.oo.alexandria.library.util.Constants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends Screen {  //  Não está aparecendo, por que?

    private JTextField emailField;
    private JTextField passwordField;
    private JButton loginButton;
    private JButton signupButton;

    public LoginScreen() {
        super(Constants.LOGIN_LABEL);

        this.emailField = new JTextField(Constants.FIELD_SIZE);
        this.passwordField = new JTextField(Constants.FIELD_SIZE);
        this.loginButton = new JButton(Constants.LOGIN_LABEL);
        this.signupButton = new JButton(Constants.SIGNUP_LABEL);

        draw();
    }

    private void draw() {
        getFrame().setSize(Constants.WINDOW_DIMENSION);

        getMainPanel().setLayout(new BorderLayout());
        getMainPanel().setPreferredSize(Constants.WINDOW_DIMENSION);

        GridLayout grid = new GridLayout(4, 2);
        grid.setVgap(5);
        grid.setHgap(10);

        JPanel textFieldsPanel = new JPanel();
        textFieldsPanel.setLayout(grid);
        textFieldsPanel.setPreferredSize(new Dimension(300, 150));

        JLabel emailLabel = new JLabel(Constants.EMAIL_LABEL);
        textFieldsPanel.add(emailLabel);
        textFieldsPanel.add(emailField);

        JLabel passwordLabel = new JLabel(Constants.PASSWORD_LABEL);
        textFieldsPanel.add(passwordLabel);
        textFieldsPanel.add(passwordField);

        getMainPanel().add(textFieldsPanel, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setPreferredSize(new Dimension(150, 100));

        this.loginButton.addActionListener(new UserLogin(this));

        buttonsPanel.add(this.loginButton, BorderLayout.WEST);

        buttonsPanel.add(this.signupButton, BorderLayout.EAST);

        this.signupButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        getFrame().setVisible(false);
                        new SignupScreen();
                    }
                }
        );

        getMainPanel().add(this.signupButton);

        getFrame().add(getMainPanel());
        getFrame().setVisible(true);
        
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().repaint();
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public void setEmailField(JTextField emailField) {
        this.emailField = emailField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JTextField passwordField) {
        this.passwordField = passwordField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public JButton getSignupButton() {
        return signupButton;
    }

    public void setSignupButton(JButton signupButton) {
        this.signupButton = signupButton;
    }

}
