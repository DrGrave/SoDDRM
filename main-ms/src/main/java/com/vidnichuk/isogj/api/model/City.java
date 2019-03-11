package com.vidnichuk.isogj.api.model;


import javax.persistence.*;

/**
 * Created by Vadim on 06.11.2017.
 * entity to city
 */
@Entity
@Table(name = "City")
public class City {

    /**
     * id of city
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * name of city
     */
    private String name;

    /**
     * @return id of city
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id set id of city
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return name of city
     */
    public String getName() {
        return name;
    }

    /**
     * @param name set name of city
     */
    public void setName(String name) {
        this.name = name;
    }
}
