package com.seratic.controller.web.player;

import com.seratic.models.Conexion;
import com.seratic.models.Jugador;
import com.seratic.models.Util;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Edinson
 */
@Controller
@RequestMapping("addplayer.htm")
public class AddPlayerController {
    private JdbcTemplate jdbctemplate;
  
    public AddPlayerController(){
    Conexion con= new Conexion();
    this.jdbctemplate= new JdbcTemplate(con.conectar());
    }
    
    @GetMapping
    public ModelAndView player (HttpServletRequest hsr){
        HttpSession session= hsr.getSession();
        String sesion=(String)session.getAttribute("session");
    
        if(sesion=="si"){
            ModelAndView mav = new ModelAndView();
            mav.setViewName("jugador/addplayer");  
            mav.addObject("jugador", new Jugador());
            return mav;//new ModelAndView();
    }
    else
    {
            return new ModelAndView("redirect:/login.htm");
    }
       
    }
    
 @PostMapping
 public ModelAndView addplayer (@ModelAttribute("jugador") Jugador j,
                                BindingResult result){

                Date fecha = new Date();
                //String pass = Util.Encriptar(j.getClave());//Encrypto la contraseña SessionStatus status
                this.jdbctemplate.update(
                        "INSERT INTO jugador (nombre,apellido,club) VALUES (?,?,?)",
                        j.getNombre(),j.getApellido(),j.getClub());
            return new ModelAndView("redirect:/player.htm");        
    }
}
