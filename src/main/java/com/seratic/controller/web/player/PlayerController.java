
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
public class PlayerController {

    private JdbcTemplate jdbctemplate;
    
    public PlayerController(){
        Conexion con= new Conexion();
        this.jdbctemplate=new JdbcTemplate(con.conectar());
    }

    @RequestMapping("player.htm")
    
    public ModelAndView player(HttpServletRequest hsr){
        HttpSession session=hsr.getSession();
        String sesion= (String)session.getAttribute("session");
        
        if(sesion=="si"){
            ModelAndView mav= new ModelAndView();
            String sql= "select * from jugador";
            List jugadores = this.jdbctemplate.queryForList(sql);
            mav.addObject("jugadores",jugadores);
            mav.setViewName("jugador/player");
            return mav;
        }
        else{
            return new ModelAndView("redirect:/login.htm");
        }
    
    }
}