package view.custom_components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * This class is a JLabel that acts as a button. Shows '>' on the left upon mouse hover.
 * Minimum dimensions: 300 x 300
 */

public class MenuItemJLabel extends JLabel implements MouseListener {

    public JLabel label;
    public JLabel image = new JLabel("");
    public JLabel indicator = new JLabel(">");
    public int width = getWidth();
    public int height = getWidth();

    public MenuItemJLabel(String name) {
        this.label = new JLabel(name);
    }

    public MenuItemJLabel(String name, ImageIcon icon, int width, int height) {
        label = new JLabel(name, SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.TOP);
        image.setIcon(icon);
        image.addMouseListener(this);
        this.setLayout(null);
        this.add(label);
        this.add(image);
        this.add(indicator);

        // TODO: debug
//        label.setBackground(Color.darkGray);
//        label.setOpaque(true);
//        image.setBackground(Color.gray);
//        image.setOpaque(true);
//        indicator.setBackground(Color.lightGray);
//        indicator.setOpaque(true);

        indicator.setBounds((int)((width - 300) / 2),0,50,250);
        image.setBounds((int)((width - 300) / 2) + 50,0,250,250);
        label.setBounds( (int)((width - 300) / 2) + 50,250,width - 50,height - 250);

        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        label.setForeground(Color.BLACK);
        indicator.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 75));
        indicator.setForeground(Color.BLACK);
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
        label.setForeground(Color.DARK_GRAY);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        indicator.setVisible(false);
        label.setForeground(Color.black);
    }
}
