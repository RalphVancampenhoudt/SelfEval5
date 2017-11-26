package be.cegeka.trafficJam.domain.highways;

import be.cegeka.trafficJam.domain.HighwayApplication;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = HighwayApplication.class)
@Transactional
public class HighwayRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private HighwayRepository highwayRepository;

    private Highway E314, E40;

    @Before
    public void setUp() throws Exception {
        E314 = new Highway("E314", 200);
        ReflectionTestUtils.setField(E314,"id",1);

        E40 = new Highway("E40",200);
        ReflectionTestUtils.setField(E40,"id",2);
        entityManager.persist(E40);
    }

    @Test
    public void addHighway_shouldAddHighway() throws Exception {
            highwayRepository.addHighway(E314);
        Assertions.assertThat(highwayRepository.getHighwayByID(1));
    }

    @Test
    public void getHighwayByID_givenId_shouldGReturnHighway() throws Exception {
        Assertions.assertThat(highwayRepository.getHighwayByID(2)).isEqualTo(E40);
    }

    @After
    public void cleanDataBaseForNextTest(){
        entityManager.clear();
    }
}