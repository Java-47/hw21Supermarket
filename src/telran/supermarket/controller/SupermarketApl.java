package telran.supermarket.controller;

import java.time.LocalDate;

import telran.supermarket.dao.SupermarketImpl;
import telran.supermarket.model.Product;

public class SupermarketApl {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		SupermarketImpl supermarket = new SupermarketImpl();
		Product product1 = new Product(1, "name1", "category3","brand3", 30.0, now);
		Product product2 = new Product(2, "name1", "category1","brand1", 30.0, now.minusDays(35));
		Product product3 = new Product(3, "name1", "category3","brand1", 30.0, now);
		Product product4 = new Product(4, "name2", "category1","brand1", 30.0, now);
		Product product5 = new Product(5, "name3", "category2","brand1", 30.0, now.minusDays(2));
		Product product6 = new Product(6, "name4", "category2", "brand3", 30.0, now);
		
		supermarket.addProduct(product1);
		supermarket.addProduct(product2);
		supermarket.addProduct(product3);
		supermarket.addProduct(product4);
		supermarket.addProduct(product5);
		supermarket.addProduct(product6);
		
		
		printProducts(supermarket);
		System.out.println("================EXPIRE DATE===============");
		System.out.println(supermarket.findProductWithExpDate());
		System.out.println("================REMOVE TEST barcode 3===============");
		supermarket.removeProduct(3);
		printProducts(supermarket);
		System.out.println("================FIND BY BARCODE 4===============");
		System.out.println(supermarket.findByBarcode(4));
		System.out.println("================FIND BY CATEGORY category2 exp 5,6===============");
		System.out.println(supermarket.findByCategory("category2"));
		
		System.out.println("================FIND BY BRAND brand3 exp 1,6 ===============");
		System.out.println(supermarket.findByBrand("brand3"));
		
		
	}
	
	static void printProducts(SupermarketImpl supermarket) {
		for (Product product : supermarket) {
			System.out.println(product.toString());
		}
	}
	

}
