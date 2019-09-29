package com.twister.HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class EfficientShipping {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int boxesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> boxes = IntStream.range(0, boxesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Long::parseLong)
                .collect(toList());
        int unitsPerBoxCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Long> unitsPerBox = IntStream.range(0, unitsPerBoxCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Long::parseLong)
                .collect(toList());

        long truckSize = Long.parseLong(bufferedReader.readLine().trim());

        System.out.println("getting Result");
        long result = Result.getMaxUnits(boxes, unitsPerBox, truckSize);
        System.out.println(" result : " + result);

        bufferedReader.close();
    }

    private static class Result {

        /*
         * Complete the 'getMaxUnits' function below.
         *
         * The function is expected to return a LONG_INTEGER.
         * The function accepts following parameters:
         *  1. LONG_INTEGER_ARRAY boxes
         *  2. LONG_INTEGER_ARRAY unitsPerBox
         *  3. LONG_INTEGER truckSize
         */

        private static int getMaxUnitPerBox(List<Long> list){
            int i = 0;
            for(int j=0; j<list.size(); j++){
                if(list.get(i) < list.get(j)){
                    i = j;
                }
            }
            return i;
        }

        static long getMaxUnits(List<Long> boxes, List<Long> unitsPerBox, long truckSize) {
            long count =0 ;
            long box = 0;
            System.out.println("Function Called");
            while (box < truckSize && unitsPerBox.size() > 0){
                System.out.println("Items : " +  count +" Boxes : " + box + " truck : " + truckSize);
                int index = getMaxUnitPerBox(unitsPerBox);

                System.out.println("Maximum unit box : "  + index + " Unit : " + unitsPerBox.get(index));

                long t = boxes.get(index);
                long rem = truckSize - box;
                System.out.println("\t Available : " + t + " Rem : " +  rem );
                if(t < rem) {
                    count += t * unitsPerBox.get(index);
                    box += t;
                }else {
                    count += rem * unitsPerBox.get(index);
                    box += rem;
                }

                unitsPerBox.remove(index);
                boxes.remove(index);
            }
            return count;
        }

    }
}