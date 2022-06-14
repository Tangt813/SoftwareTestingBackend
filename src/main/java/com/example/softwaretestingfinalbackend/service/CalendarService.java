package com.example.softwaretestingfinalbackend.service;


import com.example.softwaretestingfinalbackend.exception.DateIllegalException;

import java.util.Collection;

/**
 * @ClassName CalendarService
 * @Description TODO
 * @Author Brian.Z
 * @Date 2021/5/9 10:29
 */
public interface CalendarService {

    String nextDate(int year, int month, int day) throws DateIllegalException;

    Collection boundaryTest();

    Collection equivClassTest();
}
