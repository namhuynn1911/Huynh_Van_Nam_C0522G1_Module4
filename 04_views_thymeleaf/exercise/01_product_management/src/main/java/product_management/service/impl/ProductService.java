package product_management.service.impl;

import org.springframework.stereotype.Service;
import product_management.model.Product;
import product_management.repository.IProductRepository;
import product_management.repository.impl.ProductRepository;
import product_management.service.IProductService;

import java.util.List;

@Service
public class ProductService implements IProductService {
    private IProductRepository iProductRepository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        iProductRepository.update(product);
    }

    @Override
    public void remove(int id) {
        iProductRepository.remove(id);
    }

    @Override
    public List<Product> finByName(String name) {
        return iProductRepository.finByName(name);
    }
}
