package qa.andrew.springboot.blockbuster.myBlockbusterApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qa.andrew.springboot.blockbuster.myBlockbusterApp.model.MyBlockbusterAppDataModel;

@Repository
public interface MyBlockbusterAppRepository extends JpaRepository<MyBlockbusterAppDataModel,Long> {

}
