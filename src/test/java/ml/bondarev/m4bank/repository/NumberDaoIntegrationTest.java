package ml.bondarev.m4bank.repository;

import ml.bondarev.m4bank.entity.NumberEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class NumberDaoIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private NumberDao numberDao;

    @Test
    public void getNumberByName() {
        NumberEntity testNumber = numberDao.getNumberByName("Test");
        if (testNumber == null) {
            NumberEntity number = new NumberEntity("Test", 1);

            numberDao.save(number);
            testNumber = numberDao.getNumberByName("Test");

        }

        assertEquals(testNumber.getName(), "Test");
    }

    @Test
    public void getValueNumberByName() {
        Integer testValue = numberDao.getValueNumberByName("Test");
        if (testValue == null) {
            NumberEntity number = new NumberEntity("Test", 1);

            numberDao.save(number);
            testValue = numberDao.getValueNumberByName("Test");
        }

        assertEquals(testValue, new Integer(0));
    }
}