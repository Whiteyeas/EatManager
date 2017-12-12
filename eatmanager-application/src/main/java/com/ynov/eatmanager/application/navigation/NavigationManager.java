package com.ynov.eatmanager.application.navigation;

import com.ynov.eatmanager.application.views.View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NavigationManager {
    private static NavigationManager _instance;

    public static NavigationManager getInstance()
    {	return _instance;
    }

    public static void Initialize(JFrame root) {
        if (_instance != null) {
            return;
        }
        _instance = new NavigationManager(root);
    }

    private JFrame _mainFrame;
    private List<View> _stack;

    private NavigationManager(JFrame root) {
        _mainFrame = root;
        _stack = new ArrayList<>();
    }

    private void setView(View view) {
        _mainFrame.getContentPane().removeAll();
        _mainFrame.getContentPane().add(view.getComponent());
        _mainFrame.revalidate();

        view.onNavigatedTo();
    }

    public boolean navigateTo(View view) {
        if (view == null) {
            return false;
        }

        // Navigate to view
        setView(view);

        // Add the new view to the stack
        _stack.add(view);

        // Return success
        return true;
    }

    public boolean goBack() {
        // Return false if the stack is empty
        if (_stack.size() < 1) {
            return false;
        }

        // Get the index of the last item
        int index = _stack.size() - 1;
        View lastView = _stack.get(index);

        if (lastView != null) {
            setView(lastView);
            return true;
        } else {
            return false;
        }
    }
}