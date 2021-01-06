package org.example.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "animal")
public class Animal implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "view")
    @Size(min = 2, max = 30, message = "Вид должен быть от 2 до 30 символов")
    private String view;
    @Column(name = "nickname")
    @Size(min = 2, max = 30, message = "Кличка должна быть от 2 до 30 символов")
    private String nickname;
    @Column(name = "age")
    @Min(value = 0, message = "Возраст должен быть больше 0")
    private int age;

   // @Min(value = 0, message = "id клиента должно быть больше 0")
    @Column(insertable = false, updatable = false)
    private int idPerson;

   // @JoinColumn(name = "idPerson")
    @ManyToOne
    @JoinColumn(name = "idPerson")
    private Person person;

    public Animal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", view='" + view + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", idPerson=" + idPerson +
                ", person=" + person.getName() +
                '}';
    }
}
