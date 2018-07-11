package com.ngls.girl.service;


import com.ngls.girl.domain.Girl;
import com.ngls.girl.exception.GirlException;
import com.ngls.girl.respository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    GirlRepository girlRepository;


    @Transactional//事务 全部成功过才是成功
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(20);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(23);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            //返回你还在上小学
            throw new GirlException("你还在上小学吧", 100);

        } else if (age > 10 && age < 16) {
            //返回你可能在上初中
            throw new GirlException("你还在上初中吧", 101);
        }
    }
}
