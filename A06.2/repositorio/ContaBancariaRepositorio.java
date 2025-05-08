import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.UUID;

public class ContaBancariaRepositorio {

    private final SessionFactory sessionFactory;

    public ContaBancariaRepositorio() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(ContaBancaria.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public ContaBancaria buscarPorId(UUID id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(ContaBancaria.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar ContaBancaria por ID", e);
        }
    }

    public void salvar(ContaBancaria conta) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(conta);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao salvar ContaBancaria", e);
        }
    }

    public List<ContaBancaria> buscarContasComSaldoNegativo() {
        try (Session session = sessionFactory.openSession()) {
            Query<ContaBancaria> query = session.createQuery("FROM ContaBancaria WHERE saldo < 0", ContaBancaria.class);
            return query.list();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar contas com saldo negativo", e);
        }
    }

    public void fechar() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
