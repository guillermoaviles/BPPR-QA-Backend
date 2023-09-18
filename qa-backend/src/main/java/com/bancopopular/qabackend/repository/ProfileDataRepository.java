package com.bancopopular.qabackend.repository;

import com.bancopopular.qabackend.model.ProfileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileDataRepository extends JpaRepository<ProfileData, String> {
}
