/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphique;
import java.util.HashMap;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author Jean-Baptiste
 */
public class PlacePsswd {
    private int positionX;
    private int positionY;
    private int heigth;
    private int width;
    private int txtTaille;
    private String txt;
    private JPasswordField passField;
    
    public PlacePsswd(int PosX, int PosY, int width, int high, String text){
    passField=new JPasswordField(8);
    
    passField.setBounds(PosX,PosY,width,high);
    
}

    /**
     * @return the positionX
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * @param positionX the positionX to set
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**
     * @return the positionY
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * @param positionY the positionY to set
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**
     * @return the heigth
     */
    public int getHeigth() {
        return heigth;
    }

    /**
     * @param heigth the heigth to set
     */
    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the txtTaille
     */
    public int getTxtTaille() {
        return txtTaille;
    }

    /**
     * @param txtTaille the txtTaille to set
     */
    public void setTxtTaille(int txtTaille) {
        this.txtTaille = txtTaille;
    }

    /**
     * @return the txt
     */
    public String getTxt() {
        return txt;
    }

    /**
     * @param txt the txt to set
     */
    public void setTxt(String txt) {
        this.txt = txt;
    }
}
