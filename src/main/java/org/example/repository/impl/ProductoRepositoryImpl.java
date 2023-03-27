package org.example.repository.impl;

import org.example.entities.Producto;
import org.example.repository.Repository;
import org.example.singleton.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryImpl implements Repository<Producto> {
    private Connection conexionDB;
    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }
    private Producto createProduct(ResultSet resultSet) throws SQLException {
        Producto producto = new Producto();
        producto.setId(resultSet.getLong("id"));
        producto.setNombre(resultSet.getString("nombre"));
        producto.setPrecio(resultSet.getDouble("precio"));
        producto.setFechaRegistro(resultSet.getDate("fecha_registro").toLocalDate());
        return producto;
    }


    @Override
    public List<Producto> getList() {
        List<Producto>productosList=new ArrayList<>();
        try(Statement statement=getConnection().createStatement();
        ResultSet resultSet=statement.executeQuery(
            """
                SELECT  * FROM  Producto;
                """
        ))
        {
            while (resultSet.next()){
                Producto producto=createProduct(resultSet);
                productosList.add(producto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productosList;
    }

    @Override
    public Producto getById(Long id) {
        Producto producto=null;
        try (PreparedStatement preparedStatement=getConnection()
                .prepareStatement(" SELECT  * FROM  Producto where id=?")
        ) {
            preparedStatement.setLong(1,id);
            ResultSet resultSet=preparedStatement.getResultSet();
            if (resultSet.next()){
                producto=createProduct(resultSet);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return producto;
    }

    @Override
    public void save(Producto producto) {

    }

    @Override
    public void delateById(Long id) {

    }

}
