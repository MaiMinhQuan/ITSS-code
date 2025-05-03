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
        name = "user"
)
public class User {
    @Id
    @Column(
            name = "id"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @Column(
            name = "first_name"
    )
    private String first_name;
    @Column(
            name = "last_name"
    )
    private String last_name;
    @Column(
            name = "birth"
    )
    private Date birth;
    @Column(
            name = "gender"
    )
    private String gender;
    @Column(
            name = "gmail"
    )
    private String gmail;
    @Column(
            name = "password"
    )
    private String password;
    @Column(
            name = "phone"
    )
    private String phone;
    @Column(
            name = "avatar"
    )
    private String avatar;
    @Column(
            name = "is_deleted"
    )
    private Boolean is_deleted;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "role"
    )
    private Role role;

    @Generated
    public int getId() {
        return this.id;
    }

    @Generated
    public String getFirst_name() {
        return this.first_name;
    }

    @Generated
    public String getLast_name() {
        return this.last_name;
    }

    @Generated
    public Date getBirth() {
        return this.birth;
    }

    @Generated
    public String getGender() {
        return this.gender;
    }

    @Generated
    public String getGmail() {
        return this.gmail;
    }

    @Generated
    public String getPassword() {
        return this.password;
    }

    @Generated
    public String getPhone() {
        return this.phone;
    }

    @Generated
    public String getAvatar() {
        return this.avatar;
    }

    @Generated
    public Boolean getIs_deleted() {
        return this.is_deleted;
    }

    @Generated
    public Role getRole() {
        return this.role;
    }

    @Generated
    public void setId(final int id) {
        this.id = id;
    }

    @Generated
    public void setFirst_name(final String first_name) {
        this.first_name = first_name;
    }

    @Generated
    public void setLast_name(final String last_name) {
        this.last_name = last_name;
    }

    @Generated
    public void setBirth(final Date birth) {
        this.birth = birth;
    }

    @Generated
    public void setGender(final String gender) {
        this.gender = gender;
    }

    @Generated
    public void setGmail(final String gmail) {
        this.gmail = gmail;
    }

    @Generated
    public void setPassword(final String password) {
        this.password = password;
    }

    @Generated
    public void setPhone(final String phone) {
        this.phone = phone;
    }

    @Generated
    public void setAvatar(final String avatar) {
        this.avatar = avatar;
    }

