package com.paokentin.model.entities;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Fornada {

    private int codigo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date dataHoraInicio;

    private Pao pao;

    public Fornada() {
        this.dataHoraInicio = new Date();
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public Date getDataHoraInicio() { return dataHoraInicio; }
    public void setDataHoraInicio(Date dataHoraInicio) { this.dataHoraInicio = dataHoraInicio; }

    public Pao getPao() { return pao; }
    public void setPao(Pao pao) { this.pao = pao; }
}
