package org.example.model;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Person implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @Size(min = 2, max = 30, message = "Имя должно быть от 2 до 30 символов")
    private String name;
    @Column(name = "surName")
    @Size(min = 2, max = 30, message = "Имя должно быть от 2 до 30 символов")
    private String surName;
    @Column(name = "age")
   // @NotEmpty(message = "Возраст не должен быть пустой")
    @Min(value = 0, message = "Возраст должен быть больше 0")
    private int age;
    @Column(name = "numberPhone")
    @Size(min = 5, max = 11, message = "Номер должен быть от 5 до 11 символов")
    @UniqueElements
    private String numberPhone;

    @OneToMany (mappedBy="person", fetch=FetchType.EAGER)
    private List<Animal> animalList;

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public Person() {
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumberPhone() {
        return numberPhone;
    }
    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && age == person.age && name.equals(person.name) && surName.equals(person.surName) && numberPhone.equals(person.numberPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surName, age, numberPhone);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", numberPhone='" + numberPhone + '\'' +
                ", animalList=" + animalList +
                '}';
    }
}
