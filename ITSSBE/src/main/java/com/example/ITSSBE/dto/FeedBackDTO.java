//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.dto;

import java.util.Date;
import lombok.Generated;

public class FeedBackDTO {
    private int id;
    private Date created_at;
    private String content;
    private int user_id;
    private boolean is_deleted;
    private int parent_feedback_id;

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
    public int getUser_id() {
        return this.user_id;
    }

    @Generated
    public boolean is_deleted() {
        return this.is_deleted;
    }

    @Generated
    public int getParent_feedback_id() {
        return this.parent_feedback_id;
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
    public void setUser_id(final int user_id) {
        this.user_id = user_id;
    }

    @Generated
    public void set_deleted(final boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    @Generated
    public void setParent_feedback_id(final int parent_feedback_id) {
        this.parent_feedback_id = parent_feedback_id;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof FeedBackDTO)) {
            return false;
        } else {
            FeedBackDTO other = (FeedBackDTO)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getId() != other.getId()) {
                return false;
            } else if (this.getUser_id() != other.getUser_id()) {
                return false;
            } else if (this.is_deleted() != other.is_deleted()) {
                return false;
            } else if (this.getParent_feedback_id() != other.getParent_feedback_id()) {
                return false;
            } else {
                Object this$created_at = this.getCreated_at();
                Object other$created_at = other.getCreated_at();
                if (this$created_at == null) {
                    if (other$created_at != null) {
                        return false;
                    }
                } else if (!this$created_at.equals(other$created_at)) {
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
        return other instanceof FeedBackDTO;
    }

    @Generated
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getId();
        result = result * 59 + this.getUser_id();
        result = result * 59 + (this.is_deleted() ? 79 : 97);
        result = result * 59 + this.getParent_feedback_id();
        Object $created_at = this.getCreated_at();
        result = result * 59 + ($created_at == null ? 43 : $created_at.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        int var10000 = this.getId();
        return "FeedBackDTO(id=" + var10000 + ", created_at=" + String.valueOf(this.getCreated_at()) + ", content=" + this.getContent() + ", user_id=" + this.getUser_id() + ", is_deleted=" + this.is_deleted() + ", parent_feedback_id=" + this.getParent_feedback_id() + ")";
    }

    @Generated
    public FeedBackDTO(final int id, final Date created_at, final String content, final int user_id, final boolean is_deleted, final int parent_feedback_id) {
        this.id = id;
        this.created_at = created_at;
        this.content = content;
        this.user_id = user_id;
        this.is_deleted = is_deleted;
        this.parent_feedback_id = parent_feedback_id;
    }

    @Generated
    public FeedBackDTO() {
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
//public class FeedBackDTO {
//    private int id;
//    private Date created_at;
//    private String content;
//    private int user_id;
//    private boolean is_deleted;
//    private int parent_feedback_id;
//}
