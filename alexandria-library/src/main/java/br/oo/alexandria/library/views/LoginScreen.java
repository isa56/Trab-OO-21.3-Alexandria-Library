package br.oo.alexandria.library.views;

import br.oo.alexandria.library.controllers.UserLogin;
import java.awt.*;
import javax.swing.*;

import br.oo.alexandria.library.util.Constants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen {  //  Não está aparecendo, por que?

    private JFrame loginFrame;
    private JPanel mainPanel;
    private JTextField emailField;
    private JTextField passwordField;
    private JButton loginButton;
    private JButton signupButton;

    public LoginScreen() {
        this.loginFrame = new JFrame(Constants.LOGIN_LABEL);
        this.mainPanel = new JPanel();
        this.emailField = new JTextField();
        this.passwordField = new JTextField();
        this.loginButton = new JButton(Constants.LOGIN_LABEL);
        this.signupButton = new JButton(Constants.SIGNUP_LABEL);

        draw();
    }

    private void draw() {
        this.loginFrame.setSize(Constants.WINDOW_DIMENSION);
        this.loginFrame.setVisible(true);

        this.mainPanel.setLayout(new BorderLayout());

        JLabel emailLabel = new JLabel(Constants.EMAIL_LABEL);
        this.mainPanel.add(emailLabel);
        this.mainPanel.add(emailField);

        JLabel passwordLabel = new JLabel(Constants.PASSWORD_LABEL);
        this.mainPanel.add(passwordLabel);
        this.mainPanel.add(passwordField);

        this.loginButton.addActionListener(new UserLogin(this));
        this.mainPanel.add(loginButton);
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
        this.loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.loginFrame.repaint();

    }

    public JFrame getLoginFrame() {
        return loginFrame;
    }

    public void setLoginFrame(JFrame loginFrame) {
        this.loginFrame = loginFrame;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
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

