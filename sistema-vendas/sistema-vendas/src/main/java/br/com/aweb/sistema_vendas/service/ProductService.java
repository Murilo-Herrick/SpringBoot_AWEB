package br.com.aweb.sistema_vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aweb.sistema_vendas.model.Product;
import br.com.aweb.sistema_vendas.repository.ProductRepository;
import jakarta.transaction.Transactional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional
    public Product create(Product product) {
        return productRepository.save(product);
    }
}
