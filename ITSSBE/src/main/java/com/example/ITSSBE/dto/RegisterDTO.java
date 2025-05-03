//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.dto;

import java.util.Date;
import lombok.Generated;

public class RegisterDTO {
    private int id;
    private Date created_at;
    private int my_package_id;
    private String my_package_name;
    private int price;
    private int register_by_id;
    private Boolean is_registered;
    private String register_by_name;
    private int trainer_id;
    private String trainer_name;
    private int customer_id;
    private String customer_name;
    private String gmail;

    @Generated
    public int getId() {
        return this.id;
    }

    @Generated
    public Date getCreated_at() {
        return this.created_at;
    }

    @Generated
    public int getMy_package_id() {
        return this.my_package_id;
    }

    @Generated
    public String getMy_package_name() {
        return this.my_package_name;
    }

    @Generated
    public int getPrice() {
        return this.price;
    }

    @Generated
    public int getRegister_by_id() {
        return this.register_by_id;
    }

    @Generated
    public Boolean getIs_registered() {
        return this.is_registered;
    }

    @Generated
    public String getRegister_by_name() {
        return this.register_by_name;
    }

    @Generated
    public int getTrainer_id() {
        return this.trainer_id;
    }

    @Generated
    public String getTrainer_name() {
        return this.trainer_name;
    }

    @Generated
    public int getCustomer_id() {
        return this.customer_id;
    }

    @Generated
    public String getCustomer_name() {
        return this.customer_name;
    }

