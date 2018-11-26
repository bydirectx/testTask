package ml.bondarev.m4bank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NumberDao extends JpaRepository<NumberEntity, Integer> {

    @Query("SELECT ne FROM NumberEntity ne WHERE ne.name=:name")
    public NumberEntity getNumberByName(@Param("name") String name);

    @Query("SELECT ne.value FROM NumberEntity ne WHERE ne.name=:name")
    public int getValueNumberByName(@Param("name") String name);

    @Modifying
    @Query("DELETE FROM NumberEntity ne WHERE ne.name=:name")
    public void removeNumberEntityByName(@Param("name") String name);

}
