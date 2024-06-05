package com.List_;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("红楼梦", 200, "曹雪芹"));
        list.add(new Book("西游记",100,"吴承恩"));
        list.add(new Book("水浒传",300,"施耐庵"));
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                Book b = (Book) list.get(i);
                Book b2 = (Book) list.get(i+1);
                if(b.getPrice() > b2.getPrice()){
                    list.set(j,b2);
                    list.set(j+1,b);
                }
            }
        }
        for (Object o :list) {
            System.out.println(o.toString());
        }
    }
}

class Book {
    private String french_quotes;
    private double price;
    private String author;

    public String getFrench_quotes() {
        return french_quotes;
    }

    public void setFrench_quotes(String french_quotes) {
        this.french_quotes = french_quotes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(String french_quotes, double price, String author) {
        this.french_quotes = french_quotes;
        this.price = price;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "french_quotes='" + french_quotes + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}
