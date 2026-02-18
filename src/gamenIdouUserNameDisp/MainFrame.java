package gamenIdouUserNameDisp;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

//2. メインフレーム（CardLayoutで画面を管理）
public class MainFrame extends JFrame {

	private CardLayout cardLayout = new CardLayout();
	private JPanel container = new JPanel(cardLayout);
	
	private UserSession session = new UserSession(); // 共有データのインスタンス

	public MainFrame() {
		setTitle("CardLayout データ共有サンプル");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);

		// 各パネルにセッション（データ共有用）とこのフレーム（遷移用）を渡す
		LoginPanel loginPanel = new LoginPanel(this, session);
		HomePanel homePanel = new HomePanel(this, session);

		container.add(loginPanel, "Login");
		container.add(homePanel, "Home");

		// JFrameにカードレイアウトをセットしたパネルを追加
		add(container);
		setVisible(true);
	}

	// 画面切り替え用メソッド
	public void showPage(String pageName) {
		cardLayout.show(container, pageName);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new MainFrame());
	}
}