package com.gamer.repository;

import com.gamer.domain.GamerEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


@EnableScan
public interface GamerRepository extends CrudRepository<GamerEntity, String> {

    List<GamerEntity> findByEmailAddress(final String emailAddress);

}
