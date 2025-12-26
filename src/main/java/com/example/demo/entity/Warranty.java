package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "warranties")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Warranty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;

    private LocalDate purchaseDate;

    private LocalDate expiryDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(mappedBy = "warranty", cascade = CascadeType.ALL)
    private List<AlertSchedule> schedules;

    @OneToMany(mappedBy = "warranty", cascade = CascadeType.ALL)
    private List<AlertLog> logs;
}
