package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

//DBの保存や取得を行う仕組み　JpaRepository（フレームワークにすでにある設計図）を継承して作る
//interface は動作を持たずメソッドだけを定義して、動作（保存や取得など）は継承親のJpaRepository が行ってる
//extends（継承）JpaRepository ＜エンティティクラス,IDの型＞