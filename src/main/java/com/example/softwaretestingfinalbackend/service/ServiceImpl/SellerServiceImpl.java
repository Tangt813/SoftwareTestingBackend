package com.example.softwaretestingfinalbackend.service.ServiceImpl;

import com.example.softwaretestingfinalbackend.exception.SellerIllegalException;
import com.example.softwaretestingfinalbackend.service.SellerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Kerr
 * @project
 * @classname SellerServiceImpl
 * @description TODO
 * @date 2021/5/10 10:18
 */
@Service("SellerService")
public class SellerServiceImpl implements SellerService {
    @Override
    public double calculateCommission(int hostNum, int monitorNum, int peripheralNum) throws SellerIllegalException {
        final int hostPrice = 25;
        final int monitorPrice = 30;
        final int peripheralPrice = 45;
        if (hostNum <= 0 || monitorNum <= 0 || peripheralNum <= 0 || hostNum > 70 || monitorNum > 80 || peripheralNum > 90) {
            throw new SellerIllegalException("The number of items is illegal.");

        }
        int total = hostPrice * hostNum + monitorPrice * monitorNum + peripheralPrice * peripheralNum;
        if (total <= 1000) {
            return total * 0.1;
        } else if (total <= 1800) {
            return total * 0.15;
        } else {
            return total * 0.2;
        }
    }

    @Override
    public Collection boundaryTest() {
        Object[][] testcases = {
                {"InputSide1", -2, 40, 54, "The number of items is illegal."},
                {"InputSide2", 1, 35, 56, 719.0},
                {"InputSide3", 3, 38, 35, 558.0},
                {"InputSide4", 68, 47, 65, 1207.0},
                {"InputSide5", 70, 60, 76, 1394.0},
                {"InputSide6", 72, 44, 56, "The number of items is illegal."},
                {"InputSide7", 35, -2, 45, "The number of items is illegal."},
                {"InputSide8", 26, 1, 34, 442.0},
                {"InputSide9", 35, 3, 54, 679.0},
                {"InputSide10", 45, 78, 76, 1377.0},
                {"InputSide11", 43, 80, 56, 1199.0},
                {"InputSide12", 34, 88, 45, "The number of items is illegal."},
                {"InputSide13", 28, 56, -3, "The number of items is illegal."},
                {"InputSide14", 29, 45, 1, 424.0},
                {"InputSide15", 34, 56, 4, 542.0},
                {"InputSide16", 33, 76, 45, 1026.0},
                {"InputSide17", 36, 55, 88, 1302.0},
                {"InputSide18", 32, 66, 90, 1366.0},
                {"InputSide19", 40, 45, 92, "The number of items is illegal."},
                {"OutputSide1", 1, 0, 1, "The number of items is illegal."},
                {"OutputSide2", 1, 1, 1, 10.0},
                {"OutputSide3", 1, 1, 2, 14.5},
                {"OutputSide4", 3, 7, 5, 51.0},
                {"OutputSide5", 8, 10, 11, 99.5},
                {"OutputSide6", 10, 10, 10, 100.0},
                {"OutputSide7", 11, 10, 10, 153.75},
                {"OutputSide8", 14, 15, 16, 228.0},
                {"OutputSide9", 22, 14, 18, 267.0},
                {"OutputSide10", 18, 18, 18, 270.0},
                {"OutputSide11", 18, 23, 15, 363.0},
                {"OutputSide12", 30, 45, 66, 1014.0}
        };

        Object[][] results = new Object[testcases.length+1][6];
        for (int i = 0; i < 19; i++) {
            int host = (int) testcases[i][1];
            int monitor = (int) testcases[i][2];
            int peripheral = (int) testcases[i][3];
            String expected = testcases[i][4].toString();

            results[i][0] = testcases[i][0];
            results[i][1] = host;
            results[i][2] = monitor;
            results[i][3] = peripheral;
            results[i][4] = expected;
            try {
                results[i][5] = calculateCommission(host, monitor, peripheral);
            } catch (SellerIllegalException e) {
                results[i][5]=e.getMessage();
            }
        }
        results[19][0]="";
        results[19][1]="";
        results[19][2]="";
        results[19][3]="";
        results[19][4]="";
        results[19][5]="";
        for (int i = 19; i < testcases.length; i++) {
            int host = (int) testcases[i][1];
            int monitor = (int) testcases[i][2];
            int peripheral = (int) testcases[i][3];
            String expected = testcases[i][4].toString();

            results[i+1][0] = testcases[i][0];
            results[i+1][1] = host;
            results[i+1][2] = monitor;
            results[i+1][3] = peripheral;
            results[i+1][4] = expected;
            try {
                results[i+1][5] = calculateCommission(host, monitor, peripheral);
            } catch (SellerIllegalException e) {
                results[i+1][5]=e.getMessage();
            }
        }
        return Arrays.asList(results);
    }


    @Override
    public Collection equivClassTest() {
        return new ArrayList();
    }
}
