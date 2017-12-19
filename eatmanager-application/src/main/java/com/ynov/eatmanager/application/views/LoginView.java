package com.ynov.eatmanager.application.views;

import com.ynov.eatmanager.application.navigation.NavigationManager;
import com.ynov.eatmanager.server.queries.UserQueries;
import com.ynov.eatmanager.service.DatabaseConnexion;
import org.jdbi.v3.core.Jdbi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class LoginView extends View {
    private  JTextField _addressText;
    private JTextField _usernameText;
    private  JTextField _passwordText;

    @Override
    public Component getComponent() {
        // Create container and define vertical stack layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        _addressText = new JTextField(20);
        JLabel addressLabel = new JLabel("Adresse du serveur");
        JPanel addressPanel = new JPanel();
        addressPanel.add(addressLabel, BorderLayout.WEST);
        addressPanel.add(_addressText, BorderLayout.CENTER);
        panel.add(addressPanel);

        _usernameText = new JTextField(20);
        JLabel usernameLabel = new JLabel("Nom d'utilisateur");
        JPanel usernamePanel = new JPanel();
        usernamePanel.add(usernameLabel, BorderLayout.WEST);
        usernamePanel.add(_usernameText, BorderLayout.CENTER);
        panel.add(usernamePanel);

        _passwordText = new JPasswordField(20);
        JLabel passwordLabel = new JLabel("Mot de passe");
        JPanel passwordPanel = new JPanel();
        passwordPanel.add(passwordLabel, BorderLayout.WEST);
        passwordPanel.add(_passwordText, BorderLayout.CENTER);
        panel.add(passwordPanel);

        JButton button = new JButton("Se connecter");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isValid()) {
                    System.out.println("Bien");
                    connect();
                } else {
                    System.out.println("PAS bien");
                }
            }
        });
        panel.add(button);

        return panel;
    }

    @Override
    public void onNavigatedTo() {
        System.out.println("Yo from Login view!");
    }

    private static final Pattern PATTERN = Pattern.compile(
            "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    private boolean isValid() {
        String error = null;

        String address = _addressText.getText();
        String username = _usernameText.getText();
        String password = _passwordText.getText();
        if (address == null || !PATTERN.matcher(address).matches()){
            error = "L'adresse IP n'est pas valide (format Ipv4 attendu)";
        }
        else if (username == null || username.length() < 2) {
            error = "Veuillez rentrer un nom d'utilisateur valide";
        }
        else if (password == null || password.length() < 2) {
            error = "Veuillez rentrer votre mot de passe";
        }

        if (error == null) {
            return true;
        }

        JOptionPane.showMessageDialog(null, error);

        return false;
    }

    private void connect() {
        try
        {
            DatabaseConnexion.setIP(_addressText.getText());
            Jdbi database = DatabaseConnexion.get();
            UserQueries queries = new UserQueries();
            int rank = queries.connexion(_usernameText.getText(), _passwordText.getText());

            if (rank > 0) {
                NavigationManager.getInstance().navigateTo(new DashboardView());
            } else {
                JOptionPane.showMessageDialog(null, "Identifiants incorrects !");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Une erreur est survenue...");
        }
    }
}
