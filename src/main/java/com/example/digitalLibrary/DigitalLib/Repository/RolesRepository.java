package com.example.digitalLibrary.DigitalLib.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.digitalLibrary.DigitalLib.Model.Roles;


@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

}
