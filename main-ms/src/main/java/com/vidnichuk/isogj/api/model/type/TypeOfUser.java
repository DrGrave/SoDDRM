package com.vidnichuk.isogj.api.model.type;


import javax.persistence.*;


/**
 * Type of user object
 */
@Entity
@Table(name = "TypeOfUser")
public class TypeOfUser {


    /**
     * identity of user type
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name of user type
     */
    private String name;

    /**
     * @return id of type
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id set id type of user
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return name of type user
     */
    public String getName() {
        return name;
    }

    /**
     * @param name set name of type user
     */
    public void setName(String name) {
        this.name = name;
    }
}
