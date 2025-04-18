package org.jarzeckil.plakatowanie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author jarzeckil
 */
public class MinPosterCountCalculator {

    int n;
    int[] heights;

    public void solve() {
        readData();
        System.out.println(getMinPosterCount());
    }

    private int getMinPosterCount() {
        int p = 0;
        Queue<Integer> stack = new PriorityQueue<>((num1, num2) -> num2.compareTo(num1));

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() > heights[i]) {
                stack.remove();
            }
            if (stack.isEmpty() || stack.peek() < heights[i]) {
                stack.add(heights[i]);
                p++;
            }
        }
        return p;
    }

    private void readData() {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;

            line = reader.readLine();
            n = Integer.parseInt(line);
            heights = new int[n];

            int i = 0;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(" ", 2);

                heights[i] = Integer.parseInt(parts[1]);
                i++;
            }
        } catch (IOException e) {
            System.err.println("File not found");
        }
    }

    public static void main(String[] args) {
        MinPosterCountCalculator p = new MinPosterCountCalculator();
        p.solve();
    }
}
