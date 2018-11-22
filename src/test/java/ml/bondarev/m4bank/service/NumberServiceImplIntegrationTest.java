package ml.bondarev.m4bank.service;

import ml.bondarev.m4bank.entity.NumberEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberServiceImplIntegrationTest {

    @Autowired
    private NumberService numberService;

    @Test
    public void addNumber() {
        NumberEntity numberEntity1 = new NumberEntity("IT entity 1", 2);

        NumberEntity numberEntity2 = new NumberEntity("IT entity 2", 4);

        Map<String, String> res1 = numberService.addNumber(numberEntity1);
        Map<String, String> res2 = numberService.addNumber(numberEntity2);

        assertThat(res1).isNotNull().isNotEmpty();
        assertThat(res2).isNotNull().isNotEmpty();

        System.out.println("Code: " + res1.get("code") + ", " + res2.get("code"));
    }

    @Test
    public void getSumNumberByName() {
        Map<String, String> res = numberService.getSumNumberByName("IT entity 1", "IT entity 2");

        assertThat(res).isNotNull().isNotEmpty();
        System.out.println("Code: " + res.get("code"));
    }

    @Test
    public void removeNumber() {
        Map<String, String> res = numberService.removeNumber(numberService.getNumberByName("IT entity 1").getId());
        assertThat(res).isNotNull().isNotEmpty();
        System.out.println("Code: " + res.get("code"));

        res = numberService.removeNumber(numberService.getNumberByName("IT entity 2").getId());
        assertThat(res).isNotNull().isNotEmpty();
        System.out.println("Code: " + res.get("code"));
    }
}