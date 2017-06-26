/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communicationapp.Model;

/**
 *
 * @author Shashi
 */
public class ItemModel {

    private String itemID;
    private String itemName;
    private String cat;
    private double up;
    private int qnty;
    private int newQnty;

    public ItemModel() {
    }

    public ItemModel(String itemID, String itemName, String cat, Double up, int qnty) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.cat = cat;
        this.up = up;
        this.qnty = qnty;
    }

    public ItemModel(String name, double up, int qnty) {
        this.itemName = name;
        this.up = up;
        this.qnty = qnty;
    }

    public ItemModel(String itemID, String itemName, String cat, double up, int qnty, int newQnty) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.cat = cat;
        this.up = up;
        this.qnty = qnty;
        this.newQnty = newQnty;
    }

    public ItemModel(String itemID) {
         this.itemID = itemID;
    }

    /**
     * @return the itemID
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * @param itemID the itemID to set
     */
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the cat
     */
    public String getCat() {
        return cat;
    }

    /**
     * @param cat the cat to set
     */
    public void setCat(String cat) {
        this.cat = cat;
    }

    /**
     * @return the up
     */
    public Double getUp() {
        return up;
    }

    /**
     * @param up the up to set
     */
    public void setUp(Double up) {
        this.up = up;
    }

    /**
     * @return the qnty
     */
    public int getQnty() {
        return qnty;
    }

    /**
     * @param qnty the qnty to set
     */
    public void setQnty(int qnty) {
        this.qnty = qnty;
    }
}
