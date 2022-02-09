package br.oo.alexandria.library.views;

import br.oo.alexandria.library.controllers.UserLogin;
import java.awt.*;
import javax.swing.*;

import br.oo.alexandria.library.util.Constants;

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
        getFrame().setVisible(true);

        getMainPanel().setLayout(new BorderLayout());

        JLabel emailLabel = new JLabel(Constants.EMAIL_LABEL);
        getMainPanel().add(emailLabel);
        getMainPanel().add(emailField);

        JLabel passwordLabel = new JLabel(Constants.PASSWORD_LABEL);
        getMainPanel().add(passwordLabel);
        getMainPanel().add(passwordField);

        this.loginButton.addActionListener(new UserLogin(this));
        getMainPanel().add(loginButton);
/*
        this.signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.setVisible(false);
                new SignupScreen();
            }

        });

        this.mainPanel.add(signupButton);
*/

        getFrame().add(getMainPanel());
        
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

