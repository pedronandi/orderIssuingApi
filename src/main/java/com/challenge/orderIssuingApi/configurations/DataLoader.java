package com.challenge.orderIssuingApi.configurations;

import com.challenge.orderIssuingApi.models.Client;
import com.challenge.orderIssuingApi.models.Product;
import com.challenge.orderIssuingApi.services.ClientService;
import com.challenge.orderIssuingApi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataLoader implements ApplicationRunner {

    private ClientService clientService;
    private ProductService productService;

    @Autowired
    public DataLoader(ClientService clientService, ProductService productService) {
        this.clientService = clientService;
        this.productService = productService;
    }

    public void insertInitialClients() {
        ArrayList<Client> clients = new ArrayList<>();

        clients.add(new Client("Darth Vader"));
        clients.add(new Client("Obi-Wan Kenobi"));
        clients.add(new Client("Luke Skywalker"));
        clients.add(new Client("Imperador Palpatine"));
        clients.add(new Client("Han Solo"));

        for(Client client : clients) {
            if(!clientService.exists(client))
                clientService.save(client);
        }
    }

    public void insertInitialProducts() {
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product("Milenium Falcon", 550000, null));
        products.add(new Product("X-Wing", 60000, 2));
        products.add(new Product("Super Star Destroyer", 4570000, null));
        products.add(new Product("TIE Fighter", 75000, 2));
        products.add(new Product("Lightsaber", 6000, 5));
        products.add(new Product("DLT-19 Heavy Blaster Rifle", 5800, null));
        products.add(new Product("DL-44 Heavy Blaster Pistol", 1500, 10));

        for(Product product : products) {
            if(!productService.exists(product))
                productService.save(product);
        }
    }

    public void run(ApplicationArguments args) {
        insertInitialClients();
        insertInitialProducts();
    }
}