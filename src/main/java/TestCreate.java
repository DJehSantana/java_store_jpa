import br.com.challenge.dao.*;
import br.com.challenge.model.*;
import br.com.challenge.util.FactoryUtil;
import org.hibernate.service.spi.InjectService;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;


public class TestCreate {
    public static void main(String[] args) {
       //createProduct();

       EntityManager em = FactoryUtil.getEntityManager();
       OrderDao orderDao = new OrderDao(em, Order.class);

       Order order = orderDao.findById(2l);

       if (order == null) {
           createOrder();
           order = orderDao.findById(2l);
       }

       System.out.println(order);

       //ProductDao productDao = new ProductDao(em, Product.class);

       //String jpql = "SELECT p from Product p";
       //List <Product> products = productDao.findAll(jpql);

       //products.forEach(p -> System.out.println(p.getName()));
       //CategoryDao categoryDao = new CategoryDao(em, Category.class);
       //Category category = categoryDao.findById(1l);

       //System.out.println(products + "" + category.getName());
    }

    public static void createProduct() {
        EntityManager em = FactoryUtil.getEntityManager();
        Category category = em.find(Category.class, 1l);

        if (category == null) {
            category = createCategory();
        }

        Product product = new Product("Samsung S10", "Smartphone Samsung", new BigDecimal("1565.90"));
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
        ProductDao productDao = new ProductDao(em, Product.class);
        ClientDao clientDao = new ClientDao(em, Client.class);
        OrderDao orderDao = new OrderDao(em, Order.class);
        Product product = productDao.findById(1l);

        if (product == null) {
            createProduct();
            product = productDao.findById(1l);
        }

        Client client = new Client("Roberto", "123456789");
        Order order = new Order(client);

        int amount = 2;
        order.setItens( new OrderItens(amount, order, product));
        order.setValue(product.getValue().multiply(BigDecimal.valueOf(amount)));

        em.getTransaction().begin();
        clientDao.create(client);
        orderDao.create(order);
        em.getTransaction().commit();
        em.close();
    }

}
