package org.jarzeckil.plakatowanie;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jarzeckil
 */
public class Plakatowanie {

    int n;
    int[] widths;
    int[] heights;

    public int solve() {
        readData();

        return 0;
    }

    private void readData() {

        try {
            //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("in/pla0.in")));
            String line;

            line = reader.readLine();
            n = Integer.parseInt(line);
            widths = new int[n];
            heights = new int[n];

            int i = 0;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(" ", 2);

                widths[i] = Integer.parseInt(parts[0]);
                heights[i] = Integer.parseInt(parts[1]);

                i++;
            }
        } catch (IOException e) {
            System.err.println("File not found");
        }
    }

    public static void main(String[] args) {
        Plakatowanie p = new Plakatowanie();
        p.solve();
    }
}
