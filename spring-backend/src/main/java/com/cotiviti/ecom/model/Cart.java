package com.cotiviti.ecom.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(nullable = false, name = "active_session")
    private boolean activeSession;

    @Column(nullable = false, precision = 2)
    private double total;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user=" + user +
                ", activeSession=" + activeSession +
                ", total=" + total +
                ", cartItems=" + cartItems +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
