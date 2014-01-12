package com.example.training.entity.cache;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Database entity to represent a railway line.
 *
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Line {

    /** Unique identifier. <tt>null</tt> until it's persisted. */
    @Id
    @GeneratedValue
    private Long id;

    /** The name of the line. (NonNull) */
    private String name;

    /** The list of the stations on the line. (NonNull) */
    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private List<Station> stations = new ArrayList<Station>();

    /** Default constructor for hibernate. */
    Line() { /* NOP */ }

    /**
     * @param name The name of the line. (NonNull)
     */
    public Line(final String name) {
        super();
        this.name = name;
    }

    /**
     * @return Unique identifier. <tt>null</tt> until it's persisted.
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id The unique identifier to set. (package private to avoid modification.)
     */
    void setId(final Long id) {
        this.id = id;
    }

    /**
     * @return The name of the line. (NonNull)
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name of the line to set. (NonNull)
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the stations The list of the stations on the line. (NonNull)
     */
    public List<Station> getStations() {
        return stations;
    }

    /**
     * @param stations The list of the stations on the line to set. (NonNull)
     */
    void setStations(final List<Station> stations) {
        this.stations = stations;
    }






}
