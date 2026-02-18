package swingDesignerMade;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class UserRegistrationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	// WindowBuilderで編集しやすくするため、入力フィールドをフィールド変数に昇格
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	
    public UserRegistrationPanel() {
        // 1. 全体はBorderLayout
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(20, 20, 20, 20));

        // 2. タイトル
        JLabel lblTitle = new JLabel("新規ユーザー登録");
        lblTitle.setFont(new Font("MS ゴシック", Font.BOLD, 18));
        add(lblTitle, BorderLayout.NORTH);

        // 3. 入力フォーム本体 (GridBagLayout)
        JPanel formPanel = new JPanel(new GridBagLayout());
        add(formPanel, BorderLayout.CENTER);

        // --- 1行目: ユーザー名 ---
        JLabel lblUsername = new JLabel("ユーザー名:");
        GridBagConstraints gbc_lblUsername = new GridBagConstraints();
        gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
        gbc_lblUsername.gridx = 0;
        gbc_lblUsername.gridy = 0;
        formPanel.add(lblUsername, gbc_lblUsername);

        txtUsername = new JTextField();
        GridBagConstraints gbc_txtUsername = new GridBagConstraints();
        gbc_txtUsername.insets = new Insets(0, 0, 5, 0);
        gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtUsername.weightx = 1.0;
        gbc_txtUsername.gridx = 1;
        gbc_txtUsername.gridy = 0;
        formPanel.add(txtUsername, gbc_txtUsername);
        txtUsername.setColumns(10);

        // --- 2行目: パスワード ---
        JLabel lblPassword = new JLabel("パスワード:");
        GridBagConstraints gbc_lblPassword = new GridBagConstraints();
        gbc_lblPassword.insets = new Insets(0, 0, 0, 5);
        gbc_lblPassword.gridx = 0;
        gbc_lblPassword.gridy = 1;
        formPanel.add(lblPassword, gbc_lblPassword);

        pwdPassword = new JPasswordField();
        GridBagConstraints gbc_pwdPassword = new GridBagConstraints();
        gbc_pwdPassword.fill = GridBagConstraints.HORIZONTAL;
        gbc_pwdPassword.gridx = 1;
        gbc_pwdPassword.gridy = 1;
        formPanel.add(pwdPassword, gbc_pwdPassword);

        // 4. ボタンエリア
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        add(buttonPanel, BorderLayout.SOUTH);

        JButton btnCancel = new JButton("キャンセル");
        buttonPanel.add(btnCancel);

        JButton btnRegister = new JButton("登録する");
        buttonPanel.add(btnRegister);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            JFrame frame = new JFrame("ユーザー登録パネル - 単体テスト");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new UserRegistrationPanel());
            frame.pack(); 
            frame.setSize(450, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}