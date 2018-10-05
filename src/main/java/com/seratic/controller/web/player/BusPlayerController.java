/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.seratic.controller.web.player;

import com.seratic.models.Conexion;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Edinson
 */
@Controller

public class BusPlayerController {
  private JdbcTemplate jdbctemplate;
    public BusPlayerController(){
    Conexion con = new Conexion();
    this.jdbctemplate=new JdbcTemplate(con.conectar());
      
}
    
    @RequestMapping("buscarPlayer.htm")
   
    public ModelAndView busPlayer(HttpServletRequest request){
   HttpSession session=  request.getSession();
        String sesion = (String)session.getAttribute("session");
        
        if(sesion == "si"){
            //String cedu=cedula1;
          // String cedu=request.getParameter("cedula1");
//ced 123: 

            String cedu1=request.getParameter("cedula1");
            String valor="2";//request.getParameter("id");
            
            if(valor=="2"){
                ModelAndView mav= new ModelAndView();
                //String sql= "select * from usuario ";
                String sql = "SELECT * FROM jugador WHERE id='"+cedu1+"'";
                List usua1 = this.jdbctemplate.queryForList(sql);
                mav.addObject("usua1",usua1);
                mav.setViewName("jugador/buscarPlayer");
                return mav;}
            else
            {
                ModelAndView mav= new ModelAndView();
                //String sql= "select * from usuario ";
                String sql = "SELECT * FROM jugador";
                List usua1 = this.jdbctemplate.queryForList(sql);
                mav.addObject("usua1",usua1);
                mav.setViewName("jugador/buscarPlayer");
                return mav;
            }
        
        }
        
        else{
            return new ModelAndView("redirect:/login.htm");
        }
   }
    
    /*public ModelAndView busUsuario(HttpServletRequest request){
   HttpSession session=  request.getSession();
        String sesion = (String)session.getAttribute("session");
        
        if(sesion == "si"){
            //String cedu=cedula1;
          // String cedu=request.getParameter("cedula1");
//ced 123: 

            String cedu2=request.getParameter("cedula2");
            String valor="2";//request.getParameter("id");
            
            if(valor=="2"){
                ModelAndView mav1= new ModelAndView();
                //String sql= "select * from usuario ";
                String sql1 = "SELECT * FROM usuario WHERE cedula='"+cedu2+"'";
                List usua11 = this.jdbctemplate.queryForList(sql1);
                mav1.addObject("usua11",usua11);
                mav1.setViewName("jugador/buscarPlayer");
                return mav1;}
            else
            {
                ModelAndView mav= new ModelAndView();
                //String sql= "select * from usuario ";
                String sql = "SELECT * FROM jugador";
                List usua1 = this.jdbctemplate.queryForList(sql);
                mav.addObject("usua1",usua1);
                mav.setViewName("jugador/buscarPlayer");
                return mav;
            }
        
        }
        
        else{
            return new ModelAndView("redirect:/login.htm");
        }
   }*/
}
