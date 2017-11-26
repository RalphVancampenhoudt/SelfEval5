package be.cegeka.trafficJam.domain.users;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.*;

public class UserTest {

    User testUser;

    @Before
    public void setUp() throws Exception {
        testUser = new User("Ralph");
        ReflectionTestUtils.setField(testUser,"id",4);
    }

    @Test
    public void getId_shouldReturnCorrectId() throws Exception {
        assertThat(testUser.getId()).isEqualTo(4);
    }
    @Test
    public void getName_shouldReturnCorrectName() throws Exception {
        assertThat((testUser.getName())).isEqualTo("Ralph");
    }

    @Test
    public void equals_givenSameObject_shouldReturnTrue() throws Exception {
        assertThat(testUser).isEqualTo(testUser);
    }

    @Test
    public void equals_givenNullObject_isFalse() throws Exception {
        assertThat(testUser).isNotEqualTo(null);
    }

    @Test
    public void equals_objectWithSameEverything_isTrue() throws Exception {
        User expected = new User("Ralph");
        ReflectionTestUtils.setField(expected,"id",4);
        assertThat(testUser).isEqualTo(expected);
    }

    @Test
    public void equals_otherClass_isFalse() throws Exception {
        assertThat(testUser).isNotEqualTo(new Object());
    }

    @Test
    public void equals_objectWithOtherName_isFalse() throws Exception {
        User expected = new User("Seppe");
        assertThat(testUser).isNotEqualTo(expected);
    }
    @Test
    public void equals_objectWithOtherId_isFalse() throws Exception {
        User expected = new User("Ralph");
        ReflectionTestUtils.setField(expected,"id",9);
        assertThat(testUser).isNotEqualTo(expected);
    }

    @Test
    public void equals_objectWithNullName_isFalse() throws Exception {
        User expected = new User(null);
        assertThat(testUser).isNotEqualTo(expected);
    }

}