    @Generated
    public String getGmail() {
        return this.gmail;
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
    public void setMy_package_id(final int my_package_id) {
        this.my_package_id = my_package_id;
    }

    @Generated
    public void setMy_package_name(final String my_package_name) {
        this.my_package_name = my_package_name;
    }

    @Generated
    public void setPrice(final int price) {
        this.price = price;
    }

    @Generated
    public void setRegister_by_id(final int register_by_id) {
        this.register_by_id = register_by_id;
    }

    @Generated
    public void setIs_registered(final Boolean is_registered) {
        this.is_registered = is_registered;
    }

    @Generated
    public void setRegister_by_name(final String register_by_name) {
        this.register_by_name = register_by_name;
    }

    @Generated
    public void setTrainer_id(final int trainer_id) {
        this.trainer_id = trainer_id;
    }

    @Generated
    public void setTrainer_name(final String trainer_name) {
        this.trainer_name = trainer_name;
    }

    @Generated
    public void setCustomer_id(final int customer_id) {
        this.customer_id = customer_id;
    }

    @Generated
    public void setCustomer_name(final String customer_name) {
        this.customer_name = customer_name;
    }

    @Generated
    public void setGmail(final String gmail) {
        this.gmail = gmail;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof RegisterDTO)) {
            return false;
        } else {
            RegisterDTO other = (RegisterDTO)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getId() != other.getId()) {
                return false;
            } else if (this.getMy_package_id() != other.getMy_package_id()) {
                return false;
            } else if (this.getPrice() != other.getPrice()) {
                return false;
            } else if (this.getRegister_by_id() != other.getRegister_by_id()) {
                return false;
            } else if (this.getTrainer_id() != other.getTrainer_id()) {
                return false;
            } else if (this.getCustomer_id() != other.getCustomer_id()) {
                return false;
            } else {
                Object this$is_registered = this.getIs_registered();
                Object other$is_registered = other.getIs_registered();
                if (this$is_registered == null) {
                    if (other$is_registered != null) {
                        return false;
                    }
                } else if (!this$is_registered.equals(other$is_registered)) {
                    return false;
                }

                label103: {
                    Object this$created_at = this.getCreated_at();
                    Object other$created_at = other.getCreated_at();
                    if (this$created_at == null) {
                        if (other$created_at == null) {
                            break label103;
                        }
                    } else if (this$created_at.equals(other$created_at)) {
                        break label103;
                    }

                    return false;
                }

                Object this$my_package_name = this.getMy_package_name();
                Object other$my_package_name = other.getMy_package_name();
                if (this$my_package_name == null) {
                    if (other$my_package_name != null) {
                        return false;
                    }
                } else if (!this$my_package_name.equals(other$my_package_name)) {
                    return false;
                }

                label89: {
                    Object this$register_by_name = this.getRegister_by_name();
                    Object other$register_by_name = other.getRegister_by_name();
                    if (this$register_by_name == null) {
                        if (other$register_by_name == null) {
                            break label89;
                        }
                    } else if (this$register_by_name.equals(other$register_by_name)) {
                        break label89;
                    }

                    return false;
                }

                Object this$trainer_name = this.getTrainer_name();
                Object other$trainer_name = other.getTrainer_name();
                if (this$trainer_name == null) {
                    if (other$trainer_name != null) {
                        return false;
                    }
                } else if (!this$trainer_name.equals(other$trainer_name)) {
                    return false;
                }

                Object this$customer_name = this.getCustomer_name();
                Object other$customer_name = other.getCustomer_name();
                if (this$customer_name == null) {
                    if (other$customer_name != null) {
                        return false;
                    }
                } else if (!this$customer_name.equals(other$customer_name)) {
                    return false;
                }

                Object this$gmail = this.getGmail();
                Object other$gmail = other.getGmail();
                if (this$gmail == null) {
                    if (other$gmail != null) {
                        return false;
                    }
                } else if (!this$gmail.equals(other$gmail)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof RegisterDTO;
    }

    @Generated
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getId();
        result = result * 59 + this.getMy_package_id();
        result = result * 59 + this.getPrice();
        result = result * 59 + this.getRegister_by_id();
        result = result * 59 + this.getTrainer_id();
        result = result * 59 + this.getCustomer_id();
        Object $is_registered = this.getIs_registered();
        result = result * 59 + ($is_registered == null ? 43 : $is_registered.hashCode());
        Object $created_at = this.getCreated_at();
        result = result * 59 + ($created_at == null ? 43 : $created_at.hashCode());
        Object $my_package_name = this.getMy_package_name();
        result = result * 59 + ($my_package_name == null ? 43 : $my_package_name.hashCode());
        Object $register_by_name = this.getRegister_by_name();
        result = result * 59 + ($register_by_name == null ? 43 : $register_by_name.hashCode());
        Object $trainer_name = this.getTrainer_name();
        result = result * 59 + ($trainer_name == null ? 43 : $trainer_name.hashCode());
        Object $customer_name = this.getCustomer_name();
        result = result * 59 + ($customer_name == null ? 43 : $customer_name.hashCode());
        Object $gmail = this.getGmail();
        result = result * 59 + ($gmail == null ? 43 : $gmail.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        int var10000 = this.getId();
        return "RegisterDTO(id=" + var10000 + ", created_at=" + String.valueOf(this.getCreated_at()) + ", my_package_id=" + this.getMy_package_id() + ", my_package_name=" + this.getMy_package_name() + ", price=" + this.getPrice() + ", register_by_id=" + this.getRegister_by_id() + ", is_registered=" + String.valueOf(this.getIs_registered()) + ", register_by_name=" + this.getRegister_by_name() + ", trainer_id=" + this.getTrainer_id() + ", trainer_name=" + this.getTrainer_name() + ", customer_id=" + this.getCustomer_id() + ", customer_name=" + this.getCustomer_name() + ", gmail=" + this.getGmail() + ")";
    }

    @Generated
    public RegisterDTO(final int id, final Date created_at, final int my_package_id, final String my_package_name, final int price, final int register_by_id, final Boolean is_registered, final String register_by_name, final int trainer_id, final String trainer_name, final int customer_id, final String customer_name, final String gmail) {
        this.id = id;
        this.created_at = created_at;
        this.my_package_id = my_package_id;
        this.my_package_name = my_package_name;
        this.price = price;
        this.register_by_id = register_by_id;
        this.is_registered = is_registered;
        this.register_by_name = register_by_name;
        this.trainer_id = trainer_id;
        this.trainer_name = trainer_name;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.gmail = gmail;
    }

    @Generated
    public RegisterDTO() {
    }
}

//package com.example.ITSSBE.dto;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.Date;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class RegisterDTO {
//    private int id;
//    private Date created_at;
//    private int my_package_id;
//    private String my_package_name;
//    private int price;
//    private int register_by_id;
//    private Boolean is_registered;
//    private String register_by_name;
//    private int trainer_id;
//    private String trainer_name;
//
//    private int customer_id;
//    private String customer_name;
//    private String gmail;
//
//}
