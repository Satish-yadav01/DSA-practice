package interviewBasics.comparable;

public class Emp implements Comparable<Emp>{
    int id;
    String name;
    int age;

    @Override
    public int compareTo(Emp o) {
        return this.id - o.id;
    }
    public Emp(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


}
