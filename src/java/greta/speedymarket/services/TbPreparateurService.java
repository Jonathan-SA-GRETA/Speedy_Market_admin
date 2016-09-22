/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greta.speedymarket.services;

import greta.speedymarket.dao.TbPreparateurDAO;
import greta.speedymarket.model.TbPersonne;
import greta.speedymarket.model.TbPreparateur;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name="TbPreparateurService")
@ViewScoped
public class TbPreparateurService {
private TbPreparateur selectedPreparateur;

public TbPreparateur getSelectedPreparateur() {
return this.selectedPreparateur;

}

public void setSelectedPreparateur(TbPreparateur selectedPreparateur) {
this.selectedPreparateur = selectedPreparateur;
}

public void createPreparateur() {
TbPreparateur newPreparateur = new TbPreparateur(new TbPersonne("","","",0,"",""));
TbPreparateurDAO tbPreparateurDAO = new TbPreparateurDAO();
tbPreparateurDAO.save(newPreparateur);
}



public void savePreparateur(TbPreparateur preparateur) {
if (preparateur != null) {
TbPreparateurDAO tbPreparateurDAO = new TbPreparateurDAO();
tbPreparateurDAO.update(preparateur);
}
}



public void deletePreparateur(TbPreparateur preparateur) {
if (preparateur != null) {
TbPreparateurDAO tbPreparateurDAO = new TbPreparateurDAO();
tbPreparateurDAO.remove(preparateur);
}
}



public List<TbPreparateur> loadPreparateurs() {
TbPreparateurDAO tbPreparateurDAO = new TbPreparateurDAO();
return tbPreparateurDAO.findAll();
}
}