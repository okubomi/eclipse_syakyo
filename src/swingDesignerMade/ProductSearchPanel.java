package swingDesignerMade;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import gamenIdouUserNameDisp.UserSession;

/**
 * 商品検索パネル
 */
public class ProductSearchPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ProductSearchPanel(UserSession session) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("info"));
		add(panel, BorderLayout.NORTH);
		
		// レイアウト上部：キーワード検索
		JLabel lblNewLabel = new JLabel("商品名");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(20);
		// 幅300, 高さ30にする
		textField.setPreferredSize(new Dimension(300, 30));
		panel.add(textField);

		
		JButton btnNewButton = new JButton("検索");
		panel.add(btnNewButton);
		
		// レイアウト下部：結果表示テーブル
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "\u5546\u54C1\u540D", "\u4FA1\u683C", "\u5728\u5EAB\u6570"
			}
		));
		scrollPane.setViewportView(table);
		
		//
		// 手動追加：セッション情報の利用例（ステータスバーなど）
	    JLabel lblUser = new JLabel("ログイン中: " + session.getUserName());
	    add(lblUser, BorderLayout.SOUTH);

	}
	
	/**
	 * 単体テスト用のメインメソッド
	 */
	public static void main(String[] args) {
		// SwingのGUI処理はEvent Dispatch Thread上で行うのがルール
		javax.swing.SwingUtilities.invokeLater(() -> {
			try {
				// OS標準の見た目にする（任意）
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				
				JFrame frame = new JFrame("商品検索パネル - 単体テスト起動");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(900, 600);

				// 1. テスト用の擬似セッションを作成
				UserSession testSession = new UserSession();
				testSession.setUserName("テスト太郎（デバッグ用）");

				// 2. パネルを生成して追加
				// 本来はコンストラクタで引数を受け取るように変更するのが望ましいです
				ProductSearchPanel panel = new ProductSearchPanel(testSession); 
				frame.getContentPane().add(panel);

				frame.setLocationRelativeTo(null); // 画面中央に表示
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
