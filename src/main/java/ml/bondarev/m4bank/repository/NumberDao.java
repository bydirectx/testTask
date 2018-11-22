package ml.bondarev.m4bank.repository;

import ml.bondarev.m4bank.entity.NumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NumberDao extends JpaRepository<NumberEntity, Integer> {

    @Query("SELECT se FROM NumberEntity se WHERE se.name=:name")
    public NumberEntity getNumberByName(@Param("name") String name);

    @Query("SELECT se.value FROM NumberEntity se WHERE se.name=:name")
    public int getValueNumberByName(@Param("name") String name);

}
