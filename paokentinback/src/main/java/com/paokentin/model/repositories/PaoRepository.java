package com.paokentin.model.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.paokentin.model.entities.Pao;

public class PaoRepository {

    public void create(Pao pao) throws SQLException {
        String sql = "INSERT INTO pao(descricao, tempo_preparo, cor) VALUES(?, ?, ?)";
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        pstm.setString(1, pao.getDescricao());
        pstm.setInt(2, pao.getTempoPreparo());
        pstm.setString(3, pao.getCor());
        pstm.execute();
    }

    public List<Pao> readAll() throws SQLException {
        String sql = "SELECT * FROM pao";
        List<Pao> paes = new ArrayList<>();
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        ResultSet result = pstm.executeQuery();
        while (result.next()) {
            Pao pao = new Pao();
            pao.setCodigo(result.getInt("codigo"));
            pao.setDescricao(result.getString("descricao"));
            pao.setTempoPreparo(result.getInt("tempo_preparo"));
            pao.setCor(result.getString("cor"));
            paes.add(pao);
        }
        return paes;
    }
    
    public Pao read(int codigo) throws SQLException {
        String sql = "SELECT * FROM pao WHERE codigo=?";
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        pstm.setInt(1, codigo);
        ResultSet result = pstm.executeQuery();
        Pao pao = null;
        if (result.next()) {
            pao = new Pao();
            pao.setCodigo(result.getInt("codigo"));
            pao.setDescricao(result.getString("descricao"));
            pao.setTempoPreparo(result.getInt("tempo_preparo"));
            pao.setCor(result.getString("cor"));
        }
        return pao;
    }
}