package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author yqc
 * @date 2020/6/13 16:30
 */
@Repository
public class PaymentDao {

    private static final AtomicLong INCREMENT_PRIMARY_KEY = new AtomicLong(1);
    private static final Map<Long, Payment> PAYMENT_TABLE = new ConcurrentHashMap<>();

    public Integer create(Payment payment) {
        long id = INCREMENT_PRIMARY_KEY.getAndIncrement();
        try {
            PAYMENT_TABLE.put(id, payment.setId(id));
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }


    public Payment getPaymentById(Long id) {
        if(PAYMENT_TABLE.containsKey(id)){
            return PAYMENT_TABLE.get(id);
        }
        return null;
    }
}
