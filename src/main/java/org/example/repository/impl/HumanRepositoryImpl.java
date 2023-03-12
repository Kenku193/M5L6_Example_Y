package org.example.repository.impl;

import lombok.RequiredArgsConstructor;
import org.example.entity.Human;
import org.example.repository.HumanRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;


import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.example.constants.SqlQuery.*;

@Repository
@RequiredArgsConstructor
public class HumanRepositoryImpl implements HumanRepository {

    private final JdbcTemplate jdbcTemplate;


    @Override
    public List<Human> findAll() {
        return Optional.ofNullable(
                jdbcTemplate.query(selectAllHumansQuery, JdbcTemplateMapperFactory
                                                            .newInstance()
                                                            .addKeys("id")
                                                            .newResultSetExtractor(Human.class)))
                .orElse(Collections.emptyList());
    }

    @Override
    public Optional<Human> findById(Long id) {
        return Objects.requireNonNull(
                jdbcTemplate.query(selectHumanByIdQuery, ps -> ps.setLong(1, id),
                        JdbcTemplateMapperFactory
                                .newInstance()
                                .addKeys("id")
                                .newResultSetExtractor(Human.class)))
                .stream().findFirst();
    }

    @Override
    public List<Human> findByName(String name) {
        return jdbcTemplate.query(
                con -> con.prepareStatement(selectHumanByNameQuery),
                ps -> ps.setString(1, name),
                JdbcTemplateMapperFactory
                        .newInstance()
                        .addKeys("id")
                        .newResultSetExtractor(Human.class));
    }

    @Override
    public Long count() {
        return jdbcTemplate.queryForObject(countQuery, Long.class);
    }

    @Override
    public Human save(Human human) {
        return null;
    }

    @Override
    public Human updateBalance(Human human, BigDecimal count) {
        jdbcTemplate.update("UPDATE humans SET balance = ? WHERE id = ?",
                ps -> {
                    ps.setBigDecimal(1, count);
                    ps.setLong(2, human.getId());
                });
        return human;
    }
}
