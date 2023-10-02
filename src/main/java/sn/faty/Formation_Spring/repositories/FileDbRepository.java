package sn.faty.Formation_Spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.faty.Formation_Spring.entities.FileDB;

@Repository
public interface FileDbRepository extends JpaRepository<FileDB , Long> {


}
