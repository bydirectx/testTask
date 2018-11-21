package ml.bondarev.m4bank.repository;

import ml.bondarev.m4bank.entity.Number;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NumberDao extends JpaRepository<Number, Integer> {

    @Query("SELECT se FROM Number se WHERE se.name=:name")
    public Number getNumberByName(@Param("name") String name);

    @Query("SELECT se.value FROM Number se WHERE se.name=:name")
    public int getValueNumberByName(@Param("name") String name);

    public void removeNumberByName(@Param("name") String name);

}
