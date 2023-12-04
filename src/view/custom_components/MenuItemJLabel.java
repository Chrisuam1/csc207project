package view.custom_components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * This class is a JLabel that acts as a button. Shows '>' on the left upon mouse hover.
 *
 */

public class MenuItemJLabel extends JLabel implements MouseListener {

    public JLabel label;
    public JLabel image;
    public JLabel indicator = new JLabel(">");

    public MenuItemJLabel(String name) {
        this.label = new JLabel(name);
    }

    public MenuItemJLabel(String name, ImageIcon icon) {
        label = new JLabel(name);
        image.setIcon(icon);
        image.addMouseListener(this);
        this.setLayout(null);
        this.add(image);
        image.setBounds(0,0,250,250);
        image.addMouseListener(this);
        image.setLayout(new BorderLayout());
        image.add(label, BorderLayout.EAST);
        image.add(indicator);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.setBounds(this.getX() + 5,this.getY() + 5,this.getWidth(),this.getHeight());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setBounds(this.getX() - 5,this.getY() - 5,this.getWidth(),this.getHeight());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        indicator.setVisible(true);
        label.setForeground(Color.red);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        indicator.setVisible(false);
        label.setForeground(Color.BLUE);
    }
}
