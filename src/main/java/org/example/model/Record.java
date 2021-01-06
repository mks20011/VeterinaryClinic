package org.example.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "record")
public class Record {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "data")
    private Date data;
    @Column(name = "numberPhone")
    private String numberPhone;
    @Column(insertable = false, updatable = false)
    private int idPerson;
    @Column(name = "idAnimal")
    private int idAnimal;
    @ManyToOne
    @JoinColumn(name = "idPerson")
    private Person person;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
