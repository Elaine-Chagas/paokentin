package com.paokentin.model.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.paokentin.model.entities.Fornada;
import com.paokentin.model.entities.Pao;

public class FornadaRepository {
    
    public void create(Fornada fornada) throws SQLException {
        String sql = "INSERT INTO fornada(data_hora_inicio, cod_pao) VALUES(?, ?)";
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        pstm.setLong(1, fornada.getDataHoraInicio().getTime()); // usa o Date do objeto
        pstm.setInt(2, fornada.getPao().getCodigo());
        pstm.execute();
    }
    
    public List<Fornada> readAll() throws SQLException {
        String sql = "SELECT f.codigo, f.data_hora_inicio, p.codigo AS pao_codigo, p.descricao, p.tempo_preparo, p.cor "
                   + "FROM fornada f JOIN pao p ON f.cod_pao = p.codigo "
                   + "ORDER BY f.data_hora_inicio DESC";
        
        List<Fornada> fornadas = new ArrayList<>();
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        ResultSet result = pstm.executeQuery();
        
        while(result.next()) {
            Fornada fornada = new Fornada();
            fornada.setCodigo(result.getInt("codigo"));
            fornada.setDataHoraInicio(new Date(result.getLong("data_hora_inicio")));
            
            Pao pao = new Pao();
            pao.setCodigo(result.getInt("pao_codigo"));
            pao.setDescricao(result.getString("descricao"));
            pao.setTempoPreparo(result.getInt("tempo_preparo"));
            pao.setCor(result.getString("cor"));
            
            fornada.setPao(pao);
            fornadas.add(fornada);
        }
        return fornadas;
    }
}
