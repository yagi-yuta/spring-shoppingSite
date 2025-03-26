package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	// SELECT * FROM items WHERE category_id = ?
	List<Item> findByCategoryId(Integer categoryId);
}

//JpaRepository には findByCategoryId のようなメソッドは定義されていないためList<Item> findByCategoryId(Integer categoryId);が記載されてる
//このメソッドは、category_id が指定された categoryId と一致する Item を全て検索し、そのリストを返す