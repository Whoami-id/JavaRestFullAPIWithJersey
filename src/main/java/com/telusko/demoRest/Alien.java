
package com.telusko.demoRest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alien {

    public Alien() {

    }

    private int id;
    private String name;
    private int points;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(final int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Alien [id=" + id + ", name=" + name + ", points=" + points + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

}
