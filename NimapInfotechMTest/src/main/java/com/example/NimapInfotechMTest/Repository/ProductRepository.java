package com.example.NimapInfotechMTest.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.NimapInfotechMTest.entity.Products;

public interface ProductRepository extends JpaRepository<Products,Long>{

	List<Products> findAllByCategory_Id(int id);

}
