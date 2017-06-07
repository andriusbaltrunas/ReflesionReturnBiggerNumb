package com.andrius.baltrunas.example;

import com.andrius.baltrunas.annotation.DoubleNum;
import com.andrius.baltrunas.impl.SimpleExample;
import com.sun.istack.internal.Nullable;

/**
 * Created by andriusbaltrunas on 6/6/2017.
 */
public class FirstClass implements SimpleExample{

    @DoubleNum(number = 200)
    @Override
    public int sum(int numb1, int numb2) {
        return numb1 + numb2;
    }
}
