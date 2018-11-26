package ml.bondarev.m4bank;

import ml.bondarev.m4bank.response.Response;
import ml.bondarev.m4bank.service.NumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class NumberController {

    @Autowired
    private NumberService numberService;

    private static final Logger log = LoggerFactory.getLogger(NumberController.class);


    @PostMapping(value = "/add")
    public Response addNumber(@ModelAttribute NumberEntity numberEntity) {
        log.info("The addNumber method was called. Name number: " + numberEntity.getName() + ", value number" +
                numberEntity.getValue());
        return numberService.addNumber(numberEntity);
    }

    @PostMapping(value = "/remove")
    public Response removeNumber(HttpServletRequest req) {
        log.info("The removeNumber method was called. Entity identifier: " + req.getParameter("name"));
        return numberService.removeNumber(req.getParameter("name"));
    }

    @PostMapping(value = "/sum")
    public Response getSumNumber(@RequestParam("name1") String nameNumber1,
                                 @RequestParam("name2") String nameNumber2) {
        log.info("The getSumNumber method was called. Summable entity: " + nameNumber1, ", " + nameNumber2);
        return numberService.getSumNumberByName(nameNumber1, nameNumber2);
    }

}
