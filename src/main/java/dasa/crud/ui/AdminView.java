package dasa.crud.ui;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import dasa.crud.backend.Supplier;
import dasa.crud.backend.SupplierService;
import org.vaadin.crudui.crud.impl.GridCrud;

import javax.annotation.security.RolesAllowed;

@Route("admin")
@RolesAllowed("ADMIN")
public class AdminView extends VerticalLayout {

    public AdminView(SupplierService service){
        var crud = new GridCrud<>(Supplier.class, service);
        crud.getGrid().setColumns("name","address","telephone");
        crud.getCrudFormFactory().setVisibleProperties("name","address","telephone");
        add(
            new H1("Admin view"),crud
        );
    }

}
