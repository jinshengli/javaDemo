package collection.treemap;

public class DTO1{

    private Integer id;

    public DTO1(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    @Override
    public String toString() {
        return "DTO{" +
                "id=" + id +
                '}';
    }
}
