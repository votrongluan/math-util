package com.votrongluan.mathutil.core;

public class MathUtil {
    // trong class này cung cấp ra ngoài nhiều hàm xử lý toán học
    // clone class Math của JDK
    // Hàm thư viện xài chung cho ai đó, ko cần lưu trạng thái/giá trị
    // chọn thiết kế là hàm static

    // Hàm tính giai thừa!!!
    // n! = 1.2...n
    // không có giai thừa âm
    // 0! = 1! = 1
    // giai thừa hàm đồ thị dốc đứng, tăng nhanh về giá trị
    // 20 giai thừa 18 con số 0, vừa kịp đủ cho kiểu long của Java
    // 21 giai thừa tràn kiểu long bài này quy ước n [0..20]
    public static long getFactorial(int n) {
        if (n < 0 || n > 20) {
            throw new IllegalArgumentException("Invalid argument. N must "
                    + "be between 0..20");
        }

        if (n == 0 || n == 1) {
            return 1;
        }
        
        long product = 1;
        for (int i = 2; i <= n; i++) {
            product *= i;
        }
        
        return product;
    }
}
