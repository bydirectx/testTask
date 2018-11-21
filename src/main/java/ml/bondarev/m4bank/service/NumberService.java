package ml.bondarev.m4bank.service;

import ml.bondarev.m4bank.entity.Number;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public interface NumberService {

    public Map<String, String> addNumber(Number number);

    public Map<String, String> removeNumber(int numberId);

    public Map<String, String> getSumNumberByName(String name1, String name2);

    public Number getNumberByName(String name);
}
