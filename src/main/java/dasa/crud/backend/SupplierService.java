package dasa.crud.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

//CRUD listener is an interface made from vaadin, to manage directly the UI operations

@Service
@RequiredArgsConstructor
public class SupplierService implements CrudListener<Supplier> {

    private final SupplierRepository respository;


    @Override
    public Collection<Supplier> findAll() {
        return respository.findAll();
    }

    @Override
    public Supplier add(Supplier supplier) {
        return respository.save(supplier);
    }

    @Override
    public Supplier update(Supplier supplier) {
        return respository.save(supplier);
    }

    @Override
    public void delete(Supplier supplier) {
        respository.delete(supplier);
    }
}
