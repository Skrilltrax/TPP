package DP;

import java.util.*;

public class FractionalKnapsack {

    public static class Item implements Comparable<Item> {
        public int val;
        public int wt;

        public Item(int val, int wt) {
            this.val = val;
            this.wt = wt;
        }

        public Item(int val) {
            this(val, Integer.MAX_VALUE);
        }

        @Override
        public String toString() {
            return "Item { wt : " + this.wt + " val : " + this.val + " }";
        }

        @Override
        public int compareTo(Item other) {
            if (this.wt == Integer.MAX_VALUE || other.wt == Integer.MAX_VALUE) {
                throw new IllegalStateException("item wt cannot be Integer.MAX_VALUE");
            }

            double thisRatio = (double) this.val / this.wt;
            double otherRatio = (double) other.val / other.wt;

            double ratioDiff = thisRatio - otherRatio;

            if (ratioDiff >= 0.0d) {
                return -1;
            } else {
                return +1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Item> items = new ArrayList<>();

            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                items.add(new Item(sc.nextInt()));
            }

            for (int i = 0; i < n; i++) {
                items.get(i).wt = sc.nextInt();
            }

            int cap = sc.nextInt();

            System.out.println(knapsack(items, cap));
        }
    }

    public static float knapsack(ArrayList<Item> items, int cap) {
        float ans = 0;
        Collections.sort(items);

        // for(Item item: items) {
        // System.out.println(item);
        // }

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);

            if (cap - item.wt >= 0) {
                cap -= item.wt;
                ans += item.val;
            } else if (cap > 0 && cap < items.get(i).wt) {
                ans += (((float) cap) / item.wt) * item.val;
                cap = 0;
            } else {
                break;
            }
        }

        return ans;
    }
}