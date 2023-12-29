package modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
 
    //Crear conexión con la DB
    Connection conexion;
    
    public UserDAO() {
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }
    
    //Método listarUsuarios()
    public List<UserVO> listarUsuarios(){
        
        PreparedStatement ps;
        ResultSet rs;
        
        List<UserVO> listaUsuarios = new ArrayList<>();
        
        try {
            //Crear consulta
            String sql = "SELECT * FROM user";
            ps = conexion.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while (rs.next()){
                
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String contrasena = rs.getString("contrasena");
                
                UserVO usuario = new UserVO(id, nombre, email, contrasena);
                
                listaUsuarios.add(usuario);
                
            }
            System.err.println(listaUsuarios);
            //Retorna la lista
            return listaUsuarios;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
        
    }
    
    //Mostrar usuario individual
    public UserVO mostrarUsuario(int _id){
        
        PreparedStatement ps;
        ResultSet rs;
        UserVO usuario = null;
        
        try {
            //Crear consulta
            String sql = "SELECT * FROM user WHERE id=?";
            ps = conexion.prepareStatement(sql);
            
            //pasar parámetro del id
            ps.setInt(1, _id);
            //Ejecutar consulta y se guarda en la tabla ResulSet
            rs = ps.executeQuery();
            
            while (rs.next()){
                
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String contrasena = rs.getString("contrasena");
                
                usuario = new UserVO(id, nombre, email, contrasena);
                
            }
            return usuario;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
        
    }

    //Insertar registros
    public boolean insertar(UserVO user){
        
        PreparedStatement ps;
        
        try {
            //Crear consulta
            String consulta = "INSERT INTO user (nombre, email, contrasena) VALUES (?,?,?)";
            //Guardamos un objeto PreparedStatement para enviar la consulta
            ps = conexion.prepareStatement(consulta);
            
            //Pasar datos al modelo User
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getContrasena());
            
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
        
    }
    
    //Actualizar registro
    public boolean actualizar(UserVO user){
        
        PreparedStatement ps;
        
        try {
            //Crear consulta
            String sql = "UPDATE user SET nombre=?, email=?, contrasena=? WHERE id=?";
            ps = conexion.prepareStatement(sql);
            
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getContrasena());
            ps.setInt(4, user.getId());
            
            ps.execute();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
        
    }
    
    //Elminar registro recibiendo el id
    public boolean eliminar(int _id){
        
        PreparedStatement ps;
        
        try {
            //Crear consulta
            String sql = "DELETE FROM user WHERE id=?";
            ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, _id);
            
            ps.execute();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
        
    }
    
}
