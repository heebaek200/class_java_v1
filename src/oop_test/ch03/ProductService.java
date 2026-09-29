package oop_test.ch03;

public class ProductService {

    private ProductDao dao;

    public ProductService() {
        this.dao = new ProductDao();
    }

    public void registerProduct(String name, int price) {

        Product product = new Product(name, price);
        dao.insertProduct(product);

    }

}
