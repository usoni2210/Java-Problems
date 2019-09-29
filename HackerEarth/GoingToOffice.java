package com.twister.HackerEarth;

import java.util.*;

public class GoingToOffice {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        long km = s.nextInt();

        long oc = s.nextInt();
        long of = s.nextInt();
        long od = s.nextInt();

        long cs = s.nextInt();
        long cb = s.nextInt();
        long cm = s.nextInt();
        long cd = s.nextInt();

        if(calcClassicTaxiFair(km,cs,cb,cm,cd) < calcOnlineTaxiFair(km,oc,of,od))
            System.out.print("Classic Taxi");
        else
            System.out.print("Online Taxi");

    }

    private static long calcOnlineTaxiFair(long km, long c, long f, long d){
        return c + (km - f) * d;
    }

    private static long calcClassicTaxiFair(long km, long s, long b, long m, long d){
        return b + (long)(km/s) * m + (km * d);
    }
}
