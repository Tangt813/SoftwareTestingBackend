package com.example.softwaretestingfinalbackend.service.ServiceImpl;

import com.example.softwaretestingfinalbackend.exception.TriangleIllegalException;
import com.example.softwaretestingfinalbackend.service.TriangleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Y.C.Young
 * @project Software Testing
 * @classname TriangleServiceImpl
 * @description TODO
 * @date 2021/5/24 14:27
 */
@Service("TriangleService")
public class TriangleServiceImpl implements TriangleService {

    @Override
    public String judgeType(double edgeA, double edgeB, double edgeC) throws TriangleIllegalException {
        double maxEdge = Math.max((Math.max(edgeA, edgeB)), edgeC);
        double minEdge = Math.min((Math.min(edgeA, edgeB)), edgeC);
        edgeB = edgeA + edgeB + edgeC - minEdge - maxEdge;
        edgeA = minEdge;
        edgeC = maxEdge;
        if (edgeA <= 0) {
            throw new TriangleIllegalException("Some edges are not positive.");
        }
        if (edgeA + edgeB <= edgeC) {
            throw new TriangleIllegalException("The edges don't form a triangle.");
        }
        if (edgeA == edgeB && edgeA == edgeC) {
            return "equilateral triangle";
        }
        if (edgeA == edgeB || edgeA == edgeC || edgeB == edgeC) {
            return "isosceles triangle";
        }
        return "scalene triangle";
    }


    @Override
    public Collection boundaryTest() {
        Object[][] testcases = {
                {"B1", -1.0, 14.0, 18.0, "Some edges are not positive."},
                {"B2", 0.0, 244.0, 266.0, "Some edges are not positive."},
                {"B3", 1.0, 24.0, 4379.0, "The edges don't form a triangle."},
                {"B4", 20.5, -2.0, 200.0, "Some edges are not positive."},
                {"B5", 500.5, 0.0, 500.5, "Some edges are not positive."},
                {"B6", 100.0, 0.5, 600.0, "The edges don't form a triangle."},
                {"B7", 7.0, 11.0, -0.5, "Some edges are not positive."},
                {"B8", 10.0, 2.0, 0.0, "Some edges are not positive."},
                {"B9", 3.0, 3.0, 2.0, "isosceles triangle"},
                {"B10", 54.6, 54.6, 54.6, "equilateral triangle"},
        };

        Object[][] results = new Object[testcases.length][6];
        for (int i = 0; i < testcases.length; i++) {
            double edgeA = (double) testcases[i][1];
            double edgeB = (double) testcases[i][2];
            double edgeC = (double) testcases[i][3];
            String expected = (String) testcases[i][4];

            results[i][0] = testcases[i][0];
            results[i][1] = edgeA;
            results[i][2] = edgeB;
            results[i][3] = edgeC;
            results[i][4] = expected;
            try {
                results[i][5] = judgeType(edgeA, edgeB, edgeC);
            } catch (TriangleIllegalException e) {
                results[i][5] = e.getMessage();
            }
        }
        return Arrays.asList(results);
    }


    @Override
    public Collection equivClassTest() {
        Object[][] testcases = {
                {"B1", 8.0, 8.0, 8.0, "equilateral triangle"},
                {"B2", 3.3, 4.4, 3.3, "isosceles triangle"},
                {"B3", 5.0, 6.0, 7.0, "scalene triangle"},
                {"B4", 20.5, 10.0, 10.0, "The edges don't form a triangle."},
                {"B5", -0.5, 459.0, 460.0, "Some edges are not positive."},
                {"B6", 0.0, 69.5, 69.0, "Some edges are not positive."},
                {"B7", 7.0, -1.0, 6.5, "Some edges are not positive."},
                {"B8", 10.0, 0.0, 8.0, "Some edges are not positive."},
                {"B9", 3.0, 3.0, -2.0, "Some edges are not positive."},
                {"B10", 54.6, 64.6, 0.0, "Some edges are not positive."},
                {"B11", -0.5, -0.6, 2.0, "Some edges are not positive."},
                {"B12", 0.0, 6.5, -1.2, "Some edges are not positive."},
                {"B13", 7.0, 0.0, 0.0, "Some edges are not positive."},
                {"B14", 0.0, 0.0, 0.0, "Some edges are not positive."},
                {"B15", -3.0, -3.0, -3.0, "Some edges are not positive."},
        };

        Object[][] results = new Object[testcases.length][6];
        for (int i = 0; i < testcases.length; i++) {
            double edgeA = (double) testcases[i][1];
            double edgeB = (double) testcases[i][2];
            double edgeC = (double) testcases[i][3];
            String expected = (String) testcases[i][4];

            results[i][0] = testcases[i][0];
            results[i][1] = edgeA;
            results[i][2] = edgeB;
            results[i][3] = edgeC;
            results[i][4] = expected;
            try {
                results[i][5] = judgeType(edgeA, edgeB, edgeC);
            } catch (TriangleIllegalException e) {
                results[i][5] = e.getMessage();
            }
        }
        return Arrays.asList(results);
    }
}
