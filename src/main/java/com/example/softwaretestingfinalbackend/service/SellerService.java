package com.example.softwaretestingfinalbackend.service;


import com.example.softwaretestingfinalbackend.exception.SellerIllegalException;

import java.util.Collection;

public interface SellerService {

    double calculateCommission(int hostNum, int monitorNum, int peripheralNum)  throws SellerIllegalException;

    Collection boundaryTest();

    Collection equivClassTest();
}