    @Generated
    public void setIs_deleted(final Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    @Generated
    public void setRole(final Role role) {
        this.role = role;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof User)) {
            return false;
        } else {
            User other = (User)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getId() != other.getId()) {
                return false;
            } else {
                Object this$is_deleted = this.getIs_deleted();
                Object other$is_deleted = other.getIs_deleted();
                if (this$is_deleted == null) {
                    if (other$is_deleted != null) {
                        return false;
                    }
                } else if (!this$is_deleted.equals(other$is_deleted)) {
                    return false;
                }

                Object this$first_name = this.getFirst_name();
                Object other$first_name = other.getFirst_name();
                if (this$first_name == null) {
                    if (other$first_name != null) {
                        return false;
                    }
                } else if (!this$first_name.equals(other$first_name)) {
                    return false;
                }

                label119: {
                    Object this$last_name = this.getLast_name();
                    Object other$last_name = other.getLast_name();
                    if (this$last_name == null) {
                        if (other$last_name == null) {
                            break label119;
                        }
                    } else if (this$last_name.equals(other$last_name)) {
                        break label119;
                    }

                    return false;
                }

                label112: {
                    Object this$birth = this.getBirth();
                    Object other$birth = other.getBirth();
                    if (this$birth == null) {
                        if (other$birth == null) {
                            break label112;
                        }
                    } else if (this$birth.equals(other$birth)) {
                        break label112;
                    }

                    return false;
                }

                Object this$gender = this.getGender();
                Object other$gender = other.getGender();
                if (this$gender == null) {
                    if (other$gender != null) {
                        return false;
                    }
                } else if (!this$gender.equals(other$gender)) {
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

                label91: {
                    Object this$password = this.getPassword();
                    Object other$password = other.getPassword();
                    if (this$password == null) {
                        if (other$password == null) {
                            break label91;
                        }
                    } else if (this$password.equals(other$password)) {
                        break label91;
                    }

                    return false;
                }

                Object this$phone = this.getPhone();
                Object other$phone = other.getPhone();
                if (this$phone == null) {
                    if (other$phone != null) {
                        return false;
                    }
                } else if (!this$phone.equals(other$phone)) {
                    return false;
                }

                Object this$avatar = this.getAvatar();
                Object other$avatar = other.getAvatar();
                if (this$avatar == null) {
                    if (other$avatar != null) {
                        return false;
                    }
                } else if (!this$avatar.equals(other$avatar)) {
                    return false;
                }

                Object this$role = this.getRole();
                Object other$role = other.getRole();
                if (this$role == null) {
                    if (other$role != null) {
                        return false;
                    }
                } else if (!this$role.equals(other$role)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    @Generated
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getId();
        Object $is_deleted = this.getIs_deleted();
        result = result * 59 + ($is_deleted == null ? 43 : $is_deleted.hashCode());
        Object $first_name = this.getFirst_name();
        result = result * 59 + ($first_name == null ? 43 : $first_name.hashCode());
        Object $last_name = this.getLast_name();
        result = result * 59 + ($last_name == null ? 43 : $last_name.hashCode());
        Object $birth = this.getBirth();
        result = result * 59 + ($birth == null ? 43 : $birth.hashCode());
        Object $gender = this.getGender();
        result = result * 59 + ($gender == null ? 43 : $gender.hashCode());
        Object $gmail = this.getGmail();
        result = result * 59 + ($gmail == null ? 43 : $gmail.hashCode());
        Object $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        Object $phone = this.getPhone();
        result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
        Object $avatar = this.getAvatar();
        result = result * 59 + ($avatar == null ? 43 : $avatar.hashCode());
        Object $role = this.getRole();
        result = result * 59 + ($role == null ? 43 : $role.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        int var10000 = this.getId();
        return "User(id=" + var10000 + ", first_name=" + this.getFirst_name() + ", last_name=" + this.getLast_name() + ", birth=" + String.valueOf(this.getBirth()) + ", gender=" + this.getGender() + ", gmail=" + this.getGmail() + ", password=" + this.getPassword() + ", phone=" + this.getPhone() + ", avatar=" + this.getAvatar() + ", is_deleted=" + String.valueOf(this.getIs_deleted()) + ", role=" + String.valueOf(this.getRole()) + ")";
    }

    @Generated
    public User(final int id, final String first_name, final String last_name, final Date birth, final String gender, final String gmail, final String password, final String phone, final String avatar, final Boolean is_deleted, final Role role) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth = birth;
        this.gender = gender;
        this.gmail = gmail;
        this.password = password;
        this.phone = phone;
        this.avatar = avatar;
        this.is_deleted = is_deleted;
        this.role = role;
    }

    @Generated
    public User() {
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
//@Table(name = "user")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class User {
//    @Id
//    @Column( name = "id")
//    @GeneratedValue( strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(name = "first_name")
//    private String first_name;
//    @Column( name = "last_name")
//    private String last_name;
//    @Column( name = "birth")
//    private Date birth;
//    @Column( name = "gender")
//    private String gender;
//    @Column( name = "gmail")
//    private String gmail;
//    @Column( name = "password")
//    private String password;
//    @Column( name = "phone")
//    private String phone;
//    @Column( name = "avatar")
//    private String avatar;
//    @Column( name = "is_deleted")
//    private Boolean is_deleted;
//    @ManyToOne( fetch = FetchType.EAGER)
//    @JoinColumn( name = "role")
//    private Role role;
//}
