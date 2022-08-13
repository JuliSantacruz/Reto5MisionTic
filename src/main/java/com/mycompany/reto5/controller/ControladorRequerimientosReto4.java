package com.mycompany.reto5.controller;

import com.mycompany.reto5.model.dao.AsesorPorCiudadDao;
import com.mycompany.reto5.model.dao.CompraPorProveedorDao;
import com.mycompany.reto5.model.dao.ProyectosCasaCampestreDao;
import com.mycompany.reto5.model.vo.AsesorPorCiudad;
import com.mycompany.reto5.model.vo.CompraPorProveedor;
import com.mycompany.reto5.model.vo.ProyectosCasaCampestre;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorRequerimientosReto4 {       
    
    private final CompraPorProveedorDao compraPorProveedorDao;
    private final ProyectosCasaCampestreDao proyectosCasaCampestreDao;
    private final AsesorPorCiudadDao asesorPorCiudadDao;
    
    public ControladorRequerimientosReto4(){
        this.compraPorProveedorDao = new CompraPorProveedorDao();
        this.asesorPorCiudadDao = new AsesorPorCiudadDao();
        this.proyectosCasaCampestreDao = new ProyectosCasaCampestreDao();

    }

    public ArrayList<AsesorPorCiudad> consultarAsesorPorCiudad() throws SQLException {
        return this.asesorPorCiudadDao.rankingAsesorPorCiudad();
    }
    
    public ArrayList<CompraPorProveedor> consultarCompraPorProveedor() throws SQLException {
        return this.compraPorProveedorDao.rankingCompraPorProveedor();
    }

    public ArrayList<ProyectosCasaCampestre> consultarProyectosCasaCampestre() throws SQLException {
        return this.proyectosCasaCampestreDao.rankingProyectosCasaCampestres();
    }

}
