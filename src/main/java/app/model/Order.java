package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Min(1)
    private long petId;

    @Min(1)
    private int quantity;

    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
    private String shipDate;

    @Min(1)
    private long userId;

    private OrderStatus orderStatus;
    private boolean complete;
}
