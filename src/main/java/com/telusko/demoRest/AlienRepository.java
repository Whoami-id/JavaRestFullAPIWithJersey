
package com.telusko.demoRest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository {

    List<Alien> aliens;

    Connection con = null;

    public AlienRepository() {
        final String url = "jdbc:mysql://localhost:3306/restdb";
        final String userName = "root";
        final String password = "mysqlroot";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, password);
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
    }

    // public AlienRepository() {
    // aliens = new ArrayList<>();
    //
    // final Alien a1 = new Alien();
    // a1.setId(101);
    // a1.setName("Navin");
    // a1.setPoints(60);
    //
    // final Alien a2 = new Alien();
    // a2.setId(102);
    // a2.setName("Ariat");
    // a2.setPoints(70);
    //
    // aliens.add(a1);
    // aliens.add(a2);
    // }

    public List<Alien> getAliens() {
        final List<Alien> list = new ArrayList<>();
        final String sql = "SELECT * FROM alien";

        try {
            final Statement st = con.createStatement();
            final ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                final Alien a = new Alien();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setPoints(rs.getInt(3));
                list.add(a);
            }
        } catch (final SQLException ex) {
            ex.printStackTrace();
        }
        return list;

    }

    // public Alien getAlien(final int id) {
    // for (final Alien a : aliens) {
    // if (a.getId() == id) {
    // return a;
    // }
    // }
    // return new Alien();
    // }
    //
    // public void create(final Alien a1) {
    // aliens.add(a1);
    // }

    public Alien getAlien(final int id) {
        final Alien a = new Alien();
        final String sql = "SELECT * FROM alien WHERE id=" + id;

        try {
            final Statement st = con.createStatement();
            final ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setPoints(rs.getInt(3));
            }
        } catch (final SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    public void create(final Alien al) {
        final String sql = "INSERT INTO alien VALUES (?,?,?)";
        try {
            final PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, al.getId());
            st.setString(2, al.getName());
            st.setInt(3, al.getPoints());
            st.executeUpdate();
        } catch (final SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(final Alien al) {
        final String sql = "UPDATE alien SET name=?, points=? WHERE id=?";
        try {
            final PreparedStatement st = con.prepareStatement(sql);
            st.setInt(3, al.getId());
            st.setString(1, al.getName());
            st.setInt(2, al.getPoints());
            st.executeUpdate();
        } catch (final SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(final int id) {
        final String sql = "DELETE FROM alien WHERE id=?";
        try {
            final PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (final SQLException ex) {
            ex.printStackTrace();
        }

    }

}
