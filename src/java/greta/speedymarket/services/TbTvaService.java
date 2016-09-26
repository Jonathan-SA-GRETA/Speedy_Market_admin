package greta.speedymarket.services;

import greta.speedymarket.dao.TbTvaDAO;
import greta.speedymarket.model.TbTva;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="TbTvaService")
@ViewScoped
public class TbTvaService {
    private TbTva selectedTva;
    
    public TbTva getSelectedTva() {
        return this.selectedTva;
    }
    
    public void setSelectedTva(TbTva selectedTva) {
        this.selectedTva = selectedTva;
    }
    
    public void createTva() {
        TbTva newTva = new TbTva("Nouvelle taxe", 1);
        TbTvaDAO tbTvaDAO = new TbTvaDAO();
        tbTvaDAO.save(newTva);
    }
    
    public void saveTva(TbTva tva) {
        if (tva != null) {
            TbTvaDAO tbTvaDAO = new TbTvaDAO();
            tbTvaDAO.update(tva);
        }
    }
    
    public void deleteTva(TbTva tva) {
        if (tva != null) {
            TbTvaDAO tbTvaDAO = new TbTvaDAO();
            tbTvaDAO.remove(tva);
        }
    }
    
    public List<TbTva> loadTvas() {
        TbTvaDAO tbTvaDAO = new TbTvaDAO();
        return tbTvaDAO.findAll();
    }
}