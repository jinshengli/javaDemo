package collection.treemap;

public class DTO implements Comparable{

    private Integer id;

    public DTO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    @Override
    public int compareTo(Object o) {
        DTO obj = (DTO) o;
        return id - obj.getId();
    }

    @Override
    public String toString() {
        return "DTO{" +
                "id=" + id +
                '}';
    }
}
