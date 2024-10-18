package com.practice.p1012_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class P10122Application {

    public static void main(String[] args) {
        SpringApplication.run(P10122Application.class, args);
    }

/*
데이터베이스 테이블
create table t_board (
board_idx int primary key auto_increment,
category varchar(30) not null,
title varchar(300) not null,
contents text not null,
hit_cnt int not null default '0',
created_datetime datetime not null,
creator_id varchar(50) not null,
updated_datetime datetime,
updater_id varchar(50),
deleted_yn char(1) not null default 'n');
*/
}
