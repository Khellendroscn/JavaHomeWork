package net.khe.homework11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import static net.khe.util.Print.*;

/**
 * Created by hyc on 2016/12/16.
 */
public class Book {
    public final String ISBN;
    public final String title;
    public final String author;
    public final SimpleDate pubDate;
    public final double price;
    private static SimpleDateFormat format =
            new SimpleDateFormat("yyyy-mm-dd");

    public static class SimpleDate{
        public final int year;
        public final int month;
        public final int day;

        public SimpleDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
        @Override
        public String toString(){
            return year+"-"+month+"-"+day;
        }
    }
    public Book(String isbn, String title, String author,SimpleDate pubDate, double price) {
        ISBN = isbn;
        this.title = title;
        this.author = author;
        this.pubDate = pubDate;
        this.price = price;
    }
    @Override
    public String toString(){
        return "ISBN: "+ISBN+
                "\nTitle: "+title+
                "\nAuthor: "+author+
                "\nPubDate: "+pubDate+
                "\nPrive: "+price;
    }
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Book)) return false;
        Book book = (Book)obj;
        return ISBN.equals(book.ISBN);
    }

    public static void main(String[] args) {

        Map<String,Book> bookMap = new HashMap<>();
        initBookMap(bookMap);
        printMap1(bookMap);
        printMap2(bookMap);
        printMap3(bookMap);
    }
    public static void initBookMap(Map<String,Book> bookMap){
        Book[] books = {
                new Book(
                        "ISBN 978-7-302-35419-2",
                        "Java程序开发实用教程",
                        "邱加永",
                        new SimpleDate(2014,4,1),
                        48.00
                ),
                new Book(
                        "ISBN 978-7-121-12570-6",
                        "More Effective C++",
                        "Scott Meyers",
                        new SimpleDate(2011,1,1),
                        59.00
                ),
                new Book(
                        "ISBN 978-7-5641-5911-5",
                        "Effective Modern C++",
                        "Scott Meyers",
                        new SimpleDate(2015,9,1),
                        59.00
                ),
                new Book(
                        "ISBN 978-7-121-15535-2",
                        "C++ Primer 5th",
                        "Stanley B.Lippman",
                        new SimpleDate(2013,9,1),
                        128.00
                ),
                new Book(
                        "ISBN 978-7-121-12332-0",
                        "Effective C++",
                        "Scott Meyers",
                        new SimpleDate(2011,1,1),
                        65.00
                ),
        };
        for(Book book:books){
            bookMap.put(book.ISBN,book);
        }
    }
    public static <K,V> void printMap1(Map<K,V> map){
        println("for-each");
        for(K key:map.keySet()){
            println(map.get(key));
            println();
        }
        println();
    }
    public static <K,V> void printMap2(Map<K,V> map){
        println("stream");
        map.keySet().stream().forEach((K key)->{
            System.out.println(map.get(key));
            println();
        });
        println();
    }
    public static <K,V> void printMap3(Map<K,V> map){
        println("iterator");
        Iterator<K> keyIter = map.keySet().iterator();
        while (keyIter.hasNext()){
            println(map.get(keyIter.next()));
            println();
        }
        println();
    }
}
