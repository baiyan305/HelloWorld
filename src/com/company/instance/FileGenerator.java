package com.company.instance;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;
import java.util.Map;

/**
 * Created by Yan on 3/3/15.
 */
public class FileGenerator {

    public static void main(String[] args) {


        //get all keys

        ArrayList<String> list = new ArrayList<String>();
        try {
            FileInputStream fis = new FileInputStream("/Users/Yan/Desktop/datakey");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String key;
            while ((key = br.readLine()) != null) {
                list.add(key);
                System.out.println(key);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        for (int day = 1; day <= 31; day++) {

            String fileName = "pagecounts-201407";
            if (day < 10) fileName = fileName + "0" + day;
            else fileName = fileName + day;


            for (int hour = 0; hour <= 23; hour++) {
                String fullFileName = null;
                if (hour < 10) fullFileName = fileName + "-00000" + hour;
                else fullFileName = fileName + "-0000" + hour;

                try {
                    File file = new File("/Users/Yan/Documents/Develop/Hadoop/input/" + fullFileName);
                    FileOutputStream fos = new FileOutputStream(file);
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

                    for (int x = 0; x < list.size(); x++) {
                        bw.write(list.get(x));
                        bw.write(' ');
                        bw.write(randomInt(4000, 1000) + "");
                        bw.write(' ');
                        bw.write(randomInt(30000, 20000) + "");
                        if (x != list.size() - 1) bw.newLine();
                    }

                    bw.close();
                } catch (IOException e) {

                }
            }


        }




    }


    class ValueComparator implements Comparator<String> {

        Map<String, Double> base;
        public ValueComparator(Map<String, Double> base) {
            this.base = base;
        }

        // Note: this comparator imposes orderings that are inconsistent with equals.
        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            } // returning 0 would merge keys
        }
    }

    private static int randomInt(int max, int min){

        Random random = new Random();

        int randomNum = random.nextInt((max - min) + 1) + min;

        return randomNum;
    }

}
