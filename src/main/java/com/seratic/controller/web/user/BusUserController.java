/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seratic.controller.web.user;

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
public class BusUserController {
    private JdbcTemplate jdbctemplate;
    
    public BusUserController(){
    Conexion con= new Conexion();
    this.jdbctemplate=new JdbcTemplate(con.conectar());
    }
    
   @RequestMapping("buscarUser.htm")
   
    public ModelAndView busUser(HttpServletRequest request){
   HttpSession session=  request.getSession();
        String sesion = (String)session.getAttribute("session");
        
        if(sesion == "si"){
            //String cedu=cedula1;
           String cedu=request.getParameter("cedula1");
//ced 123: 
            String cedu1="2";
            ModelAndView mav= new ModelAndView();
            //String sql= "select * from usuario ";
            String sql = "SELECT * FROM usuario WHERE cedula='"+cedu+"'";
            List usua = this.jdbctemplate.queryForList(sql);
            mav.addObject("usua",usua);
            mav.setViewName("usuario/buscarUser");
            return mav;
        
        }
        
        else{
            return new ModelAndView("redirect:/login.htm");
        }
   }
}
