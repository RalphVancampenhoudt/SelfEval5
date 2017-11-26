package be.cegeka.trafficJam.domain.highways;

import be.cegeka.trafficJam.domain.users.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class HighwayTest {

    Highway testHighway;

    @Before
    public void setUp() throws Exception {
        testHighway = new Highway("E314",200);
        ReflectionTestUtils.setField(testHighway,"id",4);
    }

    @Test
    public void getId_shouldReturnCorrectId() throws Exception {
        assertThat(testHighway.getId()).isEqualTo(4);
    }

    @Test
    public void getName_shouldReturnCorrectName() throws Exception {
        assertThat((testHighway.getName())).isEqualTo("E314");
    }

    @Test
    public void getDistance_shouldReturnCorrectDistance() throws Exception {
        assertThat((testHighway.getDistance())).isEqualTo(200);
    }


    @Test
    public void equals_givenSameObject_shouldReturnTrue() throws Exception {
        assertThat(testHighway).isEqualTo(testHighway);
    }

    @Test
    public void equals_givenNullObject_isFalse() throws Exception {
        assertThat(testHighway).isNotEqualTo(null);
    }

    @Test
    public void equals_objectWithSameEverything_isTrue() throws Exception {
        Highway expected = new Highway("E314", 200);
        ReflectionTestUtils.setField(expected,"id",4);
        assertThat(testHighway).isEqualTo(expected);
    }

    @Test
    public void equals_otherClass_isFalse() throws Exception {
        assertThat(testHighway).isNotEqualTo(new Object());
    }

    @Test
    public void equals_objectWithOtherName_isFalse() throws Exception {
        Highway expected = new Highway("E40",200);
        assertThat(testHighway).isNotEqualTo(expected);
    }
    @Test
    public void equals_objectWithOtherId_isFalse() throws Exception {
        Highway expected = new Highway("E314",200);
        ReflectionTestUtils.setField(expected,"id",9);
        assertThat(testHighway).isNotEqualTo(expected);
    }

    @Test
    public void equals_objectWithNullName_isFalse() throws Exception {
        Highway expected = new Highway(null,200);
        assertThat(testHighway).isNotEqualTo(expected);
    }

}