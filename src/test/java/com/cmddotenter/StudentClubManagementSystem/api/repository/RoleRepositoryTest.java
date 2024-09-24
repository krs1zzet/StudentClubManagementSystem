package com.cmddotenter.StudentClubManagementSystem.api.repository;

import com.cmddotenter.StudentClubManagementSystem.entity.Role;
import com.cmddotenter.StudentClubManagementSystem.repo.RoleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoleRepositoryTest {
    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void RoleRepository_SaveAll_ReturnSavedRole(){
        Role role = Role.builder()
                .name("test role")
                .build();

        Role savedRole = roleRepository.save(role);
        Assertions.assertThat(savedRole).isNotNull();
        Assertions.assertThat(savedRole).isNotNull();
    }

    @Test
    public void RoleRepository_FindById_ReturnUser(){
        Role role = Role.builder()
                .name("test role")
                .build();

        Role savedRole = roleRepository.save(role);
        Role foundRole = roleRepository.findById(savedRole.getId()).orElse(null);

        Assertions.assertThat(roleRepository.findById(savedRole.getId())).isNotNull();
        assert foundRole != null;
        Assertions.assertThat(savedRole.getId()).isEqualTo(foundRole.getId());
    }



    @Test
    public void RoleRepository_DeleteById_ReturnNull(){
        Role role = Role.builder()
                .name("test role")
                .build();

        Role savedRole = roleRepository.save(role);
        roleRepository.deleteById(savedRole.getId());
        Role foundRole = roleRepository.findById(savedRole.getId()).orElse(null);

        Assertions.assertThat(foundRole).isNull();
    }

    @Test
    public void RoleRepository_FindAllRoles_ReturnAllRoles(){
        Role role = Role.builder()
                .name("test role")
                .build();
        Role role2 = Role.builder()
                .name("test role2")
                .build();
        roleRepository.save(role);
        roleRepository.save(role2);

        //act
        List<Role> roleList = roleRepository.findAll();

        // assert
        Assertions.assertThat(roleList).hasSizeGreaterThan(1);


    }


}
