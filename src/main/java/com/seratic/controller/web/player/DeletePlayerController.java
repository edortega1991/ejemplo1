package com.seratic.controller.web.player;

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
@RequestMapping("deleteplayer.htm")
public class DeletePlayerController {
    private JdbcTemplate jdbctemplate;
    
    public DeletePlayerController(){
        Conexion con= new Conexion();
        this.jdbctemplate= new JdbcTemplate(con.conectar());
    
    }
    
 @GetMapping
 public ModelAndView deleteplayer(HttpServletRequest request)
 {
   int id=Integer.parseInt(request.getParameter("id"));
   this.jdbctemplate.update(
                        "DELETE FROM jugador " 
                        + "WHERE " 
                        + "id=?",id);        
       
   return new ModelAndView("redirect:/player.htm");
 }
}
