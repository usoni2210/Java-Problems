package  com.twister.HackerRank;

import java.util.Scanner;

public class LoveNine {
    static class IntHolder {
        private int value;
        IntHolder(int i) {
            value = i;
        }

        IntHolder plus() {
            value++;
            return this;
        }
        void minus() {
            value--;
        }
        public String toString() {
            return String.valueOf(value);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while(num-- != 0){
            int n = sc.nextInt();
            System.out.println(getLoveNines(n));
        }
        sc.close();
    }

    private static int getLoveNines(int num){
        IntHolder count = new IntHolder(0);
        countLoveNines(num, count.plus());
        int n = Integer.parseInt(count.toString());
        return n>0 ? n : -1;
    }

    private static boolean countLoveNines(int num, IntHolder count){
        if(num < 9){
            count.minus();
            return false;
        }else if(num%10 == 9){
            return true;
        } else {
            int temp = num;
            do{
                temp = getLower(temp);
            }while(!countLoveNines(num-temp, count.plus()));
            return true;
        }
    }

    private static int getLower(int num){
        while (--num%10 != 9 && num != 0);
        return num;
    }
}

