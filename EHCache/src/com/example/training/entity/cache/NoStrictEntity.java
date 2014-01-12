package com.example.training.entity.cache;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 *  * An entity configured with {@link CacheConcurrencyStrategy#NONSTRICT_READ_WRITE NonStrict Read-write} cache strategy.
 * 
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class NoStrictEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    /** Default constructor for Hibernate. */
    NoStrictEntity() { /* NOP */ }

    public NoStrictEntity(final String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

}
