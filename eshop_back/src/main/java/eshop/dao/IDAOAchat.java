package eshop.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import eshop.model.Achat;

public interface IDAOAchat extends JpaRepository<Achat,Integer> {

	public List<Achat> findByDateAchatGreaterThanEqual(LocalDate dateRecherche);
}
