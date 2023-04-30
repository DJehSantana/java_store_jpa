import br.com.challenge.dao.CategoryDao;
import br.com.challenge.dao.ProductDao;
import br.com.challenge.model.Category;
import br.com.challenge.model.Product;
import br.com.challenge.util.FactoryUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class TestCreate {
    public static void main(String[] args) {
       //createProduct();

       EntityManager em = FactoryUtil.getEntityManager();
       ProductDao productDao = new ProductDao(em);

       List <Product> products = productDao.findAll();
       products.forEach(p -> System.out.println(p.getName()));

       CategoryDao categoryDao = new CategoryDao(em);
       Category category = categoryDao.findById(1l);

       System.out.println(category.getName() + " - Produtos: " + category.getProducts());

    }

    public static void createProduct() {
        EntityManager em = FactoryUtil.getEntityManager();
        Category category = em.find(Category.class, 2l);
        Product product = new Product("Poco F3", "Smartphone Xiomi", new BigDecimal("1275.90"));
        product.setCategory(category);

        ProductDao productDao = new ProductDao(em);
        //realizando transação manualmente
        em.getTransaction().begin();
        productDao.create(product);
        em.getTransaction().commit();
        em.close();
    }
}
