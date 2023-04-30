import br.com.challenge.dao.ProdutoDao;
import br.com.challenge.model.Produto;
import br.com.challenge.util.FactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroProdutos {
    public static void main(String[] args) {
        Produto produto = new Produto();
        EntityManager em = FactoryUtil.getEntityManager();

        ProdutoDao dao = new ProdutoDao(em);

        produto.setName("Smartphone Xiomi");
        produto.setDescription("Redmi 9");
        produto.setValue(new BigDecimal("986.90"));

        //realizando transação manualmente
        em.getTransaction().begin();
        dao.cadastrar(produto);
        em.getTransaction().commit();
        em.close();
    }
}
