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
        name = "room"
)
public class Room {
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
            name = "address"
    )
    private String address;
    @Column(
            name = "acreage"
    )
    private int acreage;
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
    public String getAddress() {
        return this.address;
    }

    @Generated
    public int getAcreage() {
        return this.acreage;
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
    public void setAddress(final String address) {
        this.address = address;
    }

    @Generated
    public void setAcreage(final int acreage) {
        this.acreage = acreage;
    }

    @Generated
    public void set_deleted(final boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Room)) {
            return false;
        } else {
            Room other = (Room)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getId() != other.getId()) {
                return false;
            } else if (this.getAcreage() != other.getAcreage()) {
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

                Object this$address = this.getAddress();
                Object other$address = other.getAddress();
                if (this$address == null) {
                    if (other$address != null) {
                        return false;
                    }
                } else if (!this$address.equals(other$address)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof Room;
    }

    @Generated
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getId();
        result = result * 59 + this.getAcreage();
        result = result * 59 + (this.is_deleted() ? 79 : 97);
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $address = this.getAddress();
        result = result * 59 + ($address == null ? 43 : $address.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        int var10000 = this.getId();
        return "Room(id=" + var10000 + ", name=" + this.getName() + ", address=" + this.getAddress() + ", acreage=" + this.getAcreage() + ", is_deleted=" + this.is_deleted() + ")";
    }

    @Generated
    public Room(final int id, final String name, final String address, final int acreage, final boolean is_deleted) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.acreage = acreage;
        this.is_deleted = is_deleted;
    }

    @Generated
    public Room() {
    }
}
