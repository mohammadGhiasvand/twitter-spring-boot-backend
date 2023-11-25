package com.mohammad.twitterbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native")
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Twit twit;
}
