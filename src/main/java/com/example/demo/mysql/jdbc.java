package com.example.demo.mysql;

import java.sql.*;
import java.util.ArrayList;

public class jdbc {
    //spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    //spring.datasource.url=jdbc:mysql://localhost:3306/spring_cache
    //spring.datasource.username=root
    //spring.datasource.password=Wangkaidong_1996
    public static void main(String[] args) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;


        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_cache", "root", "Wangkaidong_1996");
        String sql = "select * from department";
        ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        ArrayList<ArrayList<Object>> list = new ArrayList<>();

        while (resultSet.next()){
            ArrayList<Object> objects = new ArrayList<>();

            for (int i = 1; i < columnCount+1; i++) {
                Object object = resultSet.getObject(i);
                objects.add(object);
            }

            list.add(objects);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
