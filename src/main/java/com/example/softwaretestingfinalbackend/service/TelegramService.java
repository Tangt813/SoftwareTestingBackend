package com.example.softwaretestingfinalbackend.service;


import com.example.softwaretestingfinalbackend.exception.FeeIllegalException;

import java.util.Collection;

public interface TelegramService {
    String thisMonthFee(double callTime, double notPayCount)throws FeeIllegalException;;

    Collection boundaryTest();

    Collection equivClassTest();
}
