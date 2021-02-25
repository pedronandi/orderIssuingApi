package com.challenge.orderIssuingApi.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int id;

    public String name;

    public Client() {

    }

    public Client(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if(object == this)
            return true;

        if(!(object instanceof Client))
            return false;

        Client client = (Client) object;

        return name.equals(client.name);
    }
}
