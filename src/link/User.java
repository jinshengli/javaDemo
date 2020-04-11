package link;

public class User implements Comparable{

    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if ( obj instanceof User ){
            if ( this.name == ((User) obj).getName() )
                if ( this.age == ((User) obj).getAge() )
                    return true;
        }
        return false;
    }


    @Override
    public int compareTo(Object o) {
        User user = (User) o;
        if ( this.name.equals(user.getName()) )
            return this.getAge() - user.getAge();
        return this.name.compareTo(user.name);
    }
}
