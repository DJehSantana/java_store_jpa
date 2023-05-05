import br.com.challenge.dao.CategoryDao;
import br.com.challenge.dao.GenericDao;
import br.com.challenge.dao.ProductDao;
import br.com.challenge.model.Category;
import br.com.challenge.model.Client;
import br.com.challenge.model.Product;
import br.com.challenge.util.FactoryUtil;
import org.hibernate.service.spi.InjectService;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;


public class TestCreate {
    public static void main(String[] args) {
       createProduct();

       EntityManager em = FactoryUtil.getEntityManager();

       ProductDao productDao = new ProductDao(em, Product.class);

       List <Product> products = productDao.findByCategory("Smartphones");
       products.forEach(p -> System.out.println(p.getName()));

       CategoryDao categoryDao = new CategoryDao(em, Category.class);
       Category category = categoryDao.findById(1l);

       System.out.println(category.getName() + " - Produtos: " + category.getProducts());

    }

    public static void createProduct() {
        EntityManager em = FactoryUtil.getEntityManager();
        Category category = em.find(Category.class, 1l);

        if (category == null) {
            category = createCategory();
        }

        Product product = new Product("Poco F3", "Smartphone Xiomi", new BigDecimal("1275.90"));
        product.setCategory(category);

        ProductDao productDao = new ProductDao(em, Product.class);
        //realizando transação manualmente
        em.getTransaction().begin();
        productDao.create(product);
        em.getTransaction().commit();
        em.close();
    }

    public static Category createCategory () {
        EntityManager em = FactoryUtil.getEntityManager();
        Category category = new Category("Smartphones");

        CategoryDao categoryDao = new CategoryDao(em, Category.class);
        em.getTransaction().begin();
        categoryDao.create(category);
        em.getTransaction().commit();
        category = em.find(Category.class, 1l);
        em.close();
        return category;
    }

    public static void createOrder() {
        EntityManager em = FactoryUtil.getEntityManager();
        Client client = new Client("Roberto", "123456789");


    }
}
