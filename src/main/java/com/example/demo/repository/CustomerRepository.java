package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

//DBの保存や取得を行う仕組み　JpaRepository（フレームワークにすでにある設計図）を継承して作る
//interface は動作を持たずメソッドだけを定義して、動作（保存や取得など）は継承親のJpaRepository が行ってる
//extends（継承）JpaRepository ＜エンティティクラス,IDの型＞