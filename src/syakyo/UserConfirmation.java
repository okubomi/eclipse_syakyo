package syakyo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 未確認ユーザリストから確認済みユーザリストに移し替えるプログラム
public class UserConfirmation {
    public static void main(String[] args) {

        // 入力を受け取る Scanner を作成
        Scanner scanner = new Scanner(System.in);

        // Python の辞書 responses = {} に相当
        Map<String, String> responses = new HashMap<>();

        // 投票がアクティブかどうかを示すフラグ（Python の polling_active = True）
        boolean pollingActive = true;

        // while polling_active: と同じ
        while (pollingActive) {

            // 名前を入力してもらう
            System.out.print("\nあなたのお名前は？ ");
            String name = scanner.nextLine();

            // 登りたい山を入力してもらう
            System.out.print("いつか登りたい山は何ですか？ ");
            String response = scanner.nextLine();

            // 辞書に保存（Python の responses[name] = response）
            responses.put(name, response);

            // 他に回答者がいるか確認
            System.out.print("誰か他に回答してくれる人はいますか？ (yes/ no) ");
            String repeat = scanner.nextLine();

            // no と答えたらループ終了（Python の if repeat == 'no': polling_active = False）
            if (repeat.equalsIgnoreCase("no")) {
                pollingActive = false;
            }
        }

        // 投票結果の表示（Python の print("\n--- 投票結果 ---")）
        System.out.println("\n--- 投票結果 ---");

        // 辞書の内容をすべて表示（Python の for name, response in responses.items():）
        for (Map.Entry<String, String> entry : responses.entrySet()) {
            System.out.println(entry.getKey() + "さんが登りたいのは" + entry.getValue() + "です。");
        }

        // Scanner を閉じる
        scanner.close();
    }


}
