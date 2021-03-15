package com.challenge.orderIssuingApi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class OrderRequest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne
    private Client client;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "orderRequest", cascade = CascadeType.ALL)
    private List<Item> items;
    /* https://stackoverflow.com/questions/2990799/difference-between-fetchtype-lazy-and-eager-in-java-persistence-api */

    public OrderRequest() {

    }

    public OrderRequest(Client client, List<Item> items) {
        this.client = client;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }
}