package generic;


/**
 * create by ljs on 2020/6/25 19:09
 * <p>
 * description:
 */
public class Song implements Comparable {

    private Integer id;
    private String title;
    private String author;

    public Song() {
    }

    public Song(Integer id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object song) {

        Song s = (Song) song;

        // return title.compareTo(s.title);  升序； 小的去比大的。小的在做，大的在右。
        return s.title.compareTo(title);

    }
}
