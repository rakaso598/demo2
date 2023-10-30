package com.kh.demo1.domain.dao;

import com.kh.demo1.domain.dao.entity.FindidEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
@Slf4j
public class FindidDAOImpl implements FindidDAO {

  private final NamedParameterJdbcTemplate template;

  @Override
  public String findid(FindidEntity findidEntity) {

    StringBuffer sql = new StringBuffer();
    sql.append(" SELECT ID ");
    sql.append(" FROM USERINFO ");
    sql.append(" WHERE PHONENUMBER = :PHONENUMBER ");

    MapSqlParameterSource param = new MapSqlParameterSource();
    param.addValue("PHONENUMBER", findidEntity.getPHONENUMBER());

    String email = template.queryForObject(sql.toString(), param, String.class);

    return email;
  }
}
