//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.dto;

import java.util.Date;
import lombok.Generated;

public class EquipmentDTO {
    private int id;
    private String name;
    private Date purchase_date;
    private int price;
    private int warranty_period;
    private int category_id;
    private String category_name;
    private int room_id;
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
    public Date getPurchase_date() {
        return this.purchase_date;
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
    public int getCategory_id() {
        return this.category_id;
    }

    @Generated
    public String getCategory_name() {
        return this.category_name;
    }

    @Generated
    public int getRoom_id() {
        return this.room_id;
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
    public void setPurchase_date(final Date purchase_date) {
        this.purchase_date = purchase_date;
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
    public void setCategory_id(final int category_id) {
        this.category_id = category_id;
    }

    @Generated
    public void setCategory_name(final String category_name) {
        this.category_name = category_name;
    }

    @Generated
    public void setRoom_id(final int room_id) {
        this.room_id = room_id;
    }

    @Generated
    public void set_deleted(final boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof EquipmentDTO)) {
            return false;
        } else {
            EquipmentDTO other = (EquipmentDTO)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getId() != other.getId()) {
                return false;
            } else if (this.getPrice() != other.getPrice()) {
                return false;
            } else if (this.getWarranty_period() != other.getWarranty_period()) {
                return false;
            } else if (this.getCategory_id() != other.getCategory_id()) {
                return false;
            } else if (this.getRoom_id() != other.getRoom_id()) {
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

                label55: {
                    Object this$purchase_date = this.getPurchase_date();
                    Object other$purchase_date = other.getPurchase_date();
                    if (this$purchase_date == null) {
                        if (other$purchase_date == null) {
                            break label55;
                        }
                    } else if (this$purchase_date.equals(other$purchase_date)) {
                        break label55;
                    }

                    return false;
                }

                Object this$category_name = this.getCategory_name();
                Object other$category_name = other.getCategory_name();
                if (this$category_name == null) {
                    if (other$category_name != null) {
                        return false;
                    }
                } else if (!this$category_name.equals(other$category_name)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof EquipmentDTO;
    }

    @Generated
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getId();
        result = result * 59 + this.getPrice();
        result = result * 59 + this.getWarranty_period();
        result = result * 59 + this.getCategory_id();
        result = result * 59 + this.getRoom_id();
        result = result * 59 + (this.is_deleted() ? 79 : 97);
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $purchase_date = this.getPurchase_date();
        result = result * 59 + ($purchase_date == null ? 43 : $purchase_date.hashCode());
        Object $category_name = this.getCategory_name();
        result = result * 59 + ($category_name == null ? 43 : $category_name.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        int var10000 = this.getId();
        return "EquipmentDTO(id=" + var10000 + ", name=" + this.getName() + ", purchase_date=" + String.valueOf(this.getPurchase_date()) + ", price=" + this.getPrice() + ", warranty_period=" + this.getWarranty_period() + ", category_id=" + this.getCategory_id() + ", category_name=" + this.getCategory_name() + ", room_id=" + this.getRoom_id() + ", is_deleted=" + this.is_deleted() + ")";
    }

    @Generated
    public EquipmentDTO(final int id, final String name, final Date purchase_date, final int price, final int warranty_period, final int category_id, final String category_name, final int room_id, final boolean is_deleted) {
        this.id = id;
        this.name = name;
        this.purchase_date = purchase_date;
        this.price = price;
        this.warranty_period = warranty_period;
        this.category_id = category_id;
        this.category_name = category_name;
        this.room_id = room_id;
        this.is_deleted = is_deleted;
    }

    @Generated
    public EquipmentDTO() {
    }
}
