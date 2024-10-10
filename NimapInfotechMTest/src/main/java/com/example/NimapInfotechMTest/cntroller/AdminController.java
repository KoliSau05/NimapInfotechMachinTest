package com.example.NimapInfotechMTest.cntroller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.NimapInfotechMTest.entity.Category;
import com.example.NimapInfotechMTest.entity.ProductDTO;
import com.example.NimapInfotechMTest.entity.Products;
import com.example.NimapInfotechMTest.service.CategoryServiceInerface;
import com.example.NimapInfotechMTest.service.ProductServiceInterface;

@Controller
public class AdminController {

	// 1) This The Category Section .. 
	
	@Autowired
	private CategoryServiceInerface catService;
	
	@GetMapping("/adminpage")
	public String adminPage() {
		return "admin";
	}
	@GetMapping("/adminpage/categories")
	public String categoryPage(Model model) {
		model.addAttribute("categories", catService.getAllCategory());
		return "category";
	}
	
	@GetMapping("/adminpage/categories/add")
	public String addCategory(Model model) {
		model.addAttribute("catkey", new Category());
		return "addcat";
	}
	
	@PostMapping("/adminpage/categories/add")
	public String postCategory(@ModelAttribute("catkey")Category cat) {
		catService.addCategory(cat);
		return "redirect:/adminpage/categories";
	}
	@GetMapping("/adminpage/categories/delete/{id}")
	public String deleteCategory(@PathVariable int id) {
		catService.deleteCategoryById(id);
		return "redirect:/adminpage/categories";	}
	
	@GetMapping("/adminpage/categories/update/{id}")
	public String updateCategory(@PathVariable int id , Model model) {
		Optional<Category> obj = catService.updateCategoryById(id);
		if(obj.isPresent()) {
			model.addAttribute("catkey", obj.get());
			return "addcat";
		}
		else {
			return "Error 404";
		}
	}
	
	
	//
	// This The Product Section...
	//
	@Autowired
	private ProductServiceInterface prodService;
	public static String uploadDir = System.getProperty("user.dir")+"/src/main/resources/static/productImages";
	
	@GetMapping("/adminpage/products")
	public String productPage(Model model) {
		model.addAttribute("products", prodService.getAllProducts() );
		return "products";
	}
	@GetMapping("/adminpage/products/add")
	public String addProduct(Model model) {
		 model.addAttribute("productDTO", new ProductDTO());
	   model.addAttribute("categories", catService.getAllCategory());
	
		return "addprod";
	}
	
	@PostMapping("/adminpage/products/add")
	public String  addProductsPost(@ModelAttribute("productDTO")ProductDTO pDto,
			                        @RequestParam("productImage")MultipartFile file,
			                        @RequestParam("imgName")String imgName)throws IOException{
		
		Products obj = new Products();
		obj.setId(pDto.getId());
		obj.setProdName(pDto.getProdName());
		obj.setPrice(pDto.getPrice());
		obj.setColor(pDto.getColor());
		obj.setSize(pDto.getSize());
		obj.setCategory(catService.updateCategoryById(pDto.getCategoryId()).get());
		obj.setDescription(pDto.getDescription());
		String imageUUID;
		if(!file.isEmpty()) {
			imageUUID = file.getOriginalFilename();
			
			Path fileNameAndPath = Paths.get(uploadDir ,imageUUID);
			Files.write(fileNameAndPath, file.getBytes());
		}
		else {
			imageUUID = imgName;
		}
		obj.setImgName(imageUUID);
		prodService.addProduct(obj);
		
		return "redirect:/adminpage/products";
		
	}
			
	
	
	
	
}










