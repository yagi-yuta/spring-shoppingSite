package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component //@Component スプリングにクラスを管理させる。（情報をスプリングコンテナに保存しインスタンス化を他のクラスでも行えるように準備）
@SessionScope //@Session scope ユーザーごとにhttpセッションを管理（httpセッションはウェブサーバー、そこにある情報をスプリングコンテナが管理）。セッションが終了（ブラウザを閉じる、一定期間経過）するとインスタンスを破棄する

public class Account {

	private String name;

	//ゲッター
	public String getName() {
		return name;
	}

	//セッター voidにする　セッターは値を返さないため
	public void setName(String name) {

		this.name = name;
	}

}
