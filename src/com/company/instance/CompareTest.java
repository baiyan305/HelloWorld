package com.company.instance;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

/**
 * Created by Yan on 3/3/15.
 */
public class CompareTest {
    public static void main(String[] args) {
        ArrayList<Language> list = new ArrayList<Language>();

        list.add(new Language("english", 1000));
        list.add(new Language("chinese", 500));
        list.add(new Language("german", 2000));

        LangComparator comparator = new LangComparator();
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i).getLang());
        }
System.out.println("Sorting");




        Collections.sort(list, comparator);

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i).getLang());
        }
    }

    private static class LangComparator implements Comparator<Language>{
        @Override
        public int compare(Language l1, Language l2){
            int count1 = l1.getPageCount();
            int count2 = l2.getPageCount();

            if(count1 >= count2) return 1;
            else return 0;
        }
    }

    public static class Language{

        private String language;
        private int pageCount;

        public Language(String language, int pageCount){
            this.language = language;
            this.pageCount = pageCount;
        }

        public String getLang(){
            return this.language;
        }

        public int getPageCount(){
            return this.pageCount;
        }

    }
}
