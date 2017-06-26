/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communicationapp.Controller;

import communicationapp.DB.DBConnection;
import communicationapp.Model.ItemModel;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Shashi
 */
public class ItemController {

    //To add item to the DB
    public static int addItem(ItemModel item) throws ClassNotFoundException, SQLException {
        String sql = "insert into item values('" + item.getItemID() + "','" + item.getItemName() + "','" + item.getCat() + "','" + item.getUp() + "','" + item.getQnty() + "')";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(sql);
        return res;
    }

    //To get item IDs. Use to load in the item frame when it is start to run
    public static ArrayList<String> getItemIDs() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("Select itemID from item");
        ArrayList<String> customerIDList = new ArrayList<>();
        while (rst.next()) {
            customerIDList.add(rst.getString(1));//rst.getString("id");
        }
        return customerIDList;
    }

    //To get item code and other fileds to show in text fields
    public static ItemModel getItemCodes(String itemId) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        String sql = "Select * from item where itemID='" + itemId + "'";
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            ItemModel item = new ItemModel(itemId, rst.getString("name"), rst.getString("catagary"), rst.getDouble("unitePrice"), rst.getInt("quantity"));
            return item;
        }
        return null;
    }

    //To update item in the DB
    public static int updateItem(ItemModel item) throws ClassNotFoundException, SQLException {
        String sql = "update item set name = '" + item.getItemName() + "' , unitePrice = '" + item.getUp() + "' , quantity = '" + item.getQnty() + "' where itemID = '" + item.getItemID() + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(sql);
        return res;
    }

    //To store deleted data in a txt file
    public static ItemModel storeItem(ItemModel item) throws ClassNotFoundException, SQLException, IOException {
        String sql = "select * from item where itemID = '" + item.getItemID() + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ItemModel itm = null;
        while (rst.next()) {
            itm = new ItemModel(rst.getString("itemID"), rst.getString("name"), rst.getString("catagary"), rst.getDouble("unitePrice"), rst.getInt("quantity"));
        }
        return itm;

    }

    //To delete item from the DB
    public static int deleteItem(ItemModel item) throws ClassNotFoundException, SQLException {
        String sql = "delete from item where itemID = '" + item.getItemID() + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(sql);
        return res;
    }

    //To get item details to show in a table
    public static ArrayList<ItemModel> getItem() throws ClassNotFoundException, SQLException {
        String sql = "select * from item";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<ItemModel> itemList = new ArrayList<>();
        while (rst.next()) {
            ItemModel item = new ItemModel(rst.getString("itemID"), rst.getString("name"), rst.getString("catagary"), rst.getDouble("unitePrice"), rst.getInt("quantity"));
            itemList.add(item);
        }
        return itemList;
    }

}
