package data.structure._02_bitoperation;

public class BitOperation {
    public static void main(String[] args) {
        int test = 74951;
        // 左移一位
        print(test << 1);
        // 左移两位
        print(test << 2);
        // 左移四位
        print(test << 4);
        // 左移八位
        print(test << 8);
        System.out.println("================================================================");
        print(83928328);
        print(-1);
        print(-2);
        int a = 123123;
        int b = ~a;
        print(a);
        print(b);
    }

    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.print("\n");
        System.out.println("================================================================");
    }

}
