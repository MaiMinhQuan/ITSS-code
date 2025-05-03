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
        name = "register"
)
public class Register {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    private int id;
    @Column(
            name = "created_at"
    )
    private Date created_at;
    @Column(
            name = "is_deleted"
    )
    private Boolean is_deleted;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "package"
    )
    private Package my_package;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "register_by"
    )
    private User register_by;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "trainer"
    )
    private User trainer;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "customer"
    )
    private User customer;
    @Column(
            name = "price"
    )
    private int price;

    @Generated
    public int getId() {
        return this.id;
    }

    @Generated
    public Date getCreated_at() {
        return this.created_at;
    }

    @Generated
    public Boolean getIs_deleted() {
        return this.is_deleted;
    }

    @Generated
    public Package getMy_package() {
        return this.my_package;
    }

    @Generated
    public User getRegister_by() {
        return this.register_by;
    }

    @Generated
    public User getTrainer() {
        return this.trainer;
    }

    @Generated
    public User getCustomer() {
        return this.customer;
    }

    @Generated
    public int getPrice() {
        return this.price;
    }

    @Generated
    public void setId(final int id) {
        this.id = id;
    }

    @Generated
    public void setCreated_at(final Date created_at) {
        this.created_at = created_at;
    }

    @Generated
    public void setIs_deleted(final Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    @Generated
    public void setMy_package(final Package my_package) {
        this.my_package = my_package;
    }

    @Generated
    public void setRegister_by(final User register_by) {
        this.register_by = register_by;
    }

    @Generated
    public void setTrainer(final User trainer) {
        this.trainer = trainer;
    }

    @Generated
    public void setCustomer(final User customer) {
        this.customer = customer;
    }

    @Generated
    public void setPrice(final int price) {
        this.price = price;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Register)) {
            return false;
        } else {
            Register other = (Register)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getId() != other.getId()) {
                return false;
            } else if (this.getPrice() != other.getPrice()) {
                return false;
            } else {
                label88: {
                    Object this$is_deleted = this.getIs_deleted();
                    Object other$is_deleted = other.getIs_deleted();
                    if (this$is_deleted == null) {
                        if (other$is_deleted == null) {
                            break label88;
                        }
                    } else if (this$is_deleted.equals(other$is_deleted)) {
                        break label88;
                    }

                    return false;
                }

                Object this$created_at = this.getCreated_at();
                Object other$created_at = other.getCreated_at();
                if (this$created_at == null) {
                    if (other$created_at != null) {
                        return false;
                    }
                } else if (!this$created_at.equals(other$created_at)) {
                    return false;
                }

                label74: {
                    Object this$my_package = this.getMy_package();
                    Object other$my_package = other.getMy_package();
                    if (this$my_package == null) {
                        if (other$my_package == null) {
                            break label74;
                        }
                    } else if (this$my_package.equals(other$my_package)) {
                        break label74;
                    }

                    return false;
                }

                label67: {
                    Object this$register_by = this.getRegister_by();
                    Object other$register_by = other.getRegister_by();
                    if (this$register_by == null) {
                        if (other$register_by == null) {
                            break label67;
                        }
                    } else if (this$register_by.equals(other$register_by)) {
                        break label67;
                    }

                    return false;
                }

                Object this$trainer = this.getTrainer();
                Object other$trainer = other.getTrainer();
                if (this$trainer == null) {
                    if (other$trainer != null) {
                        return false;
                    }
                } else if (!this$trainer.equals(other$trainer)) {
                    return false;
                }

                Object this$customer = this.getCustomer();
                Object other$customer = other.getCustomer();
                if (this$customer == null) {
                    if (other$customer != null) {
                        return false;
                    }
                } else if (!this$customer.equals(other$customer)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof Register;
    }

    @Generated
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getId();
        result = result * 59 + this.getPrice();
        Object $is_deleted = this.getIs_deleted();
        result = result * 59 + ($is_deleted == null ? 43 : $is_deleted.hashCode());
        Object $created_at = this.getCreated_at();
        result = result * 59 + ($created_at == null ? 43 : $created_at.hashCode());
        Object $my_package = this.getMy_package();
        result = result * 59 + ($my_package == null ? 43 : $my_package.hashCode());
        Object $register_by = this.getRegister_by();
        result = result * 59 + ($register_by == null ? 43 : $register_by.hashCode());
        Object $trainer = this.getTrainer();
        result = result * 59 + ($trainer == null ? 43 : $trainer.hashCode());
        Object $customer = this.getCustomer();
        result = result * 59 + ($customer == null ? 43 : $customer.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        int var10000 = this.getId();
        return "Register(id=" + var10000 + ", created_at=" + String.valueOf(this.getCreated_at()) + ", is_deleted=" + String.valueOf(this.getIs_deleted()) + ", my_package=" + String.valueOf(this.getMy_package()) + ", register_by=" + String.valueOf(this.getRegister_by()) + ", trainer=" + String.valueOf(this.getTrainer()) + ", customer=" + String.valueOf(this.getCustomer()) + ", price=" + this.getPrice() + ")";
    }

    @Generated
    public Register(final int id, final Date created_at, final Boolean is_deleted, final Package my_package, final User register_by, final User trainer, final User customer, final int price) {
        this.id = id;
        this.created_at = created_at;
        this.is_deleted = is_deleted;
        this.my_package = my_package;
        this.register_by = register_by;
        this.trainer = trainer;
        this.customer = customer;
        this.price = price;
    }

    @Generated
    public Register() {
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
//@Table( name = "register")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Register {
//    @Id
//    @GeneratedValue( strategy = GenerationType.IDENTITY )
//    @Column(name = "id")
//    private int id;
//    @Column( name = "created_at")
//    private Date created_at;
//    @Column( name = "is_deleted")
//    private Boolean is_deleted;
//    @ManyToOne( fetch = FetchType.EAGER)
//    @JoinColumn( name = "package")
//    private Package my_package;
//    @ManyToOne( fetch = FetchType.EAGER)
//    @JoinColumn( name = "register_by")
//    private User register_by;
//    @ManyToOne( fetch = FetchType.EAGER)
//    @JoinColumn( name = "trainer")
//    private User trainer;
//    @ManyToOne( fetch = FetchType.EAGER)
//    @JoinColumn( name = "customer")
//    private User customer;
//    @Column( name =  "price")
//    private int price;
//
//}
