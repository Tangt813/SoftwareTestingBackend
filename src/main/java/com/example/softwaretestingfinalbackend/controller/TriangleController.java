package com.example.softwaretestingfinalbackend.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.example.softwaretestingfinalbackend.exception.TriangleIllegalException;
import com.example.softwaretestingfinalbackend.service.TriangleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Y.C.Young
 * @project Software Testing
 * @classname TriangleController
 * @description TODO
 * @date 2021/5/24 14:20
 */
@CrossOrigin
@RestController
@RequestMapping("/triangle")
public class TriangleController {

    @Autowired
    public TriangleService triangleService;

    @PostMapping("/program")
    public String program(double edgeA, double edgeB, double edgeC) {

        String actual;
        try {
            actual = triangleService.judgeType(edgeA, edgeB, edgeC);
        } catch (TriangleIllegalException e) {
            actual = e.getMessage();
        }
        return actual;
    }


    @PostMapping("/programTest")
    public Collection programTest(String method, String data) {
        System.out.println(data);
        JSONArray jsonArray=new JSONArray(data);

        if (method.equals("boundary")) {
            return triangleService.boundaryTest();
        }
        return triangleService.equivClassTest();
    }

    @PostMapping("/boundaryTest")
    public Collection boundaryTest() {
        return triangleService.boundaryTest();
    }

    @PostMapping("/equivClassTest")
    public Collection equivClassTest() {
        return triangleService.equivClassTest();
    }

}
