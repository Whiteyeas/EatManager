package com.ynov.eatmanager.application.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardView extends View {
    @Override
    public Component getComponent() {
        JPanel panel = new JPanel();

        JPanel buttons = createTopButtons();

        panel.add(buttons, BorderLayout.PAGE_START);

        return panel;
    }

    @Override
    public void onNavigatedTo() {
        System.out.println("Yo from Dashboard view!");
    }

    private JPanel createTopButtons() {
        // Panel pour tout les bouttons
        JPanel buttons = new JPanel();
        // Stack en horizontal
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));

        buttons.add(createAddButton());
        buttons.add(createManageButton());

        return buttons;
    }

    private JButton createAddButton() {
        // Menu contextuel du boutton Ajouter
        final JPopupMenu menu = new JPopupMenu();

        // Création des items du menu
        JMenuItem item = new JMenuItem("Nouvel utilisateur");
        menu.add(item);

        item = new JMenuItem("Nouveau restaurant");
        menu.add(item);

        item = new JMenuItem("Nouveau stock");
        menu.add(item);

        JButton button = new JButton("Ajouter");
        button.addActionListener(e -> menu.show(button, button.getX(), button.getY()));

        return button;
    }

    private JButton createManageButton() {
        // Menu contextuel du boutton Gérer
        final JPopupMenu menu = new JPopupMenu();

        // Création des items du menu
        JMenuItem item = new JMenuItem("Les utilisateurs");
        menu.add(item);

        item = new JMenuItem("Les restaurants");
        menu.add(item);

        item = new JMenuItem("Les stocks");
        menu.add(item);

        JButton button = new JButton("Gérer");
        button.addActionListener(e -> menu.show(button, button.getX(), button.getY()));

        return button;
    }
}
