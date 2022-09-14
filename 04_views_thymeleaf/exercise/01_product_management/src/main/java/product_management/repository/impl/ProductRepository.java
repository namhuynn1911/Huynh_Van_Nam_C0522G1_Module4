package product_management.repository.impl;

import product_management.model.Product;
import product_management.repository.IProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository {

    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Ôto", 1000000, "Xe mới, Kinh doanh", "Vinfat"));
        productMap.put(2, new Product(2, "Máy tính", 200000, "Máy mới", "Macbook"));
        productMap.put(3, new Product(3, "Điện thoại", 800000, "Mới", "iphone"));
        productMap.put(4, new Product(4, "Đồng hồ", 10000000, "Mới, máy cơ", "swith made"));
        productMap.put(5, new Product(5, "Xe máy", 90000, "Xe mới", "Vinfat"));
    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> finByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Integer, Product> productEntry : productMap.entrySet()) {
            if (productEntry.getValue().getName().contains(name)) {
                productList.add(productEntry.getValue());
            }
        }
        return productList;
    }
}
