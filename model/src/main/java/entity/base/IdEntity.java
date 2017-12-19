package entity.base;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by jerry on 17-6-27.
 */

@MappedSuperclass
public abstract class IdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
    @GenericGenerator(name = "generator", strategy = "uuid")
    @Access(AccessType.PROPERTY)
    @Column(name = "id", length = _id_len)
    private String id;
    public static final String _id = "id";
    public static final int _id_len = 36;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
