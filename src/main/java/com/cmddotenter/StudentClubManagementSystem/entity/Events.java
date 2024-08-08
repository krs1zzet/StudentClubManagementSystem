package com.cmddotenter.StudentClubManagementSystem.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name ="date")
    private String date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;


    public Events() {
    }

    public Events(String name, String date, String description, Club club) {
        this.name = name;
        this.date = date;
        this.description = description;
        this.club = club;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
