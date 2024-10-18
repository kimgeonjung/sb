package com.example.sb1007.dao;

import com.example.sb1007.dto.SimpleBbsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SimpleBbsDao implements ISimpleBbsDao{

    @Autowired
    JdbcTemplate template;

    @Override
    public List<SimpleBbsDto> listDao() {
        System.out.println("listDao()");

        String sql = "select * from simple_bbs order by id desc";
        List<SimpleBbsDto> dtos = template.query(
                sql, new BeanPropertyRowMapper<SimpleBbsDto>(SimpleBbsDto.class));

        return dtos;
    }

    @Override
    public SimpleBbsDto viewDao(String id) {
        System.out.println("viewDao()");

        String sql = "select * from simple_bbs where id = ?";
        SimpleBbsDto dto = template.queryForObject(sql, new BeanPropertyRowMapper<SimpleBbsDto>(SimpleBbsDto.class), id);

        return dto;
    }

    @Override
    public int writeDao(String writer, String title, String content) {
        System.out.println("writeDao()");

        String sql = "insert into simple_bbs(writer, title, content) values(?,?,?)";
        return template.update(sql, writer, title, content);
    }

    @Override
    public int deleteDao(String id) {
        System.out.println("deleteDao()");

        String sql = "delete from simple_bbs where id = ?";
        return template.update(sql, Integer.parseInt(id));
    }

    @Override
    public int updateDao(String id, String writer, String title, String content) {
        System.out.println("updateDao()");

        String sql = "update simple_bbs set writer = ?, title = ?, content = ? where id = ?";
        return template.update(sql, writer, title, content, Integer.parseInt(id));
    }
}
