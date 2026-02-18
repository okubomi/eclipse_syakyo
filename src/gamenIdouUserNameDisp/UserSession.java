package gamenIdouUserNameDisp;

/**
 * 全画面で共有するデータクラス
 */
public class UserSession {
	// 各画面に表示するログインユーザ名
	private String userName = "";

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }
}
