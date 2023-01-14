package telran.supermarket.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import telran.supermarket.model.Product;

public class SupermarketImpl implements SuperMarket {
	private Collection<Product> products;

	public SupermarketImpl() {
		products = new ArrayList<>();

	}

	@Override
	public Iterator<Product> iterator() {
		return products.iterator();
	}

	@Override
	public boolean addProduct(Product product) {
		if (findByBarcode(product.getBarCode()) != null || product == null) {
			return false;
		}
		products.add(product);
		return true;
	}

	@Override
	public Product removeProduct(long barCode) {
		Product victim = findByBarcode(barCode);
		products.remove(victim);
		return victim;
	}

	@Override
	public Product findByBarcode(long barCode) {

		for (Product product : products) {
			if (product.getBarCode() == barCode) {
				return product;
			}
		}

		return null;
	}

	@Override
	public Iterable<Product> findByCategory(String category) {
		List<Product> categoryList = new ArrayList<>();
		for (Product product : products) {
			if (product.getCategory().equals(category)) {
				categoryList.add(product);
			}
		}
		return categoryList;
	}

	@Override
	public Iterable<Product> findByBrand(String brand) {
		List<Product> brandList = new ArrayList<>();
		for (Product product : products) {
			if (product.getBrand().equals(brand)) {
				brandList.add(product);
			}
		}
		return brandList;
	}

	@Override
	public Iterable<Product> findProductWithExpDate() {
		List<Product> ExpDateList = new ArrayList<>();
		LocalDate dateNow = LocalDate.now();
		for (Product product : products) {
			if (product.getExpDate().compareTo(dateNow) < 0) {
				ExpDateList.add(product);
			}
		}
		return ExpDateList;
	}

	@Override
	public int skuQuantity() {
		return products.size();
	}

}
