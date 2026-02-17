package syakyo;

public class Pets {
	
	public static void describePet(String petName) {
		// 別のdescribePet()を呼び出す
		describePet(petName, "イヌ");
	}
	
	public static void describePet(String petName, String anamalType) {
		// 別のdescribePet()を呼び出す
		System.out.println("\n私は" + anamalType + "を飼っています。");
		System.out.println(anamalType + "の名前は" + petName + "です。");
	}
	
	public static void main(String[] args) {
		describePet("ウイリー");
		describePet("ミケ", "ネコ");
	}
}
