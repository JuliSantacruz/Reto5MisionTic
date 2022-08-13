package com.mycompany.reto5.model.dao;

import com.mycompany.reto5.model.vo.CompraPorProveedor;
import com.mycompany.reto5.util.JDBCUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CompraPorProveedorDao {
    
    public ArrayList<CompraPorProveedor> rankingCompraPorProveedor() throws SQLException {
        
        ArrayList<CompraPorProveedor> respuesta = new ArrayList<CompraPorProveedor>();
        Connection conexion = JDBCUtilities.getConnection();
        try{

            String consulta = "SELECT ID_Compra, Proveedor, Constructora, Banco_Vinculado, Ciudad " +
                                "FROM Compra c INNER JOIN Proyecto p " +
                                "ON c.ID_Proyecto = p.ID_Proyecto " +
                                "WHERE Ciudad = 'Salento' AND Proveedor = 'Homecenter'";


            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            //Recorrer los registros en los VO específicos
            while(resultSet.next()){
                CompraPorProveedor asesorPorCiudad = new CompraPorProveedor();
                asesorPorCiudad.setID_Compra(resultSet.getInt("ID_Compra"));
                asesorPorCiudad.setProveedor(resultSet.getString("Proveedor"));
                asesorPorCiudad.setConstructora(resultSet.getString("Constructora"));
                asesorPorCiudad.setBanco_Vinculado(resultSet.getString("Banco_Vinculado"));
                asesorPorCiudad.setCiudad(resultSet.getString("Ciudad"));

                //Se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(asesorPorCiudad);
            }
            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando las compras por proveedor: " + e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }
        return respuesta;
    }
    
}
