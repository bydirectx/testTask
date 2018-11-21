package ml.bondarev.m4bank.service;

import ml.bondarev.m4bank.code.Code;
import ml.bondarev.m4bank.entity.Number;
import ml.bondarev.m4bank.repository.NumberDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AopInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NumberServiceImpl implements NumberService {

    @Autowired
    private NumberDao numberDao;

    private static final Logger log = LoggerFactory.getLogger(NumberServiceImpl.class);


    @Override
    public Map<String, String> addNumber(Number number) {
        Map<String, String> res = new HashMap<>();
        Code resultCode = null;

        try {
            Number testNumber = numberDao.getNumberByName(number.getName());

            numberDao.save(number);
            resultCode = Code.Created;

            log.info("Entity added successfully. Code: " + resultCode.getCode());
        } catch (IncorrectResultSizeDataAccessException ex) {
            resultCode = Code.AlreadyBeenCreated;
        } catch (Exception ex) {
            resultCode = Code.NotConnect;
        } finally {
            res.put("code", resultCode.getCode());
            res.put("description", resultCode.getDescription());

            return res;
        }
    }

    @Override
    public Map<String, String> removeNumber(int numberId) {
        Map<String, String> res = new HashMap<>();
        Code resultCode = null;

        try {
            numberDao.deleteById(numberId);
            resultCode = Code.Removed;

            log.info("Entity deleted successfully. Code: " + resultCode.getCode());
        } catch (EmptyResultDataAccessException er) {
            resultCode = Code.NotInDatabase;
        } catch (Exception ex) {
            resultCode = Code.NotFoundException; // Test
        } finally {
            res.put("code", resultCode.getCode());
            res.put("description", resultCode.getDescription());

            return res;
        }
    }

    @Override
    public Map<String, String> getSumNumberByName(String name1, String name2) {
        Map<String, String> res = new HashMap<>();
        Code resultCode = null;
        Integer result = null;

        try {
            if (name1.equals(name2)) {
                resultCode = Code.SameParameters;

                throw new Exception("The addition parameters are the same.");
            }

            result = (numberDao.getValueNumberByName(name1) +
                    numberDao.getValueNumberByName(name2));
            resultCode = Code.AddSuccessful;

            log.info("Entity amount returned. Code: " + resultCode.getCode() + ", sum: " + result);
        } catch (AopInvocationException ex) {
            resultCode = Code.AlreadyBeenCreated;
        } finally {
            res.put("code", resultCode.getCode());
            res.put("description", resultCode.getDescription());

            if (result == null) {

            } else {
                res.put("result", Integer.toString(result));
            }

            return res;
        }
    }

    @Override
    public Number getNumberByName(String name) {
        return numberDao.getNumberByName(name);
    }

}
