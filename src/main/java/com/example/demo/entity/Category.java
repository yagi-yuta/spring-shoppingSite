package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
	@Id // @idは主キーとして使う宣言（割り振りはしてない）

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GenerationValue主キーの自動で生成
	//GenerationType.IDENTITY: この指定により、データベースが自動的に主キーの値をインクリメント（1, 2, 3…のように順番に増やす）して設定。これを使うと、データが挿入されるたびに、データベースが主キーを自動的に割り振る。

	private Integer id; // カテゴリーID

	private String name; // カテゴリー名

	// ゲッター
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}

//エンティティは、データベースのテーブルに対応するクラス。
//データベースの情報をオブジェクトとして扱い、レポジトリを使ってそのデータの読み書きを行う