/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greta.speedymarket.services;

import greta.speedymarket.dao.TbClientDAO;
import greta.speedymarket.model.TbClient;
import greta.speedymarket.model.TbPersonne;
import greta.speedymarket.dao.TbPersonneDAO;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "TbClientService")
@ViewScoped
public class TbClientService {

    private TbClient selectedClient;

    public TbClient getSelectedClient() {
        return this.selectedClient;

    }

    public void setSelectedClient(TbClient selectedClient) {
        this.selectedClient = selectedClient;
    }

    public void createClient() {
        TbClient newClient = (TbClient) new TbClient(new TbPersonne("Nouveau", "Client", "", 0, "mail@mail.org", "0000"));
        TbClientDAO tbClientDAO = new TbClientDAO();
        tbClientDAO.save(newClient);
    }

    public void saveClient(TbClient client) {
        if (client != null) {
            TbClientDAO tbClientDAO = new TbClientDAO();
            tbClientDAO.update(client);
        }
    }

    public void deleteClient(TbClient client) {
        if (client != null) {
            int idPersonne = client.getIdPersonne();
            TbClientDAO tbClientDAO = new TbClientDAO();
            tbClientDAO.remove(client);
            TbPersonneDAO tbPersonneDAO = new TbPersonneDAO();
            TbPersonne p = tbPersonneDAO.findById(idPersonne);
            tbPersonneDAO.remove(p);
        }
    }

    public List<TbClient> loadClients() {
        TbClientDAO tbClientDAO = new TbClientDAO();
        return tbClientDAO.findAll();
    }
}
