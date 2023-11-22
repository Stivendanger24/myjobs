package controllers.auth;

import models.SesionStatus;
import models.config.Conexion;
import models.tablasAuxiliares.InicioDeSesion;
import views.aspirantes.MenuMiperfil.MenuMiPerfil;
import views.aspirantes.RegistrarDatos.RegistrarTodosDatos;

public class LoginController {
    private SesionStatus userSession;
    RegistrarTodosDatos nuevoUsuario = new RegistrarTodosDatos();
    private InicioDeSesion user = new InicioDeSesion();

    public LoginController() {
        userSession = SesionStatus.getInstance();
    }

    public boolean login(String username, String password) {
        if (user.checkCredentials(username, password)) {
            userSession.login(user.getId(),user.getName(),user.getId_roll(),user.getRegister());
            if (userSession.getRegister() == 0 && "aspirante".equals(userSession.getId_roll())){
                nuevoUsuario.getPrimerPanel().start();
            }else {
                MenuMiPerfil menu = new MenuMiPerfil();
                menu.start();
            }
            return true;
        } else {
            return false;
        }
    }

    public void logout() {
        // Llamamos al método logout() de UserSession
        userSession.logout();
    }

    public String getUsername() {
        // Llamamos al método getUsername() de UserSession
        return userSession.getUsername();
    }
}
