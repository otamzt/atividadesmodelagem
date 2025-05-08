import java.math.BigDecimal;
import java.util.List;

interface ProdutoRepositorio {
    List<Produto> buscarPorFaixaDePreco(BigDecimal min, BigDecimal max);
}

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

class ProdutoRepositorioHibernate implements ProdutoRepositorio {

    private final SessionFactory sessionFactory;

    public ProdutoRepositorioHibernate() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Produto.class); // Assumindo que Produto está anotado
        sessionFactory = configuration.buildSessionFactory();
    }

    @Override
    public List<Produto> buscarPorFaixaDePreco(BigDecimal min, BigDecimal max) {
        try (Session session = sessionFactory.openSession()) {
            Query<Produto> query = session.createNamedQuery("Produto.buscarPorFaixa", Produto.class); // Assumindo NamedQuery em Produto
            query.setParameter("minPreco", min);
            query.setParameter("maxPreco", max);
            return query.list();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar produtos por faixa de preço (Hibernate)", e);
        }
    }

    public void fechar() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

class ProdutoRepositorioArquivo implements ProdutoRepositorio {

    private final String nomeArquivo = "produtos.ser"; 

    @Override
    public List<Produto> buscarPorFaixaDePreco(BigDecimal min, BigDecimal max) {
        List<Produto> produtosEncontrados = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            List<Produto> todosProdutos = (List<Produto>) ois.readObject();
            for (Produto produto : todosProdutos) {
                if (produto.getPreco().compareTo(min) >= 0 && produto.getPreco().compareTo(max) <= 0) {
                    produtosEncontrados.add(produto);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao ler produtos do arquivo: " + e.getMessage());
        }
        return produtosEncontrados;
    }
}
