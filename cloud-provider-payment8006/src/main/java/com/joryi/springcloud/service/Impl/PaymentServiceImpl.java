package com.joryi.springcloud.service.Impl;


import com.joryi.springcloud.dao.PaymentDao;
import com.joryi.springcloud.entities.Payment;
import com.joryi.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: com.joryi.spingcloud
 * @description: PaymentService实现类
 * @author: joryizhang
 * @create: 2021-10-15 17:48
 **/

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
