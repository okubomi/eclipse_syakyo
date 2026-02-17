package syakyo;

public class Dog {
	private String name;
	private int age;
	
	//変数に値を代入する初期処理
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// プロフィールを表示する
	public void profile() {
		System.out.println(name + "は" + age + "歳です。");
	}
	
	// 動作確認用mainメソッド
	public static void main(String[] args) {
		Dog dog = new Dog("ウィリー", 6);
		dog.profile();
	}
	
}
