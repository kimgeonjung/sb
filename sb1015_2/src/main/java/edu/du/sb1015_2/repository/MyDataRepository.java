package edu.du.sb1015_2.repository;

import edu.du.sb1015_2.entity.MyData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyDataRepository extends JpaRepository<MyData, Long> {
}
