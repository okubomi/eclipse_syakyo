package syakyo;

import java.util.Scanner;  // Scanner クラスを使うためにインポート

public class InputSample {
    public static void main(String[] args) {

        // Scanner オブジェクトを作成（System.in はキーボード入力を意味する）
        Scanner scanner = new Scanner(System.in);

        // --- 文字列の入力 ---
        // ユーザーに名前の入力を促すメッセージを表示
        System.out.print("あなたの名前を入力してください: ");

        // nextLine() で1行分の文字列を入力として受け取る
        String name = scanner.nextLine();

        // 入力された名前を使ってメッセージを表示
        System.out.println("こんにちは、" + name + "さん!");

        // --- 整数の入力 ---
        // ユーザーに年齢の入力を促すメッセージを表示
        System.out.print("あなたの年齢を入力してください: ");

        // nextInt() で整数を入力として受け取る
        int age = scanner.nextInt();

        // 入力された整数を使ってメッセージを表示
        System.out.println("あなたは " + age + " 歳ですね。");

    }
}