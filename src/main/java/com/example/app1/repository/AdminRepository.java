package com.example.app1.repository;

import com.example.app1.entity.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Page<Admin> findAll( Pageable pageable);
    
    @Modifying
    @Transactional
    @Query("UPDATE Admin u SET u.name = :name WHERE u.id = :id")
	public int updateQuery(@Param("id")Long id,@Param("name")String name);
    
    @Modifying
    @Transactional
    @Query("DELETE FROM Admin a WHERE a.name = :name")
    int deleteQuery(@Param("name") String name);
    
    @Query("SELECT a FROM Admin a WHERE a.name = :name")
    List<Admin> selectAdminByName(@Param("name") String name);
    
    List<Admin> findByNameStartingWith(String prefix);
    List<Admin> findByNameEndingWith(String suffix);
    List<Admin> findByNameStartingWithOrNameEndingWith(String prefix, String suffix);
    
    List<Admin> findByNameContaining(String keyword);

    List<Admin> findByNameNotContaining(String keyword);
    
    @Query("SELECT a FROM Admin a WHERE a.name NOT LIKE :pattern")
    List<Admin> findByNameIsNotLike(@Param("pattern") String pattern);

    @Query("SELECT a FROM Admin a WHERE a.name LIKE :pattern")
    List<Admin> findByNameIsLike(@Param("pattern") String pattern);
    
    Optional<Admin>findByEmail(String email);
}


