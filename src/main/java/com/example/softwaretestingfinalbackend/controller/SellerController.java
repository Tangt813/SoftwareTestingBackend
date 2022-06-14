package com.example.softwaretestingfinalbackend.controller;

import com.example.softwaretestingfinalbackend.exception.SellerIllegalException;
import com.example.softwaretestingfinalbackend.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author Kerr
 * @project
 * @classname SellerController
 * @description TODO
 * @date 2021/5/10 10:17
 */
@CrossOrigin
@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    public SellerService sellerService;

    @PostMapping("/program")
    public String program(int hostNum, int monitorNum, int peripheralNum) {
        String result;
        try {
            double commission = sellerService.calculateCommission(hostNum, monitorNum, peripheralNum);
            result = Double.toString(commission);
        } catch (SellerIllegalException e) {
            result = e.getMessage();
        }
        return result;
    }

    @PostMapping("/programTest")
    public Collection programTest(String method, String data) {
        System.out.println(data);
        if (method.equals("boundary")) {
            return sellerService.boundaryTest();
        }
        return sellerService.equivClassTest();
    }

    @PostMapping("/boundaryTest")
    public Collection boundaryTest() {
        return sellerService.boundaryTest();
    }

    @PostMapping("/equivClassTest")
    public Collection equivClassTest() {
        return sellerService.equivClassTest();
    }

}
