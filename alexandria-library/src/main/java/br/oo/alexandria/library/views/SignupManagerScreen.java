package br.oo.alexandria.library.views;

import br.oo.alexandria.library.controllers.ManagerCreate;
import br.oo.alexandria.library.util.Constants;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class SignupManagerScreen extends Screen {

    private JPanel formPanel;
    private JPanel buttonsPanel;

    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField passwordField;

    private JButton signupButton;

    public SignupManagerScreen() {

        super(Constants.LOGIN_LABEL);

        this.nameField = new JTextField(Constants.FIELD_SIZE);
        this.emailField = new JTextField(Constants.FIELD_SIZE);
        this.phoneField = new JTextField(Constants.FIELD_SIZE);
        this.passwordField = new JTextField(Constants.FIELD_SIZE);
        this.signupButton = new JButton(Constants.SIGNUP_LABEL);

        draw();

    }

    private void draw() {

        getFrame().setSize(Constants.WINDOW_DIMENSION);

        getMainPanel().setLayout(new BorderLayout());

        drawForm();
        drawButtons();

        getFrame().add(getMainPanel());

        getFrame().setVisible(true);
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().repaint();

    }

    private void drawForm() {

        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1));

        JLabel nameLabel = new JLabel(Constants.NAME_LABEL);
        formPanel.add(nameLabel);
        formPanel.add(nameField);

        JLabel emailLabel = new JLabel(Constants.EMAIL_LABEL);
        formPanel.add(emailLabel);
        formPanel.add(emailField);

        JLabel phoneLabel = new JLabel(Constants.PHONE_LABEL);
        formPanel.add(phoneLabel);
        formPanel.add(phoneField);

        JLabel passwordLabel = new JLabel(Constants.PASSWORD_LABEL);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

                
        getMainPanel().add(formPanel, BorderLayout.CENTER);

    }

    private void drawButtons() {

        buttonsPanel = new JPanel();

        this.signupButton.addActionListener(new ManagerCreate(this));
        buttonsPanel.add(signupButton);

        getMainPanel().add(buttonsPanel, BorderLayout.SOUTH);
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
