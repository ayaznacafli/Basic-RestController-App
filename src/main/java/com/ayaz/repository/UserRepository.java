package com.ayaz.repository;


import com.ayaz.model.User;
import java.util.List;
import javax.persistence.LockModeType;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User,String> {

    //index query
    @Query("SELECT u FROM  User u where u.address=?1")
    List<User> getAllUsersByName(String address);

    //named query
    @Query(value ="SELECT u FROM  User u where u.addresss=:address",nativeQuery = true)
    List<User> getUsersByAddress(@Param("address")String address);

    //
    @Lock(LockModeType.WRITE)
    @Transactional
    @Modifying
    @Query("update User u set u.address=?2 where u.id=?1")
    void updateAddress(String id, String newAddress);

    //
    @Lock(LockModeType.READ)
    @Query("select u from User u where u.name=:name")
    List<User> getUsersByNameAndSort(@Param("gender")String gender1, Sort sort);
}
