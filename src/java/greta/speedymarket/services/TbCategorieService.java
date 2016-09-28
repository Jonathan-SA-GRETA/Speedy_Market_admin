/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greta.speedymarket.services;

import greta.speedymarket.dao.TbCategorieDAO;
import greta.speedymarket.model.TbCategorie;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean(name = "TbCategorieService")
@ViewScoped
public class TbCategorieService {

    private TbCategorie selectedCategorie;
    private TreeNode root;
    private TreeNode selectedNode;

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public TbCategorie getSelectedNodeCategorie() {
        return (TbCategorie) getSelectedNode().getData();
    }
    
    public TbCategorie getSelectedCategorie() {
        return this.selectedCategorie;
    }

    public void setSelectedCategorie(TbCategorie selectedCategorie) {
        this.selectedCategorie = selectedCategorie;
    }

    public void createCategorie() {
        TbCategorie newCategorie = new TbCategorie("Nouveau categorie");
        TbCategorieDAO tbCategorieDAO = new TbCategorieDAO();
        tbCategorieDAO.save(newCategorie);
    }

    public void saveCategorie(TbCategorie categorie) {
        System.out.println("saveCategorie");
        if (categorie != null) {
            TbCategorieDAO tbCategorieDAO = new TbCategorieDAO();
            tbCategorieDAO.update(categorie);
        }
    }

    public void deleteCategorie(TbCategorie categorie) {
        if (categorie != null) {
            TbCategorieDAO tbCategorieDAO = new TbCategorieDAO();
            tbCategorieDAO.remove(categorie);
        }
    }

    public List<TbCategorie> loadCategories() {
        TbCategorieDAO tbCategorieDAO = new TbCategorieDAO();
        return tbCategorieDAO.findAll();
    }

    public List<TbCategorie> loadCategorieParentes() {
        List<TbCategorie> categories = new ArrayList<>();

        for (TbCategorie category : loadCategories()) {
            if (category.getTbCategorie() == null) {
                categories.add(category);
            }
        }
        return categories;
    }

    public TreeNode getRoot() {
        root = new DefaultTreeNode();

        for (TbCategorie categorie : loadCategorieParentes()) {
            TreeNode node = new DefaultTreeNode(categorie, root);

            createCategorieTreeNode(categorie, node);

        }
        return root;
    }

    private void createCategorieTreeNode(TbCategorie categorie, TreeNode nodeParent) {
        for (Object category : categorie.getTbCategories()) {
            TbCategorie cat = (TbCategorie) category;
            TreeNode node = new DefaultTreeNode(category, nodeParent);

            createCategorieTreeNode(cat, node);
        }
    }

    

    
}
