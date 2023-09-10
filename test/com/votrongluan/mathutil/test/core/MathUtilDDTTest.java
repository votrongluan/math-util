package com.votrongluan.mathutil.test.core;

import com.votrongluan.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

// câu lệnh này của JUnit báo hiệu rằng sẽ cần loop qua tập data để 
// lấy cặp data input / expected nhồi vào hàm test
@RunWith(value = Parameterized.class)
public class MathUtilDDTTest {

    // ta sẽ trả về mảng 2 chiều gồm nhiều cặp Expected | Input                              
    @Parameterized.Parameters // JUnit sẽ ngầm chạy loop qua từng dòng của mảng
    // để lấy ra được cặp data input / expected tên hàm ko quan trọng,
    // quan trọng là @
    public static Object[][] initData() {
        return new Integer[][]{
            {0, 1},
            {1, 1},
            {2, 2},
            {3, 6},
            {4, 24},
            {5, 720}
        };
    }

    // giả sử loop qua từng dòng của mảng, ta vẫn cần gán từng value của cột
    // vào trong biến tương ứng input, expected để lát hồi feed cho cái hàm
    @Parameterized.Parameter(value = 0) // value = 0 là map với mảng data 
    public int n; // biến map với value của cột 0 của mảng

    @Parameterized.Parameter(value = 1)
    public long expected; // kiểu long vì giá trị trả về của hàm getF() là long

    @Test
    public void testGetFactorialGivenRightArgumentReturnsWell() {
        Assert.assertEquals(expected, MathUtil.getFactorial(n));
    }
}
