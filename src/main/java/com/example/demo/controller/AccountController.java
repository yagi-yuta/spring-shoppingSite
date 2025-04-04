package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;

@Controller
public class AccountController {

	@Autowired //@Autowired @Componentで保存した情報でインスタンス化（スプリングコンテナに保存されたクラスをもとにデータを生成）
	HttpSession session;

	@Autowired //@Autowired @Componentで保存した情報でインスタンス化（スプリングコンテナに保存されたクラスをもとにデータを生成）
	Account account;

	//ログイン画面の表示　タスク1
	@GetMapping({ "/", "/login", "/logout" })
	public String index(
			@RequestParam(name = "error", defaultValue = "") String error,
			Model model) //RequestParmでURLにあるerrorを受け取る箱を用意 defaultvalueは最初に入ってる値　それらをString方のerrorで送ってる　Modelに関して　これは作成したModelクラスではなくSpringMVCにあるModel　ビューに送る機能です
	　　　{
		session.invalidate();//httpセッションをクリアするコード セッションはあくまでアプリケーション内にはない 
		if (error.equals("notLoggedIn")) {
			model.addAttribute("message", "ログインしてください");
		}

		return "login";
	}

	//ログインする機能　タスク2
	@PostMapping({ "/login" })
	public String login(
			@RequestParam("name") String name,
			Model model) {
		//ログイン時名前が空ならエラーしメッセージ表示
		if (name == null || name.length() == 0) {
			model.addAttribute("message", "名前を入力してください");
			return "login";
		}

		// セッション管理されたアカウント情報に名前をセット
		account.setName(name);

		return "redirect:/items";
	}

}

//インスタンス化　クラスをもとにデータ生成すること

//@Repuestparm urlパラメーターを受け取るアノテーション　（"受け取るパラメーター名"）データ型　変数名
//model.addAttribute は変数（値）をビューに送るためのもの indexメソッドではerror変数をloginに送ってる ビューのこの部分！！{{$error}}
