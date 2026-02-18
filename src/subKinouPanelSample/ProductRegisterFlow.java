package subKinouPanelSample;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gamenIdouUserNameDisp.UserSession;

/**
 * 商品登録の一連の流れ（ウィザード）を管理するクラス
 */
public class ProductRegisterFlow extends JPanel {
    private CardLayout internalLayout = new CardLayout();
    
    public ProductRegisterFlow(UserSession session) {
        setLayout(internalLayout);

        // --- STEP 1: 入力パネル ---
        JPanel inputStep = new JPanel(new GridBagLayout());
        inputStep.setBackground(new Color(240, 255, 240)); // 薄緑
        JButton toConfirmBtn = new JButton("確認へ");
        inputStep.add(new JLabel("新規商品名を入力: "));
        inputStep.add(new JTextField(10));
        inputStep.add(toConfirmBtn);

        // --- STEP 2: 確認パネル ---
        JPanel confirmStep = new JPanel(new GridBagLayout());
        confirmStep.setBackground(new Color(255, 245, 230)); // 暖色
        JButton toFinishBtn = new JButton("登録確定");
        JButton backBtn = new JButton("戻る");
        confirmStep.add(new JLabel("この内容で登録しますか？"));
        confirmStep.add(backBtn);
        confirmStep.add(toFinishBtn);

        // --- STEP 3: 完了パネル ---
        JPanel finishStep = new JPanel(new GridBagLayout());
        finishStep.add(new JLabel("登録が完了しました！"));
        JButton resetBtn = new JButton("続けて登録する");
        finishStep.add(resetBtn);

        // カード登録
        add(inputStep, "Step1");
        add(confirmStep, "Step2");
        add(finishStep, "Step3");

        // --- 画面遷移ロジック ---
        toConfirmBtn.addActionListener(e -> internalLayout.show(this, "Step2"));
        backBtn.addActionListener(e -> internalLayout.show(this, "Step1"));
        toFinishBtn.addActionListener(e -> internalLayout.show(this, "Step3"));
        resetBtn.addActionListener(e -> internalLayout.show(this, "Step1"));
    }
}