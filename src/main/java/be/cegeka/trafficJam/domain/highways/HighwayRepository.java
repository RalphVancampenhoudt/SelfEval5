package be.cegeka.trafficJam.domain.highways;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class HighwayRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Highway getHighwayByID(int id){
        return entityManager.find(Highway.class,id);
    }

    public Highway addHighway(Highway highwayToAdd){
        entityManager.persist(highwayToAdd);
        return highwayToAdd;
    }
}
