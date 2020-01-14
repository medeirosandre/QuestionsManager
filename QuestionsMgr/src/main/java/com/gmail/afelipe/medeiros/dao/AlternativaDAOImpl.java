package com.gmail.afelipe.medeiros.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.gmail.afelipe.medeiros.dao.util.JPAUtil;
import com.gmail.afelipe.medeiros.modelo.Alternativa;

public class AlternativaDAOImpl implements AlternativaDAO {
	
	public EntityManager getEntityManager() {
		return JPAUtil.EMF.createEntityManager();
	}
	
	@Override
	public Alternativa adicionarAlternativa(Alternativa alternativa) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(alternativa);
			em.flush();
			em.getTransaction().commit();
			return alternativa;
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
	public List<Alternativa> listarAlternativas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluirAlternativa(Alternativa alternativa) {
		EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(alternativa);
            em.flush();
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
