package com.example.NimapInfotechMTest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NimapInfotechMTest.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
