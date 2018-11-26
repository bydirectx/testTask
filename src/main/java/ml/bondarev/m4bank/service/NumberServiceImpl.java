package ml.bondarev.m4bank.service;

import ml.bondarev.m4bank.Code;
import ml.bondarev.m4bank.NumberDao;
import ml.bondarev.m4bank.NumberEntity;
import ml.bondarev.m4bank.response.Response;
import ml.bondarev.m4bank.response.ResponseCode;
import ml.bondarev.m4bank.response.ResponseParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AopInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

@Service
public class NumberServiceImpl implements NumberService {

    @Autowired
    private NumberDao numberDao;

    private static final Logger log = LoggerFactory.getLogger(NumberServiceImpl.class);


    @Override
    public Response addNumber(NumberEntity numberEntity) {
        try {
            NumberEntity number = numberDao.getNumberByName(numberEntity.getName());
            if (number != null) {
                return new ResponseCode(Code.ALREADY_BEEN_CREATED);
            }

            numberDao.save(numberEntity);

            log.info("Entity added successfully. Code: " + Code.OK + ", name: " + number.getName());
            return new ResponseCode(Code.OK);
        } catch (Exception ex) {
            return new ResponseCode(Code.NOT_FOUND_EXCEPTION);
        }
    }

    @Override
    public Response removeNumber(String name) {
        try {
            NumberEntity number = numberDao.getNumberByName(name);
            numberDao.delete(number);

            log.info("Entity deleted successfully. Code: " + Code.OK + ", name: " + name);
            return new ResponseCode(Code.OK);
        } catch (InvalidDataAccessApiUsageException er) {
            return new ResponseCode(Code.NOT_IN_DATABASE);
        } catch (Exception ex) {
            return new ResponseCode(Code.NOT_FOUND_EXCEPTION);
        }
    }

    @Override
    public Response getSumNumberByName(String name1, String name2) {
        try {
            int sum = ((numberDao.getValueNumberByName(name1) +
                    numberDao.getValueNumberByName(name2)));

            log.info("Entity amount returned. Code: " + Code.OK.getCode() + ", sum: " + sum);
            return new ResponseParameter(Code.OK, sum);
        } catch (AopInvocationException ex) {
            return new ResponseCode(Code.NOT_IN_DATABASE);
        } catch (Exception ex) {
            return new ResponseCode(Code.NOT_FOUND_EXCEPTION);
        }
    }
}
