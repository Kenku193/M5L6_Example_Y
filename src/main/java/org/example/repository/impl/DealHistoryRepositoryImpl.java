package org.example.repository.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.example.entity.Deal;
import org.example.repository.DealHistoryRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

import static org.example.constants.SqlQuery.findMaxDealHistoryIdQuery;
import static org.example.constants.SqlQuery.insertDealQuery;

@Repository
@RequiredArgsConstructor
public class DealHistoryRepositoryImpl implements DealHistoryRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Deal save(@NonNull Deal deal){
        if (Objects.isNull(deal.getId())){
            jdbcTemplate.update(insertDealQuery, deal.getDate(), deal.getStatus().toString(), deal.getBuyerId(), deal.getSellerId(), deal.getCarId());
            var id = jdbcTemplate.queryForObject(findMaxDealHistoryIdQuery, Long.class);
            deal.setId(id);
        } else {
            jdbcTemplate.update(insertDealQuery, deal.getDate(), deal.getStatus().toString(), deal.getBuyerId(), deal.getSellerId(), deal.getCarId());
        }
        return deal;
    }

}
