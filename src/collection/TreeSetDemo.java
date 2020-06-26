package collection;


import java.util.Comparator;
import java.util.TreeSet;

/**
 * create by ljs on 2020/6/26 18:31
 * <p>
 * description:
 */
public class TreeSetDemo {


    public static void main(String[] args) {



        Book hello = new Book("hello", 123);

        BookCompare bookCompare = new BookCompare();

        TreeSet<Book> treeSet = new TreeSet<>(bookCompare);
        treeSet.add(new Book("hello",22));
        treeSet.add(hello);
        treeSet.add(new Book("wowo",2));

        for (Book book : treeSet) {
            System.out.println(book);
        }


    }


}

class Book implements Comparable{

    private String name;
    private Integer id;

    public Book(String name, Integer id) {
        this.name = name;
        this.id = id;
    }


    public Book(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        Book book = (Book) o;
        return name.compareTo(book.name);
    }

    @Override
    public String toString() {
        return "Book{" + "name='" + name + '\'' + ", id=" + id + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

class BookCompare implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getId().compareTo(o2.getId());
    }
}


