package com.crm.miniCRM.model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDate date;

    //  private LocalTime time;


    public Event(){}
    public Event(String description, LocalDate date) {
        this.description = description;
        this.date = date;
     //   this.time = time;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

//    public LocalTime getTime() {
//        return time;
//    }
//
//    public void setTime(LocalTime time) {
//        this.time = time;
//    }

    @Override
    public String toString() {
        return "Event{" +
                "ID=" + id +
                ", description='" + description + '\'' +
                ", date=" + date +
                //", time=" + time +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
