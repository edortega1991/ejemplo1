/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seratic.controller.web;

/**
 *
 * @author Edinson
 */

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

public class CitasController {
  private JdbcTemplate jdbctemplate;
    public CitasController(){
    Conexion con = new Conexion();
    this.jdbctemplate=new JdbcTemplate(con.conectar());
      
}
    
    @RequestMapping("citas.htm")
   
    public ModelAndView citas(HttpServletRequest request){
        HttpSession session=  request.getSession();
        String sesion = (String)session.getAttribute("session");
        
        if(sesion == "si"){
            //String cedu=cedula1;
          // String cedu=request.getParameter("cedula1");
//ced 123: 

            String cedu1=request.getParameter("cedula1");
            String cedu2=request.getParameter("cedula2");
            String valor="2";//request.getParameter("id");
            
           
                ModelAndView mav= new ModelAndView();
                String sql= "select nombre, apellido, cedula from usuario WHERE cedula='"+cedu1+"' UNION select nombre, apellido, id from jugador WHERE id='"+cedu2+"'";
                //String sql= "select * from seratic.usuario, seratic.jugador WHERE seratic.usuario.cedula = seratic.jugador.id ";
               // String sql= "select usuario.nombre, usuario.apellido, jugador.nombre, jugador.apellido FROM seratic.usuario, seratic.jugador WHERE cedula='"+cedu1+"' OR id='"+cedu2+"'";
                //String sql ="SELECT * FROM jugador WHERE id='"+cedu1+"'" ;
                
                List usua1 = this.jdbctemplate.queryForList(sql);
                mav.addObject("usua1",usua1);
                mav.setViewName("citas");
                return mav;}
                  
        else{
            return new ModelAndView("redirect:/login.htm");
        }
   }
     
   /* public ModelAndView doc(HttpServletRequest request){
        HttpSession session=  request.getSession();
        String sesion = (String)session.getAttribute("session");
        
        if(sesion == "si"){
            //String cedu=cedula1;
          // String cedu=request.getParameter("cedula1");
//ced 123: 

            String cedu2=request.getParameter("cedula2");
            String valor="2";//request.getParameter("id");
            
           
                ModelAndView mav1= new ModelAndView();
                //String sql= "select * from usuario " "SELECT * FROM jugador WHERE id='"+cedu1+"'";
                String sql1 ="SELECT * FROM usuario WHERE cedula='"+cedu2+"'" ;
                
                List usua11 = this.jdbctemplate.queryForList(sql1);
                mav1.addObject("usua11",usua11);
                mav1.setViewName("citas");
                return mav1;
        }
                  
        else{
            return new ModelAndView("redirect:/login.htm");
        }
   } */ 
}
