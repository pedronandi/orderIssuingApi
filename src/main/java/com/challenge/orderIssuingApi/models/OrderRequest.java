package com.challenge.orderIssuingApi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class OrderRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne
    private Client client;

    @JsonManagedReference
    @OneToMany(mappedBy = "orderRequest", cascade = CascadeType.ALL)
    private List<Item> items;

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