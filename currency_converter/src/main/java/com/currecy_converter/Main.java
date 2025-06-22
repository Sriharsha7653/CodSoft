package com.currecy_converter;
import  java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.math.BigDecimal;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response; 


public class Main {
    public static void main(String[] args) {
        Output obj= new Output();
        obj.display();
    }
}
class Output extends Frame implements ActionListener{ 
  //FRAME CONSTRAINTS
  Label l1;
  TextField t1,t2;
  Choice c1,c2;
  Button b1,b2;
  public void display(){
    //LABEL 1
    l1= new Label("CURRENCY CONVERTER");
    l1.setBounds(60,50,380,30);
    l1.setFont(new Font("Arial",Font.BOLD,30));
    //TEXTAREA 1
    t1= new TextField("ENTER THE AMOUNT");
    t1.setBounds(20, 100, 250, 40);
    t1.setFont(new Font("Arial",Font.BOLD,20));
    t1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                t1.setText("");
                //remove listener after first clear:
                t1.removeFocusListener(this);
            }
        });
    //CHOICE 1
    c1 = new Choice();
    c1.add("USD");
    c1.add("INR");
    c1.add("JPY");
    c1.add("AUD");
    c1.add("BHD");
    c1.add("MYR");
    c1.add("MXN");
    c1.setBounds(350,100,100,70);
    c1.setFont(new Font("Arial",Font.BOLD,25));
    //TEXTAREA 2
    t2= new TextField();
    t2.setBounds(20, 150, 250, 40);
    t2.setFont(new Font("Arial",Font.BOLD,20));
    //CHOICE 2
    c2 = new Choice();
    c2.add("USD");
    c2.add("INR");
    c2.add("JPY");
    c2.add("AUD");
    c2.add("BHD");
    c2.add("MYR");
    c2.add("MXN");
    c2.setBounds(350,150,100,70);
    c2.setFont(new Font("Arial",Font.BOLD,25));
    //BUTTON CONVERT
    b1= new Button("CONVERT");
    b1.setBounds(20,240 ,70 ,40);
    b1.setFont(new Font("Arial",Font.BOLD,13));
    b1.addActionListener(this);
    //BUTTON RESET
    b2= new Button("RESET");
    b2.setBounds(100,240,70,40); 
    b2.setFont(new Font("Arial",Font.BOLD,13));
    b2.addActionListener(this);
    add(l1);
    add(c1);
    add(t1);
    add(t2);
    add(c2);
    add(b1);
    add(b2);
    setSize(500,300);
    setLayout(null);
    setTitle("Currency Converter");
    setVisible(true);
   // setResizable(false);
    setBackground(new Color(173, 216, 230));
//WINDOW CLOSING PROTOCOL
    addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
  }
  //IMPLEMENTING THE ACTION
  public void actionPerformed(ActionEvent e){
   if (e.getSource() == b1) {
   try {
    String currency_Str = t1.getText();
    String convertfrom = c1.getSelectedItem();
    String convertto = c2.getSelectedItem();
    BigDecimal currency = new BigDecimal(currency_Str);
    String urlString = "https://v6.exchangerate-api.com/v6/a50421da53c0147934ee5eda/latest/" + convertfrom.toUpperCase();
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder().url(urlString).get().build();
    Response response = client.newCall(request).execute();
    String stringresponse = response.body().string();
    JSONObject jsonObject = new JSONObject(stringresponse);
    if (jsonObject.has("conversion_rates")) {
        JSONObject rates = jsonObject.getJSONObject("conversion_rates");
        BigDecimal rate = rates.getBigDecimal(convertto.toUpperCase());
        BigDecimal result = rate.multiply(currency);
        t2.setText(result.toPlainString());
    } else {
        t2.setText("Error: 'rates' not found in response.");
    }
} catch (Exception ex) {
    ex.printStackTrace();
    t2.setText("Conversion failed.");
}
}
    if(e.getSource()==b2){
        t1.setText("");
        t2.setText("");

    }
  }
}
