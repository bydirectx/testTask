package ml.bondarev.m4bank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "number_entity")
public class NumberEntity {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private int value;

    public NumberEntity() {
    }

    public NumberEntity(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
