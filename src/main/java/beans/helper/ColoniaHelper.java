package beans.helper;

import beans.model.Colonia;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class ColoniaHelper {
    
    public List<Colonia> getColonias() {
        List<Colonia> colonias = new ArrayList<>();
        int coloniaId = 1;
        
        Colonia colonia = new Colonia(coloniaId++,"Virginia", 94294);
        colonias.add(colonia);
        
        colonia = new Colonia(coloniaId++, "Flores del Valle", 91948);
        colonias.add(colonia);
        
        colonia = new Colonia(coloniaId++, "Floresta", 91940);
        colonias.add(colonia);
        
        return colonias;
    }
    
    public int getColoniaByName(String coloniaName) {
        int coloniaId = 0;
        List<Colonia> colonias = this.getColonias();
        
        for (Colonia colonia : colonias) {
            if (colonia.getNameColonia().equals(coloniaName)) {
                coloniaId = colonia.getColoniaId();
                break;
            }
        }
        return coloniaId;
    }
    
    public int getColoniaById(int postalCode) {
        int coloniaId = 0;
        List<Colonia> colonias = this.getColonias();
        
        for (Colonia colonia : colonias) {
            if (colonia.getPostalCode() == postalCode) {
                coloniaId = colonia.getColoniaId();
                break;
            }
        }
        return coloniaId;
    }
    
    public List<SelectItem> getSelectItems() {
        List<SelectItem> selectItems = new ArrayList<>();
        List<Colonia> colonias = this.getColonias();
        
        for (Colonia colonia : colonias) {
            SelectItem selectItem = new SelectItem(colonia.getColoniaId(), colonia.getNameColonia());
            selectItems.add(selectItem);
        }
        return selectItems;
    }
}
