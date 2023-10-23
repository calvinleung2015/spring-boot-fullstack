package com.calvincode;

import com.calvincode.customer.Customer;
import com.calvincode.customer.CustomerRepository;
import com.calvincode.customer.Gender;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication()
public class Main {



    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository) {

        return args -> {
            var faker = new Faker();
            Random random = new Random();
            Name name = faker.name();
            String firstName = name.firstName();
            String lastName = name.lastName();
            int age = random.nextInt(16, 99);
            Gender gender = age % 2 == 0 ? Gender.MALE : Gender.FEMALE;
            Customer customer = new Customer(
                    null,
                    firstName + " " + lastName,
                    firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com",
                    age,
                    gender);
//            customerRepository.save(customer);
        };
    }

}
