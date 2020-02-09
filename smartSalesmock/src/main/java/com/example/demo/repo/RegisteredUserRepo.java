package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.RegisteredUser;

@RepositoryRestResource()
public interface RegisteredUserRepo extends JpaRepository<RegisteredUser, Integer> {
	
	//Page<Event> findByNameAndDescription(@Param("name") String name, @Param("description") String description, Pageable pageable);
	//List<RegisteredUser> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

	Optional<RegisteredUser> findByUsername(@Param("username")String username);
	Optional<RegisteredUser> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

	
	// is it working
	
	
	
	
	
//	@Query("SELECT t FROM REGISTERED_USER t WHERE t.username = ?1 and t.password = ?2")
//	RegisteredUser findByUsernameAndPassword(String username, String password);
	
	//List<RegisteredUser> findByusername(String name);
	
	//@Query("SELECT H FROM REGISTERED_USER H WHERE H.username IN :username")
	//String findByusername(@Param("username") String username);
	
	//@Query("from REGISTERED_USER where username=?1 order by username")
	//List<RegisteredUser>findByusername(String username);
	
	
	//@Query("from REGISTERED_USER where username='komol'")
	//List<RegisteredUser> findByUP();

	
	
}


/*
 * 
insert into REGISTERED_USER values (1, 'kawranbazar', '2222', '222222', 'komol');
insert into REGISTERED_USER values (2, 'uttora', '4444', '1111', 'atiq');
insert into REGISTERED_USER values (3, 'farmgate', '6666', '8888', 'sohel');
insert into REGISTERED_USER values (4, 'bashundhara', '0000', '9999', 'mamun');

SELECT * FROM REGISTERED_USER 
 * 
 * 
 * 
 * 
 * */
