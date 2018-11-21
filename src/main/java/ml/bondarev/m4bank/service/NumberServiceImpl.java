package ml.bondarev.m4bank.service;

import ml.bondarev.m4bank.codeError.Code;
import ml.bondarev.m4bank.entity.Number;
import ml.bondarev.m4bank.repository.NumberDao;
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

    @Override
    public Code addNumber(Number number) {
        try {
            Number testNumber = numberDao.getNumberByName(number.getName());

            numberDao.save(number);
            return Code.Created;
        } catch (IncorrectResultSizeDataAccessException ex) {
            return Code.AlreadyBeenCreated;
        } catch (Exception ex) {
            return Code.NotConnect;
        }
    }

    @Override
    public Code removeNumber(int numberId) {
        try {
            numberDao.deleteById(numberId);
            return Code.Removed;
        } catch (EmptyResultDataAccessException er) {
            return Code.NotInDatabase;
        }
    }

    @Override
    public Map<String, String> getSumNumberByName(String name1, String name2) {
        Map<String, String> res = new HashMap<>();
        Code resultCode = null;
        Integer result = null;

//        res.put("value", Integer.toString(numberDao.getValueNumberByName(name1) + numberDao.getValueNumberByName(name2)));
//
//        return res;


        try {
            if (name1.equals(name2)) {
                resultCode = Code.SameParameters;

                throw new Exception("The addition parameters are the same.");
            }

            result = (numberDao.getValueNumberByName(name1) +
                    numberDao.getValueNumberByName(name2));
            resultCode = Code.AddSuccessful;
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
