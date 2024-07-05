package mypack;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="StudentDetails")
public class Students {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RollNo", nullable = false)
    private int roolno;

    @Column(name = "StudentsName")
    private String name;

    @Column(name = "Age")
    private int age;

    @Column(name = "Address")
    private String add;

    // Getters and Setters
    public int getRoolno() {
        return roolno;
    }

    public void setRoolno(int roolno) {
        this.roolno = roolno;
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

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    public String toString() {
        return "Students [RollNo=" + roolno + ", name=" + name + ", age=" + age + ", address=" + add + "]";
    }
}
