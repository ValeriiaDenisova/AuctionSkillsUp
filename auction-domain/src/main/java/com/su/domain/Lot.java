package com.su.domain;

import com.su.domain.Item;
import lombok.Data;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class Lot {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Item item;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    private BigDecimal startPrice;
    private Date datePlaced;
    private Date dateEnd;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;

    private BigDecimal currentPrice;

}
