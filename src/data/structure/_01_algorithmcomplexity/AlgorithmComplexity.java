package data.structure._01_algorithmcomplexity;

/**
 * 算法复杂度
 * 算法复杂度主要分为两种：
 * - 时间复杂度（time complexity）：时间复杂度描述了算法运行所需的时间与输入规模之间的关系。
 * - 空间复杂度（space complexity）：空间复杂度描述了算法在运行过程中所需的存储空间与输入规模之间的关系。
 * <p>
 * 一般情况下，算法复杂度一般使用大 O 表示法，表示数据规模 n 对应的复杂度
 * 大 O 表示法主要分为以下几种：
 * - O(1)：常数时间复杂度，不管数据规模 n 多大，执行时间或者占用空间都是一个固定的常数,简称常数阶
 * - O(n)：线性时间复杂度，数据规模 n 增大 n 倍，执行时间或者占用空间增大 n 倍,简称线性阶
 * - O(n^2)：平方时间复杂度，数据规模 n 增大 n 倍，执行时间或者占用空间增大 n^2 倍,简称平方阶
 * - O(n^3)：立方时间复杂度，数据规模 n 增大 n 倍，执行时间或者占用空间增大 n^3 倍,简称立方阶
 * - O(logn)：对数时间复杂度，数据规模 n 增大 n 倍，执行时间或者占用空间增大 logn 倍,简称对数阶
 * - O(nlogn)：线性对数复杂度，数据规模 n 增大 n 倍，执行时间或者占用空间增大 nlogn 倍，,简称 nlogn 阶
 * - O（2^n）: 指数时间复杂度，数据规模 n 增大 n 倍，执行时间或者占用空间增大 2^n 倍,简称指数阶
 * 上述几种从小到大的效率是：O(1) < O(logn) < O(n) < O(nlogn) < O(n^2) < O(n^3) < O(2^n)
 */
public class AlgorithmComplexity {
    /**
     * 时间复杂度: O(n)（有一个循环，执行次数与n成线性关系）
     * 空间复杂度: O(1)（没有使用与输入规模相关的额外空间）
     */
    public static void test01(int n) {
        if (n > 10) {
            System.out.println("n > 10");
        } else if (n > 5) {
            System.out.println("n > 5");
        } else {
            System.out.println("n <= 5");
        }
        // 1 + 4 + 4 + 4  时间复杂度是 O(n)
        for (int i = 0; i < 4; i++) {
            System.out.println("test");
        }
    }


    /**
     * 求第n个斐波拉契数解法
     * 时间复杂度: O(n)（有一个循环，执行次数与n成线性关系）
     * 空间复杂度: O(1)（只使用了常数个变量）
     */
    public static int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    /**
     * 时间复杂度: O(log n)（通过每次将n除以2，使得n以对数方式递减）
     * 空间复杂度: O(1)（只使用了常数个变量）
     */
    public static void test05(int n) {
        // 8 = 2^3
        // 16 = 2^4
        // 3 = log2(8)
        // 4 = log2(16)

        // 执行次数 = log2(n)
        // O(log n)
        while ((n = n / 2) > 0) {
            System.out.println("test");
        }
    }

    /**
     * 求第n个斐波拉契数 0 1 1 2 3 5 8 13 递归
     * 时间复杂度: O(2^n)（递归调用，每次递归都需要两次调用）
     * 空间复杂度: O(n)（递归栈的深度与n成线性关系）
     */
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 时间复杂度: O(n)（有一个循环，执行次数与n成线性关系）
     * 空间复杂度: O(n)（使用了长度与n成线性关系的数组）
     */
    public static void test02(int n) {
        // O(n)
        for (int i = 0; i < n; i++) {
            System.out.println("test");
        }
    }

    /**
     * 时间复杂度: O(n^2)（嵌套循环，执行次数与n的平方成正比）
     * 空间复杂度: O(1)（没有使用与输入规模相关的额外空间）
     */
    public static void test03(int n) {
        // 1 + 2n + n * (1 + 3n)
        // 1 + 2n + n + 3n^2
        // 3n^2 + 3n + 1
        // O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("test");
            }
        }
    }

    /**
     * 时间复杂度: O(n)（嵌套循环，执行次数与n成线性关系）
     * 空间复杂度: O(1)（没有使用与输入规模相关的额外空间）
     */
    public static void test04(int n) {
        // 1 + 2n + n * (1 + 45)
        // 1 + 2n + 46n
        // 48n + 1
        // O(n)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.println("test");
            }
        }
    }

    /**
     * 时间复杂度: O(log n)（每次将n除以5，使得n以对数方式递减）
     * 空间复杂度: O(1)（只使用了常数个变量）
     *
     * @param n 10
     */
    public static void test06(int n) {
        // log5(n)
        // O(log n)
        while ((n = n / 5) > 0) {
            System.out.println("test");
        }
    }

    /**
     * 时间复杂度: O(n log n)（外层循环以指数方式增长，内层循环以对数方式增长）
     * 空间复杂度: O(1)（只使用了常数个变量）
     */
    public static void test07(int n) {
        // 1 + 2*log2(n) + log2(n) * (1 + 3n)
        // 1 + 3*log2(n) + 2 * nlog2(n)
        // O(nlog n)
        for (int i = 1; i < n; i = i * 2) {
            // n
            for (int j = 0; j < n; j++) {
                System.out.println("test");
            }
        }
    }
}
