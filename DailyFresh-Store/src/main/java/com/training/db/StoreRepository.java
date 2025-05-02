package com.training.db;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.training.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer>{
	

}