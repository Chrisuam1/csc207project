package view.custom_components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * This class is a JLabel that acts as a button. Shows '>' on the left upon mouse hover.
 * Minimum dimensions: 300 x 300
 *
 */

public class MenuItemJLabel extends JLabel implements MouseListener {

    public final JLabel label;
    private final JLabel indicator = new JLabel(">");

    public MenuItemJLabel(String name, int width) {
        label = new JLabel(name, SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        this.setLayout(null);
        this.add(label);
        this.add(indicator);
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        label.setForeground(Color.BLACK);
        indicator.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 75));
        indicator.setForeground(Color.BLACK);
        indicator.setBounds(0,25, 50, 50);
        label.setBounds(50, 0, width, 100);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        label.addMouseListener(this);
        indicator.setVisible(false);

    }

    public MenuItemJLabel(String name, ImageIcon icon, int width, int height) {
        label = new JLabel(name, SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.TOP);
        JLabel image = new JLabel("");
        image.setIcon(icon);
        image.addMouseListener(this);
        this.setLayout(null);
        this.add(label);
        this.add(image);
        this.add(indicator);

        indicator.setBounds((int)((width - 300) / 2),0,50,250);
        image.setBounds((int)((width - 300) / 2) + 50,0,250,250);
        label.setBounds( (int)((width - 300) / 2) + 50,250,width - 50,height - 250);

        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        label.setForeground(Color.BLACK);
        indicator.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 75));
        indicator.setForeground(Color.BLACK);
        indicator.setVisible(false);

//        Debug
//        label.setBackground(Color.darkGray);
//        label.setOpaque(true);
//        image.setBackground(Color.gray);
//        image.setOpaque(true);
//        indicator.setBackground(Color.lightGray);
//        indicator.setOpaque(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.setBounds(this.getX() + 2,this.getY() + 2,this.getWidth(),this.getHeight());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setBounds(this.getX() - 2,this.getY() - 2,this.getWidth(),this.getHeight());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        indicator.setVisible(true);
        label.setForeground(Color.black);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        indicator.setVisible(false);
        label.setForeground(Color.black);
    }
}
