package com.votrongluan.mathutil.main;

import com.votrongluan.mathutil.core.MathUtil;

public class Main {

    public static void main(String[] args) {
        // thử nghiệm hàm tính giai thừa coi chạy đúng như thiết kế hay không
        // ta phải đưa ra các tình huống sử dụng hàm trong thực tế
        // ví dụ: -5 coi tính được hok
        //        0 coi tính mấy
        //       20 coi tính mấy
        //       21 coi tính ra mấy
        // TEST CASE: Một tình huống sử dụng, xài app hay xài hàm 
        // giả lập hành vi của người khác mà nó bao gồm:
        // input: data đầu vào cụ thể nào đó
        // output: đầu ra ứng với xử lý của hàm / chức năng của app, dĩ nhiên 
        // dùng đầu vào để xử lý (actual)
        // kì vọng: mong hàm sẽ output ra đúng với input
        // So sánh để xem kết quả có như kì vọng (expected) hay không

        long expected = 120; // tao kì vọng hàm ói về 120 nếu tính 5!
        int n = 5; // input 
        long actual = MathUtil.getFactorial(n);
        System.out.println("5! = 120 (expected); actual: " + actual);
    }
}