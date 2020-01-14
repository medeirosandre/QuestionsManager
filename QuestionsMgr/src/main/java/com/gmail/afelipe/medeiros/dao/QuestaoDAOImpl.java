package com.gmail.afelipe.medeiros.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import com.gmail.afelipe.medeiros.dao.util.JPAUtil;
import com.gmail.afelipe.medeiros.modelo.Questao;

public class QuestaoDAOImpl implements QuestaoDAO {

	public EntityManager getEntityManager() {
		return JPAUtil.EMF.createEntityManager();
	}

	@Override
	public Questao adicionarQuestao(Questao questao) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(questao);
			em.flush();
			em.getTransaction().commit();
			return questao;
		}
		catch (Exception ex) {
			throw ex;
		}
		finally {
			if (em != null) {
				em.close();
			}
		}		
	}

	@Override
	public Questao atualizarQuestao(Questao questao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Questao buscarQuestao(Integer id) {
		EntityManager em = this.getEntityManager();
		try {
			return em.find(Questao.class, id);
		}
		catch (Exception ex) {
			throw ex;
		}
		finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public List<Questao> buscarQuestoes() {
		return this.buscarQuestoes(true, -1, -1);
	}

	@Override
	public List<Questao> buscarQuestoes(int maxResultados, int primeiroResultado) {
		return this.buscarQuestoes(false, maxResultados, primeiroResultado);
	}

	@SuppressWarnings("unchecked")	// q.getResultList()
	@Override
	public List<Questao> buscarQuestoes(boolean todos, int maxResultados, int primeiroResultado) {
		EntityManager em = this.getEntityManager();
		try {
			CriteriaQuery<Questao> cq = em.getCriteriaBuilder().createQuery(Questao.class);
			cq.select(cq.from(Questao.class));
			Query q = em.createQuery(cq);
			if (!todos) {
				q.setMaxResults(maxResultados);
				q.setFirstResult(primeiroResultado);
			}
			return q.getResultList();
		}
		finally {
			if (em != null) {
				em.close();
			}
		}
	}
	
	@Override
	public void excluirQuestao(Questao questao) {
		EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            if (!em.contains(questao)) {
            	questao = em.merge(questao);
            }
            em.remove(questao);
            em.getTransaction().commit();
        }
        catch (Exception ex) {
			throw ex;
		}
        finally {
            if (em != null) {
                em.close();
            }
        }		
	}
}
