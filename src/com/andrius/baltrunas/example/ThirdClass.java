package com.andrius.baltrunas.example;

import com.andrius.baltrunas.annotation.DoubleNum;
import com.andrius.baltrunas.impl.SimpleExample;

/**
 * Created by andriusbaltrunas on 6/6/2017.
 */
public class ThirdClass implements SimpleExample{

    @DoubleNum()
    @Override
    public int sum(int numb1, int numb2) {
        return numb1 + numb2;
    }
}
