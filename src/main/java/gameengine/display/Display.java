package gameengine.display;

import gameengine.input.KeyManager;
import gameengine.input.MouseManager;

import javax.swing.*;
import java.awt.*;

public class Display {

    private JFrame frame;
    private Canvas canvas;

    private int width, height;
    private String title;

    public Display(String titel, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = titel;

        createDisplay();

        canvas.addKeyListener(KeyManager.getInstance());
        canvas.addMouseListener(MouseManager.getInstance());
        canvas.addMouseMotionListener(MouseManager.getInstance());
    }

    private void createDisplay() {
        // Frame
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(true);

        frame.add(canvas, BorderLayout.CENTER);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }


}
