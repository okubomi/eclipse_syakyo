package navigationMenuUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainContentPanel = new JPanel(cardLayout); // カードを載せる土台

    public MainFrame() {
        setTitle("サイドナビ付 Swingアプリ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // 1. 左側のナビゲーションメニュー作成
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new GridLayout(5, 1, 5, 5)); // 5行1列でボタンを並べる
        navPanel.setPreferredSize(new Dimension(150, 0));
        navPanel.setBackground(Color.DARK_GRAY);

        JButton btn1 = new JButton("ホーム");
        JButton btn2 = new JButton("設定");
        JButton btn3 = new JButton("データ表示");

        navPanel.add(btn1);
        navPanel.add(btn2);
        navPanel.add(btn3);

        // 2. 右側のメインコンテンツ画面（各パネルを色違いで作成）
        mainContentPanel.add(createColoredPanel("ホーム画面", Color.WHITE), "Home");
        mainContentPanel.add(createColoredPanel("設定画面", Color.LIGHT_GRAY), "Setting");
        mainContentPanel.add(createColoredPanel("データ表示画面", Color.CYAN), "Data");

        // 3. ナビゲーションボタンに切り替え処理を追加
        btn1.addActionListener(e -> cardLayout.show(mainContentPanel, "Home"));
        btn2.addActionListener(e -> cardLayout.show(mainContentPanel, "Setting"));
        btn3.addActionListener(e -> cardLayout.show(mainContentPanel, "Data"));

        // フレームへの配置
        add(navPanel, BorderLayout.WEST);   // 左にメニュー
        add(mainContentPanel, BorderLayout.CENTER); // 中央に残りの画面

        setVisible(true);
    }

    // 色違いのパネルを生成するヘルパーメソッド
    private JPanel createColoredPanel(String text, Color color) {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(color);
        p.add(new JLabel(text));
        return p;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame());
    }
}