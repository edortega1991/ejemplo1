package com.seratic.controller.web.user;

import com.seratic.models.Conexion;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Edinson
 */
@Controller
@RequestMapping("deleteuser.htm")
public class DeleteUserController {
   private JdbcTemplate jdbctemplate;
   
   public DeleteUserController(){
     Conexion con=new Conexion();
     this.jdbctemplate=new JdbcTemplate(con.conectar());
   }
   
   @GetMapping
   public ModelAndView deleteuser(HttpServletRequest request){
   String id =request.getParameter("id");
   this.jdbctemplate.update("DELETE FROM usuario " + "WHERE " + "cedula=?",id);        
       
   return new ModelAndView("redirect:/user.htm");
   }
}
