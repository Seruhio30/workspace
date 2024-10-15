package com.seruhioCode30.quickbites.service;

import com.seruhioCode30.quickbites.model.Ingredient;
import com.seruhioCode30.quickbites.model.Product;
import com.seruhioCode30.quickbites.repository.IngredientRepository;
import com.seruhioCode30.quickbites.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private IngredientRepository ingredientRepository;

    // Crear un nuevo producto
    public Product createProduct(Product product) {
        // Verificar si los ingredientes ya existen, si no, crearlos
        List<Ingredient> ingredients = product.getIngredients().stream()
                .map(ingredient -> ingredientRepository.findById(ingredient.getId())
                        .orElseGet(() -> ingredientRepository.save(ingredient)))
                .collect(Collectors.toList());

        // Asignar los ingredientes al producto
        product.setIngredients(ingredients);

        // Guardar el producto
        return productRepository.save(product);
    }
    // Obtener todos los productos
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Obtener un producto por ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Actualizar un producto existente
    public Product updateProduct(Long id, Product productDetails) {
        Optional<Product> existingProductOpt = productRepository.findById(id);

        if (existingProductOpt.isPresent()) {
            Product existingProduct = existingProductOpt.get();
            existingProduct.setName(productDetails.getName());
            existingProduct.setPrice(productDetails.getPrice());
            existingProduct.setDescription(productDetails.getDescription());
            existingProduct.setIngredients(productDetails.getIngredients());
            existingProduct.setImage(productDetails.getImage());

            return productRepository.save(existingProduct);
        } else {
            throw new RuntimeException("Product not found with id " + id);
        }
    }

    // Eliminar un producto
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
