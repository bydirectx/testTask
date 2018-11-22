package ml.bondarev.m4bank.repository;

import ml.bondarev.m4bank.entity.NumberEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class NumberEntityDaoIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private NumberDao numberDao;

    @Test
    public void getNumberByName() {
        NumberEntity testNumber = numberDao.getNumberByName("Test");
        if (testNumber == null) {
            NumberEntity number = new NumberEntity();
            number.setName("Test");
            number.setValue(1);

            testNumber = numberDao.save(number);
        }

        assertEquals(testNumber.getName(), "Test");
    }

    @Test
    public void getValueNumberByName() {
        NumberEntity testNumber = null;
        int testValue = numberDao.getValueNumberByName("Test");
        if (testValue != 1) {
            NumberEntity number = new NumberEntity();
            number.setName("Test");
            number.setValue(1);

            testValue = numberDao.save(number).getValue();
        }

        assertEquals(testValue, 1);
    }
}