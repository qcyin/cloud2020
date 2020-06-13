package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * @author yqc
 * @date 2020/6/13 16:21
 */
public interface PaymentService {

    /**
     * create payment
     * @param payment payment
     * @return id
     */
    Integer create(Payment payment);

    /**
     * fetch payment by id
     * @param id id
     * @return payment
     */
    Payment getPaymentById(Long id);
}
