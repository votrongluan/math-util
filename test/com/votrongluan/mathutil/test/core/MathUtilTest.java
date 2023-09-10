package com.votrongluan.mathutil.test.core;

import com.votrongluan.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;

public class MathUtilTest {
    // đây là class sẽ sử dụng các hàm của thư viện / framework JUnit
    // để kiểm thử / kiểm tra code chính - hàm tính Factorial() bên class
    // core.MathUtil viết code để test code chính bên kia

    // có nhiều quy tắc đặt tên hàm kiểm thử
    // nhưng thường sẽ là nói lên mục đích của các case / tình huống kiểm thử
    // tình huống xài hàm theo kiểu thành công và thất bại!!!
    // hàm dưới đây là tình huống test hàm chạy thành công, trả về ngon
    // ta sẽ xài hàm kiểu well - đưa 5!, 6! hok chơi đưa -5!, 30!
    // @Test JUnit sẽ phối hợp với JVM để chạy hàm này
    // @Test phía hậu trường chính là public static void main()
    // Có nhìu @Test ứng với nhìu case khác nhau để kiểm thử hàm tính giai thừa
    @Test
    public void testGetFactorialGivenRightArgumentReturnsWell() {
        int n = 0; // test thử tình huống tử tế đầu vào, mày phải chạy đúng
        long expected = 1; // hy vọng 0! = 1

        //long actual = // gọi hàm cần test bên core / app chính / code chính
        long actual = MathUtil.getFactorial(n);

        // so sánh expected vs. actual dùng xanh xanh đỏ đỏ, Framework
        Assert.assertEquals(expected, actual); // hàm giúp so sánh 2 giá trị nào
        // đó có giống nhau không -> thấy màu sxanh - code ngon
        // ít nhất cho case đang test
        // nếu ko giống nhau thảy màu đỏ -> hàm ý expected và actual khác nhau 

        // gộp thêm vài case thành công nữa vào đây
        Assert.assertEquals(1, MathUtil.getFactorial(1)); // tui mún 1! = 1
        Assert.assertEquals(2, MathUtil.getFactorial(2)); // tui mún 2! = 2
        Assert.assertEquals(6, MathUtil.getFactorial(3)); // tui mún 3! = 6
        Assert.assertEquals(24, MathUtil.getFactorial(4)); // tui mún 4! = 24
        Assert.assertEquals(120, MathUtil.getFactorial(5)); // tui mún 5! = 120
        Assert.assertEquals(720, MathUtil.getFactorial(6)); // tui mún 6! = 720
    }

    // hàm getF ta thiết kế có 2 tình huống xử lí
    // 1. Đưa data tử tế trong [0..20] -> tính đúng được n! - done
    // 2. Đưa data vào cà chớn, âm, >20; THIẾT KẾ CỦA HÀM LÀ NÉM RA NGOẠI LỆ
    // TA KÌ VỌNG NGOẠI LỆ XUẤT HIỆN KHI N < 0 || N > 20
    // rất mong ngoại lệ xuất hiện với n cà chớn này
    // nếu hàm nhận vào n < 0 và n > 20 và hàm ném ra ngoại lệ
    // HÀM CHẠY ĐÚNG NHƯ THIẾT KẾ ĐÚNG -> MÀU XANH PHẢI XUẤT HIỆN
    // nếu hàm nhận vào n < 0 và n > 20 và hàm éo ném ra ngoại lệ
    // sure, HÀM CHẠY SAI THIẾT KẾ, SAI KÌ VỌNG, MÀU ĐỎ
    // Test case:
    // Input: -5
    // Expected: IllegalArgumentsException xuất hiện
    // tình huống bất thường, ngoại lệ, ngoài dự tính, dự liệu
    // là những thứ ko thể đo lường so sánh theo kiểu value
    // mà chỉ có thể ko lường - cách chúng có xuất hiện hay không
    // assertEquals() ko dùng để so sánh 2 ngoại lệ
    //       equals() là bằng nhau hay ko trên value!!!
    // MÀU ĐỎ ĐÓ EM, DO HÀM ĐÚNG LÀ NÉM NGOẠI LỆ THẬT SỰ
    // NHƯNG KO PHẢI LÀ NHƯ KÌ VỌNG - THỰC SỰ KÌ VỌNG SAI KO PHẢI HÀM NÉM SAI
    /* @Test(expected = NumberFormatException.class)
    public void testGetFactorialGivenWrongArgumentThrowsException() {
        MathUtil.getFactorial(-5); // hàm @Test chạy, hay hàm getF() chạy
                                   // sẽ ném về ngoại lệ
    } */
    @Test(expected = IllegalArgumentException.class)
    public void testGetFactorialGivenWrongArgumentThrowsException() {
        MathUtil.getFactorial(-5); // hàm @Test chạy, hay hàm getF() chạy
        // sẽ ném về ngoại lệ
    }

    // Cách khác để bắt ngoại lệ xuất hiện, viết tự nhiên hơn! xài lambda
    // Test case: hàm sẽ ném ngoại lệ nếu nhận vào 21
    // tui cần thấy màu xanh khi chơi với 21!
    // Cái này để JUnit 5 giải quyết sau
    // Bắt ngoại lệ, xem hàm có ném về ngoại lệ hay ko khi n cà chớn
    // có ném, tức là hàm chạy đúng thiết kế -> xanh
    @Test
    public void testGetFactorialGivenWrongArgumentThrowsException_TryCatch() {
        // chủ động kiểm soát ngoại lệ
        try {
            MathUtil.getFactorial(-5);
        } catch (Exception e) {
            // bắt try-catch là JUnit sẽ ra xanh do đã chủ động kiểm soát ngoại
            // lệ nhưng ko chắc ngoại lệ mình cần có xuất hiện hay ko?
            // có đoạn code kiểm soát đúng ngoại lệ IllegalArgumentException xh
            Assert.assertEquals("Invalid argument. N must be between 0..20", e.getMessage());
        }
    }
}
