package org.example.repository.impl;

import lombok.RequiredArgsConstructor;
import org.example.repository.CarRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static org.example.constants.SqlQuery.updateCarOwnerIdQuery;

@Repository
@RequiredArgsConstructor
public class CarRepositoryImpl implements CarRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void updateOwner(Long newOwnerId, Long carId){
        jdbcTemplate.update(updateCarOwnerIdQuery, preparedStatement -> {
            preparedStatement.setLong(1, newOwnerId);
            preparedStatement.setLong(2, carId);
        });
    }

}
