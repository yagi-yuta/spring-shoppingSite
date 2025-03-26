package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Account;

@Aspect //@ AOPのアスペクトを示すアノテーションで、共通の処理を定義します
@Component //自動でインスタンス化
public class CheckLoginAspect {

	@Autowired
	Account account;

	// ログ出力処理
	// @Beforeはcom.example.demo.controller パッケージ内の全ての Controller クラスの全メソッドの処理前にこのメソッド実行するという意味
	@Before("execution(* com.example.demo.controller.*Controller.*(..))") //
	public void writeLog(JoinPoint jp) {
		// ログインしたアカウント情報を取得
		if (account == null || account.getName() == null
				|| account.getName().length() == 0) {
			System.out.print("ゲスト：");
		} else {
			System.out.print(account.getName() + "：");
		}
		System.out.println(jp.getSignature());
	}

	// 未ログインの場合ログインページにリダイレクト
	@Around("execution(* com.example.demo.controller.ItemController.*(..)) ||"
			+ "execution(* com.example.demo.controller.CartController.*(..)) ||"
			+ "execution(* com.example.demo.controller.OrderController.*(..))")
	public Object checkLogin(ProceedingJoinPoint jp) throws Throwable {
		if (account == null || account.getName() == null
				|| account.getName().length() == 0) {
			System.err.println("ログインしていません!");
			// リダイレクト先を指定する
			// パラメータを渡すことでログインControllerで
			// 個別のメッセージをThymeleafに渡すことも可能
			return "redirect:/login?error=notLoggedIn";
		}
		// Controller内のメソッドの実行
		return jp.proceed();
	}
}

//AOPは共通の処理機能を記載　ログインのチェック処理