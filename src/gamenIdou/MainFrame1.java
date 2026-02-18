package gamenIdou;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame1 extends JFrame {

    CardLayout cardLayout = new CardLayout();
    JPanel container = new JPanel(cardLayout);

    public MainFrame1() {

        container.add(new StartPanel(this), "start");
        container.add(new GamePanel(this), "game");

        add(container);

        setTitle("Swing 画面遷移サンプル");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // 画面切替メソッド
    public void showScreen(String name) {
        cardLayout.show(container, name);
    }

    public static void main(String[] args) {
        new MainFrame1();
    }
}

