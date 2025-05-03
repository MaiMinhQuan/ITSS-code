//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Generated;

@Entity
@Table(
        name = "equipment"
)
public class Equipment {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    private int id;
    @Column(
            name = "name"
    )
    private String name;
    @Column(
            name = "purchase_date"
    )
    private Date puchase_date;
    @Column(
            name = "price"
    )
    private int price;
    @Column(
            name = "warranty_period"
    )
    private int warranty_period;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "category"
    )
    private EpCategory category;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "room"
    )
    private Room room;
    @Column(
            name = "is_deleted"
    )
    private boolean is_deleted;

    @Generated
    public int getId() {
        return this.id;
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public Date getPuchase_date() {
        return this.puchase_date;
    }

    @Generated
    public int getPrice() {
        return this.price;
    }

    @Generated
    public int getWarranty_period() {
        return this.warranty_period;
    }

    @Generated
    public EpCategory getCategory() {
        return this.category;
    }

    @Generated
    public Room getRoom() {
        return this.room;
    }

    @Generated
    public boolean is_deleted() {
        return this.is_deleted;
    }

    @Generated
    public void setId(final int id) {
        this.id = id;
    }

    @Generated
    public void setName(final String name) {
        this.name = name;
    }

    @Generated
    public void setPuchase_date(final Date puchase_date) {
        this.puchase_date = puchase_date;
    }

    @Generated
    public void setPrice(final int price) {
        this.price = price;
    }

    @Generated
    public void setWarranty_period(final int warranty_period) {
        this.warranty_period = warranty_period;
    }

    @Generated
    public void setCategory(final EpCategory category) {
        this.category = category;
    }

    @Generated
    public void setRoom(final Room room) {
        this.room = room;
    }

    @Generated
    public void set_deleted(final boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Equipment)) {
            return false;
        } else {
            Equipment other = (Equipment)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getId() != other.getId()) {
                return false;
            } else if (this.getPrice() != other.getPrice()) {
                return false;
            } else if (this.getWarranty_period() != other.getWarranty_period()) {
                return false;
            } else if (this.is_deleted() != other.is_deleted()) {
                return false;
            } else {
                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                Object this$puchase_date = this.getPuchase_date();
                Object other$puchase_date = other.getPuchase_date();
                if (this$puchase_date == null) {
                    if (other$puchase_date != null) {
                        return false;
                    }
                } else if (!this$puchase_date.equals(other$puchase_date)) {
                    return false;
                }

                label55: {
                    Object this$category = this.getCategory();
                    Object other$category = other.getCategory();
                    if (this$category == null) {
                        if (other$category == null) {
                            break label55;
                        }
                    } else if (this$category.equals(other$category)) {
                        break label55;
                    }

                    return false;
                }

                Object this$room = this.getRoom();
                Object other$room = other.getRoom();
                if (this$room == null) {
                    if (other$room != null) {
                        return false;
                    }
                } else if (!this$room.equals(other$room)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof Equipment;
    }

    @Generated
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getId();
        result = result * 59 + this.getPrice();
        result = result * 59 + this.getWarranty_period();
        result = result * 59 + (this.is_deleted() ? 79 : 97);
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $puchase_date = this.getPuchase_date();
        result = result * 59 + ($puchase_date == null ? 43 : $puchase_date.hashCode());
        Object $category = this.getCategory();
        result = result * 59 + ($category == null ? 43 : $category.hashCode());
        Object $room = this.getRoom();
        result = result * 59 + ($room == null ? 43 : $room.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        int var10000 = this.getId();
        return "Equipment(id=" + var10000 + ", name=" + this.getName() + ", puchase_date=" + String.valueOf(this.getPuchase_date()) + ", price=" + this.getPrice() + ", warranty_period=" + this.getWarranty_period() + ", category=" + String.valueOf(this.getCategory()) + ", room=" + String.valueOf(this.getRoom()) + ", is_deleted=" + this.is_deleted() + ")";
    }

    @Generated
    public Equipment() {
    }

    @Generated
    public Equipment(final int id, final String name, final Date puchase_date, final int price, final int warranty_period, final EpCategory category, final Room room, final boolean is_deleted) {
        this.id = id;
        this.name = name;
        this.puchase_date = puchase_date;
        this.price = price;
        this.warranty_period = warranty_period;
        this.category = category;
        this.room = room;
        this.is_deleted = is_deleted;
    }
}

//package com.example.ITSSBE.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.Date;
//
//@Entity
//@Table( name = "equipment")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//
//public class Equipment {
//    @Id
//    @GeneratedValue( strategy = GenerationType.IDENTITY)
//    @Column( name = "id")
//    private int id;
//    @Column( name = "name")
//    private String name;
//    @Column( name = "purchase_date")
//    private Date puchase_date;
//    @Column( name = "price")
//    private int price;
//    @Column( name = "warranty_period")
//    private int warranty_period;
//    @ManyToOne( fetch = FetchType.EAGER)
//    @JoinColumn( name = "category")
//    private EpCategory category;
//    @ManyToOne( fetch = FetchType.EAGER)
//    @JoinColumn( name = "room")
//    private Room room;
//    @Column( name = "is_deleted")
//    private boolean is_deleted;
//}
