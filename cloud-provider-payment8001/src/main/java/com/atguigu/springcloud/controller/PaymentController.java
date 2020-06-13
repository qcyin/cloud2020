package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yqc
 * @date 2020/6/13 16:18
 */

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @PostMapping("/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if(result > 0){
            return new CommonResult<>(200, "新增成功", result);
        }else {
            return new CommonResult<>(444, "新增失败");
        }
    }


    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if(payment == null){
            return new CommonResult<>(444, "没有对应的记录");
        }else {
            return new CommonResult<>(200, "查询成功", payment);
        }
    }
}
