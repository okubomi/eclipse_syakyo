package navigationUI_form;

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
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import gamenIdouUserNameDisp.UserSession;

public class MainFrame extends JFrame {
    private CardLayout mainCardLayout = new CardLayout();
    private JPanel mainContentPanel = new JPanel(mainCardLayout);
    private UserSession session = new UserSession();

    public MainFrame() {
        setTitle("階層型カードレイアウト構成");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLayout(new BorderLayout());

        // --- 1. 左側ナビゲーション ---
        JPanel navPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        navPanel.setPreferredSize(new Dimension(150, 0));
        navPanel.setBackground(Color.DARK_GRAY);
        JButton btnInputFlow = new JButton("データ登録");
        JButton btnOther = new JButton("その他画面");
        navPanel.add(btnInputFlow);
        navPanel.add(btnOther);

        // --- 2. 右側メインコンテンツの登録 ---
        // 「入力・確認・完了」の流れを持つ専用のパネルを追加
        mainContentPanel.add(new RegistrationFlowPanel(session), "RegFlow");
        mainContentPanel.add(createSimplePanel("他の画面", Color.LIGHT_GRAY), "Other");

        // ナビボタンの動作
        btnInputFlow.addActionListener(e -> mainCardLayout.show(mainContentPanel, "RegFlow"));
        btnOther.addActionListener(e -> mainCardLayout.show(mainContentPanel, "Other"));

        add(navPanel, BorderLayout.WEST);
        add(mainContentPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private JPanel createSimplePanel(String text, Color color) {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(color);
        p.add(new JLabel(text));
        return p;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame());
    }
}

/**
 * 入力 -> 確認 -> 完了 の流れを管理する内部パネル
 */
class RegistrationFlowPanel extends JPanel {
    private CardLayout internalLayout = new CardLayout();
    private UserSession session;

    public RegistrationFlowPanel(UserSession session) {
        this.session = session;
        // カードレイアウトを設定
        setLayout(internalLayout);

        // 各ステップのパネルを作成
        JPanel step1Input = new JPanel(new GridBagLayout());
        step1Input.setBackground(new Color(230, 240, 255)); // 薄い青
        JTextField nameField = new JTextField(15);
        JButton toConfirmBtn = new JButton("確認画面へ");
        step1Input.add(new JLabel("名前入力: "));
        step1Input.add(nameField);
        step1Input.add(toConfirmBtn);

        JPanel step2Confirm = new JPanel(new GridBagLayout());
        step2Confirm.setBackground(new Color(255, 255, 230)); // 薄い黄色
        JLabel confirmLabel = new JLabel();
        JButton backToInputBtn = new JButton("戻る");
        JButton toFinishBtn = new JButton("登録実行");
        step2Confirm.add(confirmLabel);
        step2Confirm.add(backToInputBtn);
        step2Confirm.add(toFinishBtn);

        JPanel step3Finish = new JPanel(new GridBagLayout());
        step3Finish.setBackground(new Color(230, 255, 230)); // 薄い緑
        step3Finish.add(new JLabel("登録が完了しました！"));
        JButton resetBtn = new JButton("最初に戻る");
        step3Finish.add(resetBtn);

        // カードに登録
        add(step1Input, "Input");
        add(step2Confirm, "Confirm");
        add(step3Finish, "Finish");

        // --- ボタンアクション ---
        toConfirmBtn.addActionListener(e -> {
            session.setUserName(nameField.getText());
            confirmLabel.setText("入力内容: " + session.getUserName() + " でよろしいですか？");
            internalLayout.show(this, "Confirm");
        });

        backToInputBtn.addActionListener(e -> internalLayout.show(this, "Input"));

        toFinishBtn.addActionListener(e -> {
            // ここでDB登録処理などを行うイメージ
            internalLayout.show(this, "Finish");
        });

        resetBtn.addActionListener(e -> {
            nameField.setText("");
            internalLayout.show(this, "Input");
        });
    }
}
