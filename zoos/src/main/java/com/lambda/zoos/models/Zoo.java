package com.lambda.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "zoos")
public class Zoo extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;

    @Column(nullable = true, unique = true)
    private String zooname;

    @OneToMany(mappedBy = "zoo",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    @JsonIgnoreProperties("zoo")
    private List<Telephone> telephones = new ArrayList<>();

    @OneToMany(mappedBy = "zoo",
        cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "zoo",
        allowSetters = true)
    private Set<ZooAnimals> animals = new HashSet<>();

    public Zoo()
    {
    }

    public Zoo(
        String zooname,
        List<Telephone> telephones,
        Set<ZooAnimals> animals)
    {
        this.zooname = zooname;
        this.telephones = telephones;
        this.animals = animals;
    }

    public long getZooid()
    {
        return zooid;
    }

    public void setZooid(long zooid)
    {
        this.zooid = zooid;
    }

    public String getZooname()
    {
        return zooname;
    }

    public void setZooname(String zooname)
    {
        this.zooname = zooname;
    }

    public List<Telephone> getTelephones()
    {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones)
    {
        this.telephones = telephones;
    }

    public Set<ZooAnimals> getAnimals()
    {
        return animals;
    }

    public void setAnimals(Set<ZooAnimals> animals)
    {
        this.animals = animals;
    }
}
