package ml.bondarev.m4bank.controller;

import ml.bondarev.m4bank.entity.Number;
import ml.bondarev.m4bank.service.NumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static java.lang.Integer.parseInt;

@RestController
public class NumberController {

    @Autowired
    private NumberService numberService;

    private static final Logger log = LoggerFactory.getLogger(NumberController.class);


    @PostMapping(value = "/add")
    public Map<String, String> addNumber(@ModelAttribute Number number) {
        log.info("The addNumber method was called. Model: " + number);
        return numberService.addNumber(number);
    }

    @PostMapping(value = "/remove")
    public Map<String, String> removeNumber(HttpServletRequest req) {
        log.info("The removeNumber method was called. Entity identifier: " + req.getParameter("numberId"));
        return numberService.removeNumber(parseInt(req.getParameter("numberId")));
//        return numberService.removeNumber(req.getParameter("name"));
    }

    @PostMapping(value = "/sum")
    public Map<String, String> getSumNumber(@RequestParam("name1") String nameNumber1,
                                            @RequestParam("name2") String nameNumber2) {
        log.info("The getSumNumber method was called. Summable entity: " + nameNumber1, ", " + nameNumber2);
        return numberService.getSumNumberByName(nameNumber1, nameNumber2);
    }

}
