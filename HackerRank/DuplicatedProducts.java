package com.twister.HackerRank;

import java.io.*;
import java.util.*;

public class DuplicatedProducts {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int nameCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> name = new ArrayList<>();

        for (int i = 0; i < nameCount; i++) {
            String nameItem = bufferedReader.readLine();
            name.add(nameItem);
        }

        int priceCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> price = new ArrayList<>();
        for (int i = 0; i < priceCount; i++) {
            int priceItem = Integer.parseInt(bufferedReader.readLine().trim());
            price.add(priceItem);
        }

        int weightCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> weight = new ArrayList<>();
        for (int i = 0; i < weightCount; i++) {
            int weightItem = Integer.parseInt(bufferedReader.readLine().trim());
            weight.add(weightItem);
        }

        int result = Result.numDuplicates(name, price, weight);

        System.out.println(result);

        bufferedReader.close();
    }

    private static class Result {
        private static int numDuplicates(List<String> name, List<Integer> price, List<Integer> weight) {
            Set<Product> hash = new HashSet<>();
            for (int i = 0; i < name.size(); i++) {
                Product p = new Product(name.get(i), price.get(i), weight.get(i));
                hash.add(p);
            }
            return name.size() - hash.size();
        }
    }

    static class Product{
        private String name;
        private Integer price;
        private Integer weight;

        Product(String name, Integer price, Integer weight) {
            this.name = name;
            this.price = price;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return name +" - "+ price +" - "+ weight;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 31 * hash + price;
            hash = 31 * hash + weight;
            hash = 31 * hash + (name == null ? 0 : name.hashCode());
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Product) {
                Product p = (Product) obj;
                return name.equals(p.name) && price.equals(p.price) && weight.equals(p.weight);
            }
            return false;
        }
    }
}