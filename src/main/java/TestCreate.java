import br.com.challenge.dao.CategoryDao;
import br.com.challenge.dao.ProductDao;
import br.com.challenge.model.Category;
import br.com.challenge.model.Product;
import br.com.challenge.util.FactoryUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class TestCreate {
    public static void main(String[] args) {
        Category category = new Category("Smartphones");
        Product product = new Product("Smartphone Xiomi", "Redmi 9", new BigDecimal("986.90"));
        product.setCategory(category);
        EntityManager em = FactoryUtil.getEntityManager();

        ProductDao productDao = new ProductDao(em);
        CategoryDao categoryDao = new CategoryDao(em);

        //realizando transação manualmente
        em.getTransaction().begin();
        categoryDao.create(category);
        productDao.create(product);
        em.getTransaction().commit();
        em.close();
    }
}
