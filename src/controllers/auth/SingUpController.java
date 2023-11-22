package controllers.auth;

import models.SesionStatus;
import models.tablasAuxiliares.InicioDeSesion;
import views.aspirantes.RegistrarDatos.RegistrarTodosDatos;
import views.templates.reject.RejectView;

public class SingUpController {
    private SesionStatus userSession;
    private InicioDeSesion user = new InicioDeSesion();
    RegistrarTodosDatos nuevoUsuario = new RegistrarTodosDatos();

    public SingUpController() {
        userSession = SesionStatus.getInstance();
    }

    public boolean register(String name, String email, String password, String id_roll) {
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || id_roll.isEmpty()) {
            RejectView mensaje = new RejectView("Todos los campos son requeridos");
            mensaje.showRejectWindow();
            return false;
        }

        if (user.checkExist(email)) {
            user.createUser(name, email, password, id_roll);
            user.checkCredentials(email, password);
            userSession.login(user.getId(), user.getName(), user.getId_roll(), user.getRegister());
            if (userSession.getRegister() == 0 && "aspirante".equals(userSession.getId_roll())) {
                nuevoUsuario.getPrimerPanel().start();
            }
            return true;
        } else {
            RejectView mensaje = new RejectView("El correo ya se encuentra registrado. Por favor, intenta con otro.");
            mensaje.showRejectWindow();
            return false;
        }
    }
}
