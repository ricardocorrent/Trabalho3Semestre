/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rcorrent.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rcorrent
 */
public class DataUtils {
    
    private static final SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

    private static final SimpleDateFormat formatDateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    private static final SimpleDateFormat formatDateTimeYY = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

    private static final SimpleDateFormat formatDateTimeYYYY = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    public static String dateToString(Date date) {
        try {
            return formatDate.format(date);
        } catch (Exception ex) {
            return null;
        }
    }
    
    
    public static Date stringToDate(String date) {
        try {
            return formatDate.parse(date);
        } catch (ParseException ex) {
            return null;
        }
    }

      
    public static String dateTimeToString(Date date) {
        try {
            return formatDateTime.format(date);
        } catch (Exception ex) {
            return null;
        }
    }
    
    
      public static Date stringToDateTime(String date) {
        try {
            return formatDateTime.parse(date);
        } catch (ParseException ex) {
            return null;
        }
    }
      
    public static Date stringToDateTimeYY(String date){
        try {
            return formatDateTimeYY.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
    
    public static String dateTimeToStringYY(Date date) {
        try {
            return formatDateTimeYY.format(date);
        } catch (Exception ex) {
            return null;
        }
    }
    
    public static Date stringToDateTimeYYYY(String date){
        try {
            return formatDateTimeYYYY.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
    
    public static String dateTimeToStringYYYY(Date date) {
        try {
            return formatDateTimeYYYY.format(date);
        } catch (Exception ex) {
            return null;
        }
    }
    
}
