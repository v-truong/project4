package com.example.security.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.security.entity.Technical;

@Repository
public interface TechnicalRepo extends JpaRepository<Technical,String>, JpaSpecificationExecutor<Technical> {

     List<Technical> findAllByIsDelete(Integer isDelete);
     Optional<Technical> findByName(String name);
//     List<String> findAllIds();
     List<Technical> findByIdIn(List<String> Ids);

    
}
