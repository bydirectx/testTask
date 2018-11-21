package ml.bondarev.m4bank.controller;

import ml.bondarev.m4bank.codeError.Code;
import ml.bondarev.m4bank.entity.Number;
import ml.bondarev.m4bank.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

@RestController
public class NumberController {

    @Autowired
    private NumberService numberService;


    @PostMapping(value = "/add")
    public Map<String, String> addSumEntity(@ModelAttribute Number number) {
        Code codeRequest = numberService.addNumber(number);

        Map<String, String> res = new HashMap<>();
        res.put("code", codeRequest.getCode());
        res.put("description", codeRequest.getDescription());

        return res;
    }

    @PostMapping(value = "/remove")
    public Map<String, String> removeSumEntity(HttpServletRequest req) {
        Code codeRequest = numberService.removeNumber(parseInt(req.getParameter("numberId")));

        Map<String, String> res = new HashMap<>();
        res.put("code", codeRequest.getCode());
        res.put("description", codeRequest.getDescription());

        return res;
    }

    @PostMapping(value = "/sum")
    public Map<String, String> getSumEntity(@RequestParam("name1") String nameNumber1,
                             @RequestParam("name2") String nameNumber2) {

        return numberService.getSumNumberByName(nameNumber1, nameNumber2);
    }

}
