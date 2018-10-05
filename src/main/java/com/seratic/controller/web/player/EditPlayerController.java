package com.seratic.controller.web.player;
import com.seratic.models.Conexion;
import com.seratic.models.Jugador;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("editplayer.htm")
public class EditPlayerController {
    private JdbcTemplate jdbctemplate;
 
    public EditPlayerController() {
        Conexion con= new Conexion();
        this.jdbctemplate= new JdbcTemplate(con.conectar());
        
    }
    
    @GetMapping
    public ModelAndView editplayer(HttpServletRequest request){
        HttpSession session= request.getSession();
        String sesion = (String)session.getAttribute("session");
    
        if(sesion == "si"){
            ModelAndView mav = new ModelAndView();
            int id=Integer.parseInt(request.getParameter("id"));
            Jugador datos = this.selectPlayer(id);
            //String desencriptado = Util.Desencriptar(datos.getClave());//desencripto la contraseña
            mav.setViewName("jugador/editplayer");
            mav.addObject("jugador",new Jugador(id,datos.getNombre(),datos.getApellido(),datos.getClub()));
            return mav;  
        }
        else
        {
         return new ModelAndView("redirect:/login.htm");
        }
    }
    
    @PostMapping
    public ModelAndView editplayer(@ModelAttribute("jugador") Jugador j,
                                BindingResult result,
                                SessionStatus status,
                                HttpServletRequest request){
            //String pass = Util.Encriptar(u.getClave());   
            int id=Integer.parseInt(request.getParameter("id"));
            this.jdbctemplate.update(
                    "UPDATE jugador "
                    + "SET nombre=?,"
                    + "apellido=?,"
                    + "club=?"                             
                    + "WHERE "
                    + "id=?",                    
                    j.getNombre(), j.getApellido(),j.getClub(),id);;
            return new ModelAndView("redirect:/player.htm");
        
    }
    
public Jugador selectPlayer(int id){
        final Jugador player = new Jugador();
        String sql = "SELECT * FROM jugador WHERE id='"+id+"'";
        return (Jugador) jdbctemplate.query(sql, new ResultSetExtractor<Jugador>(){
            public Jugador extractData(ResultSet rs) throws SQLException, DataAccessException{
                if(rs.next()){
                    //player.setCedula(rs.getString("cedula"));
                    player.setNombre(rs.getString("nombre"));
                    player.setApellido(rs.getString("apellido"));
                    player.setClub(rs.getString("club"));
                }
                return player;
            }
        }  );
}
}