package gamenIdouUserNameDisp;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 4. ホーム画面（全画面に表示したい情報を共有データから取得）
public class HomePanel extends JPanel {
	
    private JLabel welcomeLabel = new JLabel();

    public HomePanel(MainFrame frame, UserSession session) {
    	// --- 追加：初期表示用 ---
        welcomeLabel.setText("ようこそ、 " + session.getUserName() + " さん！");
        // -
        
        setLayout(new BorderLayout());
        add(welcomeLabel, BorderLayout.CENTER);
        JButton backBtn = new JButton("戻る");
        add(backBtn, BorderLayout.SOUTH);

        // コンポーネントが表示される直前にラベルを更新する仕組み
        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent e) {
                welcomeLabel.setText("ようこそ、 " + session.getUserName() + " さん！");
            }
        });

        backBtn.addActionListener(e -> frame.showPage("Login"));
    }
    
    // HomePanel.java 内にデバッグ用に追加
    public static void main(String[] args) {
        JFrame f = new JFrame();      
        // 開発用のダミーデータ
        UserSession session = new UserSession();
        session.setUserName("テスト太郎");
        f.add(new HomePanel(null,session )); // テスト用にnullやダミーセッションを渡す
        f.setSize(400, 300);
        f.setVisible(true);
    }
}