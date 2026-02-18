package subKinouPanelSample;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import gamenIdouUserNameDisp.UserSession;

/**
 * 商品検索画面クラス
 */
public class ProductSearchPanel extends JPanel {
    
    public ProductSearchPanel(UserSession session) {
        // 背景色を変えて、画面が切り替わったことを分かりやすくする
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        // 上部：検索入力エリア
        JPanel searchHeader = new JPanel();
        searchHeader.add(new JLabel("商品名:"));
        searchHeader.add(new JTextField(15));
        searchHeader.add(new JButton("検索"));
        add(searchHeader, BorderLayout.NORTH);

        // 中央：結果表示エリア（スタブ）
        JLabel dummyTable = new JLabel("ここに検索結果のJTableが表示されます", SwingConstants.CENTER);
        add(dummyTable, BorderLayout.CENTER);

        // フッター：ログイン情報
        add(new JLabel("操作担当: " + session.getUserName()), BorderLayout.SOUTH);
    }
}