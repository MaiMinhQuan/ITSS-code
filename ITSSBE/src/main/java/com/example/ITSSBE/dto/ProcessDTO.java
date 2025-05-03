//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.dto;

import java.util.Date;
import lombok.Generated;

public class ProcessDTO {
    private int id;
    private Date created_at;
    private String content;
    private int register_id;

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
    public int getRegister_id() {
        return this.register_id;
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
    public void setRegister_id(final int register_id) {
        this.register_id = register_id;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ProcessDTO)) {
            return false;
        } else {
            ProcessDTO other = (ProcessDTO)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getId() != other.getId()) {
                return false;
            } else if (this.getRegister_id() != other.getRegister_id()) {
                return false;
            } else {
                label40: {
                    Object this$created_at = this.getCreated_at();
                    Object other$created_at = other.getCreated_at();
                    if (this$created_at == null) {
                        if (other$created_at == null) {
                            break label40;
                        }
                    } else if (this$created_at.equals(other$created_at)) {
                        break label40;
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

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof ProcessDTO;
    }

    @Generated
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getId();
        result = result * 59 + this.getRegister_id();
        Object $created_at = this.getCreated_at();
        result = result * 59 + ($created_at == null ? 43 : $created_at.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        int var10000 = this.getId();
        return "ProcessDTO(id=" + var10000 + ", created_at=" + String.valueOf(this.getCreated_at()) + ", content=" + this.getContent() + ", register_id=" + this.getRegister_id() + ")";
    }

    @Generated
    public ProcessDTO(final int id, final Date created_at, final String content, final int register_id) {
        this.id = id;
        this.created_at = created_at;
        this.content = content;
        this.register_id = register_id;
    }

    @Generated
    public ProcessDTO() {
    }
}

//package com.example.ITSSBE.dto;
//
//import com.example.ITSSBE.entity.User;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.Date;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class ProcessDTO {
//    private int id;
//    private Date created_at;
//    private String content;
//    private int register_id;
//}
