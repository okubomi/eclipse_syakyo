package gamenIdou;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StartPanel extends JPanel {

    public StartPanel(MainFrame1 frame) {
    	setBackground(Color.GREEN);

        JButton button = new JButton("ゲーム開始");

        button.addActionListener(e -> {
            frame.showScreen("game");
        });

        add(button);
    }
}
