package com.ynov.eatmanager.application.views;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends View {
    @Override
    public Component getComponent() {
        DefaultButtonModel model = new DefaultButtonModel();
        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(Box.createVerticalGlue());
        verticalBox.add(Box.createVerticalGlue());
        verticalBox.add(new JButton("Display employees"));
        verticalBox.add(Box.createVerticalGlue());
        JPanel panel = new JPanel(new GridBagLayout());
        panel.add(verticalBox);
        return panel;
    }

    @Override
    public void onNavigatedTo() {
        System.out.println("Yo from Dashboard view!");
    }
}
