package com.vidnichuk.isogj.api.model;

import javax.persistence.*;

/**
 * Created by vadim on 16.10.17.
 * gender of user
 */
@Entity
@Table(name = "Gender")
public class Gender {

    /**
     * id of gender
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name of gender
     */

    @Column(name = "Name", nullable = false)
    private String name;

    /**
     * @return gender id
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return name of gender
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gender gender = (Gender) o;

        return id == gender.id && (name != null ? name.equals(gender.name) : gender.name == null);
    }
}
