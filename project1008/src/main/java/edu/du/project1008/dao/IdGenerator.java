package edu.du.project1008.dao;

import edu.du.project1008.service.IdGenerationFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class IdGenerator {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int generateNextId(String sequenceName) throws IdGenerationFailedException {
            // 1. 현재 시퀀스 값을 조회하고
            int id = jdbcTemplate.queryForObject(
                    "select next_value from id_sequence where sequence_name = ? for update",
                    Integer.class, sequenceName);

            id++;

            // 2. ID 값을 증가시킨 후 업데이트
            jdbcTemplate.update(
                    "update id_sequence set next_value = ? where sequence_name = ?",
                    id, sequenceName);

            return id;

    }
}
