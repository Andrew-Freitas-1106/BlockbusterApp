package qa.andrew.springboot.blockbuster.myBlockbusterApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qa.andrew.springboot.blockbuster.myBlockbusterApp.model.MyBlockbusterAppUserDataModel;

@Repository
public interface MyBlockbusterAppUserRepository extends JpaRepository<MyBlockbusterAppUserDataModel,Long> {

}
