package ml.bondarev.m4bank.service;

import ml.bondarev.m4bank.NumberEntity;
import ml.bondarev.m4bank.response.Response;
import org.springframework.stereotype.Controller;

@Controller
public interface NumberService {

    public Response addNumber(NumberEntity numberEntity);

    public Response removeNumber(String name);

    public Response getSumNumberByName(String name1, String name2);

}
