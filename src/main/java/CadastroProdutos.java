import br.com.challenge.dao.ProdutoDao;
import br.com.challenge.model.Categoria;
import br.com.challenge.model.Produto;
import br.com.challenge.util.FactoryUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroProdutos {
    public static void main(String[] args) {
        Produto produto = new Produto("Smartphone Xiomi", "Redmi 9", new BigDecimal("986.90"), Categoria.SMARTPHONES);
        EntityManager em = FactoryUtil.getEntityManager();

        ProdutoDao dao = new ProdutoDao(em);

        //realizando transação manualmente
        em.getTransaction().begin();
        dao.cadastrar(produto);
        em.getTransaction().commit();
        em.close();
    }
}
