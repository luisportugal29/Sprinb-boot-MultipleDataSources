package com.coppel.demo.utilidades;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.coppel.demo.dtos.DataBaseDto;

public class DataBaseRowMapper implements RowMapper<DataBaseDto> {

    @Override
    public DataBaseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        DataBaseDto dataBase = new DataBaseDto();

        dataBase.setIpAddress(rs.getString("ip_address"));
        dataBase.setName(rs.getString("name"));
        dataBase.setPassword(rs.getString("password"));
        dataBase.setPortNumber(rs.getString("port_number"));
        dataBase.setUserName(rs.getString("user_name"));
        
        return dataBase;
    }
    
}
