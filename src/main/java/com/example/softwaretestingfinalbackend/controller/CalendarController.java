package com.example.softwaretestingfinalbackend.controller;

import com.example.softwaretestingfinalbackend.exception.DateIllegalException;
import com.example.softwaretestingfinalbackend.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @ClassName CalendarController
 * @Description TODO
 * @Author Brian.Z
 * @Date 2021/5/9 10:14
 */
@CrossOrigin
@RestController
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    public CalendarService calendarService;

    /*
    @PostMapping("/searchByDay")
    public String searchByDay(String year, String month, String day) {

        System.out.println(year + month + day);

        String actual;
        try {
            actual = calendarService.nextDate(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        } catch (DateIllegalException e) {
            actual = e.getMessage();
        }
        return actual;
    }
    */

    @PostMapping("/program")
    public String program(int year, int month, int day) {

        String actual;
        try {
            actual = calendarService.nextDate(year, month, day);
        } catch (DateIllegalException e) {
            actual = e.getMessage();
        }
        return actual;
    }

    @PostMapping("/programTest")
    public Collection programTest(String method, String data) {
        System.out.println(data);
        if (method.equals("boundary")) {
            return calendarService.boundaryTest();
        }
        return calendarService.equivClassTest();
    }

    @PostMapping("/boundaryTest")
    public Collection boundaryTest() {
        return calendarService.boundaryTest();
    }

    @PostMapping("/equivClassTest")
    public Collection equivClassTest() {
        return calendarService.equivClassTest();
    }
}
