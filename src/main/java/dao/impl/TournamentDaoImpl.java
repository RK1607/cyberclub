package dao.impl;

import dao.TournamentDao;
import entity.Tournament;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TournamentDaoImpl implements TournamentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Tournament> getAll() {
        Query query = entityManager.createQuery("SELECT t FROM Tournament t", Tournament.class);
        return query.getResultList();
    }
}
