package br.oo.alexandria.library.views;

import br.oo.alexandria.library.controllers.UserCreate;
import br.oo.alexandria.library.util.Constants;
import java.awt.BorderLayout;
import javax.swing.*;

public class SignupScreen extends Screen {

    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField passwordField;

    private JButton signupButton;

    public SignupScreen() {

        super(Constants.SIGNUP_LABEL);

        this.nameField = new JTextField();
        this.emailField = new JTextField();
        this.phoneField = new JTextField();
        this.passwordField = new JTextField();
        this.signupButton = new JButton(Constants.SIGNUP_LABEL);

        draw();

    }

    private void draw() {

        getFrame().setSize(Constants.WINDOW_DIMENSION);
        getFrame().setVisible(true);

        getMainPanel().setLayout(new BorderLayout());

        JLabel nameLabel = new JLabel(Constants.NAME_LABEL);
        getMainPanel().add(nameLabel);
        getMainPanel().add(nameField);

        JLabel emailLabel = new JLabel(Constants.EMAIL_LABEL);
        getMainPanel().add(emailLabel);
        getMainPanel().add(emailField);

        JLabel phoneLabel = new JLabel(Constants.PHONE_LABEL);
        getMainPanel().add(phoneLabel);
        getMainPanel().add(phoneField);

        JLabel passwordLabel = new JLabel(Constants.PASSWORD_LABEL);
        getMainPanel().add(passwordLabel);
        getMainPanel().add(passwordField);

        this.signupButton.addActionListener(new UserCreate(this));
        getMainPanel().add(signupButton);

        getFrame().add(getMainPanel());

        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().repaint();

    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public void setEmailField(JTextField emailField) {
        this.emailField = emailField;
    }

    public JTextField getPhoneField() {
        return phoneField;
    }

    public void setPhoneField(JTextField phoneField) {
        this.phoneField = phoneField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JTextField passwordField) {
        this.passwordField = passwordField;
    }

    public JButton getSignupButton() {
        return signupButton;
    }

    public void setSignupButton(JButton signupButton) {
        this.signupButton = signupButton;
    }

}
