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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public Date getDatePlaced() {
        return datePlaced;
    }

    public void setDatePlaced(Date datePlaced) {
        this.datePlaced = datePlaced;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

}
