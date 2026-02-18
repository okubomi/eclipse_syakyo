package gamenIdouUserNameDisp;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

 // 3. ログイン画面
public class LoginPanel extends JPanel {
    public LoginPanel(MainFrame frame, UserSession session) {
        setLayout(new GridBagLayout());
        JTextField nameField = new JTextField(15);
        JButton loginBtn = new JButton("ログイン");

        add(new JLabel("名前入力: "));
        add(nameField);
        add(loginBtn);

        loginBtn.addActionListener(e -> {
            // 共有データにセット
            session.setUserName(nameField.getText());
            // 画面遷移
            frame.showPage("Home");
        });
    }
}
