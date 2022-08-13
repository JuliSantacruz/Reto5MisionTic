package com.mycompany.reto5.model.dao;

import com.mycompany.reto5.model.vo.ProyectosCasaCampestre;
import com.mycompany.reto5.util.JDBCUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProyectosCasaCampestreDao {
    
    public ArrayList<ProyectosCasaCampestre> rankingProyectosCasaCampestres() throws SQLException {
        
        ArrayList<ProyectosCasaCampestre> respuesta = new ArrayList<ProyectosCasaCampestre>();
        Connection conexion = JDBCUtilities.getConnection();
        try{

            String consulta =   "SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad " + 
                                "FROM Proyecto " +
                                "WHERE Ciudad IN ('Santa Marta', 'Cartagena', 'Barranquilla') " +
                                "AND Clasificacion = 'Casa Campestre'";


            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                ProyectosCasaCampestre proyectoCasaCampestre = new ProyectosCasaCampestre();
                proyectoCasaCampestre.setID_Proyecto(resultSet.getInt("ID_Proyecto"));
                proyectoCasaCampestre.setConstructora(resultSet.getString("Constructora"));
                proyectoCasaCampestre.setNumero_Habitaciones(resultSet.getDouble("Numero_Habitaciones"));
                proyectoCasaCampestre.setCiudad(resultSet.getString("Ciudad"));

                //Se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(proyectoCasaCampestre);
            }
                
            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando los proyectos: " + e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }
        return respuesta;
    }
        
}
