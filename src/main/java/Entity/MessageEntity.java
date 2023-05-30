package Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "message", schema = "chatapp")
public class MessageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idMessage")
    private int idMessage;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "timestamp")
    private Date timestamp;
    @Basic
    @Column(name = "iduser")
    private int iduser;
//    @ManyToOne
//    @JoinColumn(name = "iduser", referencedColumnName = "iduser", nullable = false)
//    private UsersEntity usersByIduser;

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (idMessage != that.idMessage) return false;
        if (iduser != that.iduser) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMessage;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + iduser;
        return result;
    }

//    public UsersEntity getUsersByIduser() {
//        return usersByIduser;
//    }
//
//    public void setUsersByIduser(UsersEntity usersByIduser) {
//        this.usersByIduser = usersByIduser;
//    }
}
