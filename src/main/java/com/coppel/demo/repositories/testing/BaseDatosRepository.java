package com.coppel.demo.repositories.testing;

import java.sql.Connection;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.coppel.demo.connection.JdbcManager;
import com.coppel.demo.dtos.DataBaseDto;
import com.coppel.demo.utilidades.DataBaseRowMapper;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BaseDatosRepository {

    private final JdbcManager jdbcManager;

    public List<DataBaseDto> getDataBases(Integer dataBaseId) {
        List<DataBaseDto> dataBases = new ArrayList<>();
        JdbcTemplate jdbcTemplate = jdbcManager.getJdbcTemplate(dataBaseId);
        DataSource dt = jdbcTemplate.getDataSource();
    
        try {
        
    
        String script = "CREATE OR REPLACE FUNCTION obtener_nombres_casosdeprueba_por_prueba(id_prueba INTEGER) RETURNS TEXT AS $$\r\n" + //
                        "DECLARE\r\n" + //
                        "    result TEXT;\r\n" + //
                        "BEGIN\r\n" + //
                        "    -- Realizar la consulta y asignar el resultado a la variable result\r\n" + //
                        "    SELECT nom_casoprueba INTO result\r\n" + //
                        "    FROM cat_casosdeprueba\r\n" + //
                        "    WHERE idu_casoprueba = id_prueba;\r\n" + //
                        "\r\n" + //
                        "    -- Devolver el resultado como una cadena\r\n" + //
                        "    RETURN result;\r\n" + //
                        "END;\r\n" + //
                        "$$ LANGUAGE plpgsql;";
        jdbcTemplate.execute(script);
        int idCasoPrueba = 1;
        String functionExecution = "SELECT obtener_nombres_casosdeprueba_por_prueba(?)";
      
        Object[] args = { idCasoPrueba};
        int[] argTypes = {Types.INTEGER};
        String resultado = jdbcTemplate.queryForObject(functionExecution, args, argTypes, String.class);
        System.out.println(resultado);
        jdbcTemplate.execute("DROP FUNCTION obtener_nombres_casosdeprueba_por_prueba");


        String sql = "SELECT ip_address, name, user_name, port_number, password FROM database";
        dataBases = jdbcTemplate.query(sql, new DataBaseRowMapper());

        Connection connection = jdbcTemplate.getDataSource().getConnection();
        connection.close();
        System.out.println(connection.isClosed());

        
      
        } catch(Exception exception) {
            exception.printStackTrace();
        }
  
        return dataBases;
    }
    
}
