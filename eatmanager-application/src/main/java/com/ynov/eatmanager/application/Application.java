package com.ynov.eatmanager.application;


import com.ynov.eatmanager.application.navigation.NavigationManager;
import com.ynov.eatmanager.application.views.DashboardView;

import javax.swing.*;

import static javax.swing.SwingUtilities.invokeLater;

public class Application {
    public static void main(String[] args) {
        invokeLater(Application::run);
    }

    private static void run() {
        JFrame frame = new JFrame();
        NavigationManager.Initialize(frame);
        NavigationManager.getInstance().navigateTo(new DashboardView());

        frame.setVisible(true);
        frame.setSize(800, 800);
    }
}