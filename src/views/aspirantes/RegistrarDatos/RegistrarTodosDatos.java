package views.aspirantes.RegistrarDatos;

import controllers.extras.ExtrasController;
import models.tablasAuxiliares.TipoDeIdentificacion;


public class RegistrarTodosDatos {
    PrimerPanel primerPanel = new PrimerPanel();
    SegundoPanel segundoPanel = new SegundoPanel();
    TercelPanel tercelPanel = new TercelPanel();

    public PrimerPanel getPrimerPanel() {
        primerPanel.CrearListaTipoidentificacion();
        return primerPanel;
    }
    public SegundoPanel getSegundoPanel() {
        segundoPanel.CrearListaAreaProfesional();
        return segundoPanel;
    }
    public TercelPanel getTercelPanel() {

        tercelPanel.CrearListaNivelEstudios();
        tercelPanel.CrearListaAreaLaboral();
        tercelPanel.CrearListaTipoPerfilProfesional();
        tercelPanel.tablaAreaDeInteresLaboral();
        return tercelPanel;
    }
}
