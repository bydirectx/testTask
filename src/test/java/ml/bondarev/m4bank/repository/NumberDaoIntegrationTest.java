package ml.bondarev.m4bank.repository;

import ml.bondarev.m4bank.NumberDao;
import ml.bondarev.m4bank.NumberEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class NumberDaoIntegrationTest {

    @Autowired
    private NumberDao numberDao;

    @Test
    public void getNumberByName() {
        NumberEntity testNumber = numberDao.getNumberByName("Test");

        assertEquals(testNumber.getName(), "Test");
    }

    @Test
    public void getValueNumberByName() {
        int testValue = numberDao.getValueNumberByName("Test");

        numberDao.removeNumberEntityByName("Test");
        assertEquals(testValue, 1);
    }

    @Test
    public void removeNumberEntityByName() {
        numberDao.removeNumberEntityByName("Test");

        NumberEntity testNumberEntity = numberDao.getNumberByName("Test");
        assertEquals(null, testNumberEntity);

    }
}