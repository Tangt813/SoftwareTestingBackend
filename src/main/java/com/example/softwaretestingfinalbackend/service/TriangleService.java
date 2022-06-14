package com.example.softwaretestingfinalbackend.service;


import com.example.softwaretestingfinalbackend.exception.TriangleIllegalException;

import java.util.Collection;

public interface TriangleService {

    String judgeType(double edgeA, double edgeB, double edgeC) throws TriangleIllegalException;

    Collection boundaryTest();

    Collection equivClassTest();

}
