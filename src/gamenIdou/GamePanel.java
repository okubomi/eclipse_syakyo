package gamenIdou;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

    public GamePanel(MainFrame1 frame) {
    	setBackground(Color.ORANGE);

        JLabel label = new JLabel("ゲーム画面");
        JButton back = new JButton("戻る");

        back.addActionListener(e -> {
            frame.showScreen("start");
        });

        add(label);
        add(back);
    }
}

