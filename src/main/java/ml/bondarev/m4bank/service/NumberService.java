package ml.bondarev.m4bank.service;

import ml.bondarev.m4bank.entity.NumberEntity;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public interface NumberService {

    public Map<String, String> addNumber(NumberEntity numberEntity);

    public Map<String, String> removeNumber(int numberId);

    public Map<String, String> getSumNumberByName(String name1, String name2);

    public NumberEntity getNumberByName(String name);
}
