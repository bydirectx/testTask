package ml.bondarev.m4bank.service;

import ml.bondarev.m4bank.Code;
import ml.bondarev.m4bank.NumberEntity;
import ml.bondarev.m4bank.response.ResponseCode;
import ml.bondarev.m4bank.response.ResponseParameter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class NumberServiceImplIntegrationTest {

    @Autowired
    private NumberService numberService;

    @Test
    public void addNumber() {
        NumberEntity numberEntity1 = new NumberEntity("IT entity 1", 2);

        NumberEntity numberEntity2 = new NumberEntity("IT entity 2", 4);

        ResponseCode res1 = (ResponseCode) numberService.addNumber(numberEntity1);
        ResponseCode res2 = (ResponseCode) numberService.addNumber(numberEntity2);

        assertThat(res1).isNotNull();
        assertThat(res2).isNotNull();

        assertEquals(res1.getCode(), Code.OK.getCode());
        assertEquals(res2.getCode(), Code.OK.getCode());

        System.out.println("Code 1: " + res1.getCode() + ", code 2: " + res2.getCode());
    }

    @Test
    public void getSumNumberByName() {
        ResponseParameter res = (ResponseParameter) numberService.getSumNumberByName("Test entity 3", "Test entity 4");

        assertThat(res).isNotNull();
        assertEquals(res.getCode(), Code.OK.getCode());
        assertEquals(res.getSum(), 7);
        System.out.println("Code: " + res.getCode());
    }

    @Test
    public void removeNumber() {
        ResponseCode res = (ResponseCode) numberService.removeNumber("Test entity 1");
        assertThat(res).isNotNull();
        System.out.println("Code: " + res.getCode());
        assertEquals(res.getCode(), Code.OK.getCode());

        res = (ResponseCode) numberService.removeNumber("Test entity 2");
        assertThat(res).isNotNull();
        System.out.println("Code: " + res.getCode());
        assertEquals(res.getCode(), Code.OK.getCode());
    }
}