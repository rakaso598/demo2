package com.kh.demo1.domain.dao;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FindidRowMapper implements RowMapper<String> {
  @Override
  public String mapRow(ResultSet rs, int rowNum) throws SQLException {

    String email = rs.getString("ID");

    return email;
  }
}
