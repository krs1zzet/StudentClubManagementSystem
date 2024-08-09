package com.cmddotenter.StudentClubManagementSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clubs")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Club() {
    }

    public Club(String clubName, String clubDescription) {
        this.name = clubName;
        this.description = clubDescription;
    }

    public Club(long id, String clubName, String clubDescription) {
        this.id = id;
        this.name = clubName;
        this.description = clubDescription;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
