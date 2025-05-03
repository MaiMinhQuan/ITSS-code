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
        name = "process"
)
public class Process {
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
            name = "content"
    )
    private String content;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "register"
    )
    private Register register;

    @Generated
    public int getId() {
        return this.id;
    }

    @Generated
    public Date getCreated_at() {
        return this.created_at;
    }

    @Generated
    public String getContent() {
        return this.content;
    }

    @Generated
    public Register getRegister() {
        return this.register;
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
    public void setContent(final String content) {
        this.content = content;
    }

    @Generated
    public void setRegister(final Register register) {
        this.register = register;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Process)) {
            return false;
        } else {
            Process other = (Process)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getId() != other.getId()) {
                return false;
            } else {
                label49: {
                    Object this$created_at = this.getCreated_at();
                    Object other$created_at = other.getCreated_at();
                    if (this$created_at == null) {
                        if (other$created_at == null) {
                            break label49;
                        }
                    } else if (this$created_at.equals(other$created_at)) {
                        break label49;
                    }

                    return false;
                }

                Object this$content = this.getContent();
                Object other$content = other.getContent();
                if (this$content == null) {
                    if (other$content != null) {
                        return false;
                    }
                } else if (!this$content.equals(other$content)) {
                    return false;
                }

                Object this$register = this.getRegister();
                Object other$register = other.getRegister();
                if (this$register == null) {
                    if (other$register != null) {
                        return false;
                    }
                } else if (!this$register.equals(other$register)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof Process;
    }

    @Generated
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getId();
        Object $created_at = this.getCreated_at();
        result = result * 59 + ($created_at == null ? 43 : $created_at.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        Object $register = this.getRegister();
        result = result * 59 + ($register == null ? 43 : $register.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        int var10000 = this.getId();
        return "Process(id=" + var10000 + ", created_at=" + String.valueOf(this.getCreated_at()) + ", content=" + this.getContent() + ", register=" + String.valueOf(this.getRegister()) + ")";
    }

    @Generated
    public Process(final int id, final Date created_at, final String content, final Register register) {
        this.id = id;
        this.created_at = created_at;
        this.content = content;
        this.register = register;
    }

    @Generated
    public Process() {
    }
}

//package com.example.ITSSBE.entity;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.Date;
//
//@Entity
//@Table(name = "process")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Process {
//    @Id
//    @GeneratedValue( strategy = GenerationType.IDENTITY)
//    @Column( name = "id")
//    private int id;
//    @Column( name = "created_at")
//    private Date created_at;
//    @Column( name = "content")
//    private String content;
//    @ManyToOne( fetch = FetchType.EAGER)
//    @JoinColumn( name = "register")
//    private Register register;
//
//}
