package ml.bondarev.m4bank.service;

import ml.bondarev.m4bank.entity.NumberEntity;
import ml.bondarev.m4bank.repository.NumberDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class NumberServiceImplTest {

    @TestConfiguration
    static class NumberServiceImplTestContextConfiguration {

        @Bean
        public NumberService numberService() {
            return new NumberServiceImpl();
        }
    }

    @Autowired
    private NumberService numberService;

    @MockBean
    private NumberDao numberDao;


    @Test
    public void addNumber() {
        NumberEntity number = new NumberEntity("Test", 1);

        Mockito.when(numberDao.save(number)).thenReturn(number);
    }

    @Test
    public void getSumNumberByName() {
        Mockito.when(numberDao.getValueNumberByName("Test1") + numberDao.getValueNumberByName("Test2"))
                .thenReturn(1);
    }

    @Test
    public void getNumberByName() {
        Mockito.when(numberDao.getNumberByName("Test1")).thenReturn(new NumberEntity("Test1", 1));
    }
}