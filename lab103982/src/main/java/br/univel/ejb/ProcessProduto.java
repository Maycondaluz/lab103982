package br.univel.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.univel.Hibernate.ConfigHibernate;
import br.univel.classes.Produto;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ProcessProduto {

	public String criar(Produto p) {
		Session session = ConfigHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		session.persist(p);
		session.getTransaction().commit();
		session.close();
		return "Cadastrado com sucesso: " + p.toString();
	}

	public String ler(Long id) {
		Session session = ConfigHibernate.getSessionFactory().openSession();
		session.beginTransaction();

		Criteria cr = session.createCriteria(Produto.class);
		cr.add(Restrictions.idEq(id));
		java.util.List result = cr.list();

		session.close();

		if (result.size() > 0) {
			Produto p = (Produto) result.get(0);
			return p.toString();
		} else {
			return "O produto não foi encontrado!!";
		}
	}

	public String atualizar(Produto p) {
		Session session = ConfigHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		session.merge(p);
		session.getTransaction().commit();
		session.close();
		return "Produto atualizado com sucesso: " + p.toString();
	}

	public String excluir(Long id) {
		Produto p = new Produto();
		p.setId(id);

		Session session = ConfigHibernate.getSessionFactory().openSession();
		session.beginTransaction();

		try {
			session.delete(p);
			session.getTransaction().commit();
			session.close();
			return "O produto foi excluído!!";
		} catch (Exception e) {
			session.close();
			return "Não foi possível excluir o produto com o id(" + id + ") informado";
		}
	}

}
