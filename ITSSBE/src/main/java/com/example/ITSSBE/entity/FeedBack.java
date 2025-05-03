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
        name = "feedback"
)
public class FeedBack {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    private int id;
    @Column(
            name = "content"
    )
    private String content;
    @Column(
            name = "created_at"
    )
    private Date created_at;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "user"
    )
    private User by_user;
    @Column(
            name = "is_deleted"
    )
    private boolean is_deleted;
    @Column(
            name = "parent_feedback_id"
    )
    private int parent_feedback_id;

    @Generated
    public int getId() {
        return this.id;
    }

    @Generated
    public String getContent() {
        return this.content;
    }

    @Generated
    public Date getCreated_at() {
        return this.created_at;
    }

    @Generated
    public User getBy_user() {
        return this.by_user;
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
    public void setContent(final String content) {
        this.content = content;
    }

    @Generated
    public void setCreated_at(final Date created_at) {
        this.created_at = created_at;
    }

    @Generated
    public void setBy_user(final User by_user) {
        this.by_user = by_user;
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
        } else if (!(o instanceof FeedBack)) {
            return false;
        } else {
            FeedBack other = (FeedBack)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getId() != other.getId()) {
                return false;
            } else if (this.is_deleted() != other.is_deleted()) {
                return false;
            } else if (this.getParent_feedback_id() != other.getParent_feedback_id()) {
                return false;
            } else {
                label54: {
                    Object this$content = this.getContent();
                    Object other$content = other.getContent();
                    if (this$content == null) {
                        if (other$content == null) {
                            break label54;
                        }
                    } else if (this$content.equals(other$content)) {
                        break label54;
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

                Object this$by_user = this.getBy_user();
                Object other$by_user = other.getBy_user();
                if (this$by_user == null) {
                    if (other$by_user != null) {
                        return false;
                    }
                } else if (!this$by_user.equals(other$by_user)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof FeedBack;
    }

    @Generated
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getId();
        result = result * 59 + (this.is_deleted() ? 79 : 97);
        result = result * 59 + this.getParent_feedback_id();
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        Object $created_at = this.getCreated_at();
        result = result * 59 + ($created_at == null ? 43 : $created_at.hashCode());
        Object $by_user = this.getBy_user();
        result = result * 59 + ($by_user == null ? 43 : $by_user.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        int var10000 = this.getId();
        return "FeedBack(id=" + var10000 + ", content=" + this.getContent() + ", created_at=" + String.valueOf(this.getCreated_at()) + ", by_user=" + String.valueOf(this.getBy_user()) + ", is_deleted=" + this.is_deleted() + ", parent_feedback_id=" + this.getParent_feedback_id() + ")";
    }

    @Generated
    public FeedBack() {
    }

    @Generated
    public FeedBack(final int id, final String content, final Date created_at, final User by_user, final boolean is_deleted, final int parent_feedback_id) {
        this.id = id;
        this.content = content;
        this.created_at = created_at;
        this.by_user = by_user;
        this.is_deleted = is_deleted;
        this.parent_feedback_id = parent_feedback_id;
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
//@Table( name = "feedback")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//
//public class FeedBack {
//    @Id
//    @GeneratedValue( strategy = GenerationType.IDENTITY)
//    @Column( name = "id")
//    private int id;
//    @Column( name = "content")
//    private String content;
//    @Column( name = "created_at")
//    private Date created_at;
//    @ManyToOne( fetch = FetchType.EAGER)
//    @JoinColumn( name = "user")
//    private User by_user;
//    @Column( name = "is_deleted")
//    private boolean is_deleted;
//    @Column( name = "parent_feedback_id")
//    private int parent_feedback_id;
//}
