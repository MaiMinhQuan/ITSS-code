//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Generated;

@Entity
@Table(
        name = "package"
)
public class Package {
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
            name = "price"
    )
    private int price;
    @Column(
            name = "description"
    )
    private String description;
    @Column(
            name = "is_deleted"
    )
    private boolean is_deleted;
    @Column(
            name = "time"
    )
    private int time;

    @Generated
    public int getId() {
        return this.id;
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public int getPrice() {
        return this.price;
    }

    @Generated
    public String getDescription() {
        return this.description;
    }

    @Generated
    public boolean is_deleted() {
        return this.is_deleted;
    }

    @Generated
    public int getTime() {
        return this.time;
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
    public void setPrice(final int price) {
        this.price = price;
    }

    @Generated
    public void setDescription(final String description) {
        this.description = description;
    }

    @Generated
    public void set_deleted(final boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    @Generated
    public void setTime(final int time) {
        this.time = time;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Package)) {
            return false;
        } else {
            Package other = (Package)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getId() != other.getId()) {
                return false;
            } else if (this.getPrice() != other.getPrice()) {
                return false;
            } else if (this.is_deleted() != other.is_deleted()) {
                return false;
            } else if (this.getTime() != other.getTime()) {
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

                Object this$description = this.getDescription();
                Object other$description = other.getDescription();
                if (this$description == null) {
                    if (other$description != null) {
                        return false;
                    }
                } else if (!this$description.equals(other$description)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof Package;
    }

    @Generated
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getId();
        result = result * 59 + this.getPrice();
        result = result * 59 + (this.is_deleted() ? 79 : 97);
        result = result * 59 + this.getTime();
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $description = this.getDescription();
        result = result * 59 + ($description == null ? 43 : $description.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        int var10000 = this.getId();
        return "Package(id=" + var10000 + ", name=" + this.getName() + ", price=" + this.getPrice() + ", description=" + this.getDescription() + ", is_deleted=" + this.is_deleted() + ", time=" + this.getTime() + ")";
    }

    @Generated
    public Package() {
    }

    @Generated
    public Package(final int id, final String name, final int price, final String description, final boolean is_deleted, final int time) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.is_deleted = is_deleted;
        this.time = time;
    }
}

//package com.example.ITSSBE.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table( name = "package")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Package {
//    @Id
//    @GeneratedValue( strategy = GenerationType.IDENTITY)
//    @Column( name = "id")
//    private int id;
//    @Column( name = "name")
//    private String name;
//    @Column( name = "price")
//    private int price;
//    @Column( name = "description")
//    private String description;
//    @Column( name = "is_deleted")
//    private boolean is_deleted;
//    @Column( name = "time")
//    private int time;
//}
