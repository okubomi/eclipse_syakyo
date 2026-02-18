package subKinouPanelSample;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import gamenIdouUserNameDisp.UserSession;

/**
 * 商品管理セクションの親パネル。
 * 内部に「商品検索」と「商品登録」の2つのカードを持つ。
 */
public class ProductSectionPanel extends JPanel {
    private CardLayout sectionLayout = new CardLayout();
    private JPanel cardContainer = new JPanel(sectionLayout);
    private UserSession session;

    public ProductSectionPanel(UserSession session) {
        this.session = session;
        setLayout(new BorderLayout());

        // --- 1. セクション内サブナビゲーション (上部) ---
        JPanel subNav = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subNav.setBackground(new Color(100, 100, 100));
        JButton btnSearch = new JButton("商品検索へ");
        JButton btnRegister = new JButton("新規登録へ");
        subNav.add(btnSearch);
        subNav.add(btnRegister);
        add(subNav, BorderLayout.NORTH);

        // --- 2. カードコンテナに各画面を登録 ---
        // ※実際にはこれらも別ファイル(ProductSearchPanel等)に切り出す
        cardContainer.add(new ProductSearchPanel(session), "Search");
        cardContainer.add(new ProductRegisterFlow(session), "RegisterFlow");
        add(cardContainer, BorderLayout.CENTER);

        // --- 3. 切り替えイベント ---
        btnSearch.addActionListener(e -> sectionLayout.show(cardContainer, "Search"));
        btnRegister.addActionListener(e -> sectionLayout.show(cardContainer, "RegisterFlow"));
    }

    /**
     * 【単体テスト用メインメソッド】
     * 開発担当者は、このファイルを右クリック > Run As > Java Application で
     * MainFrameがなくてもこの画面だけで動作確認が可能です。
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("ProductSectionPanel 単体テスト");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            // テスト用の共有データ
            UserSession testSession = new UserSession();
            testSession.setUserName("デバッグ担当者");

            // テスト対象パネルをセット
            frame.add(new ProductSectionPanel(testSession));
            frame.setVisible(true);
        });
    }
}

