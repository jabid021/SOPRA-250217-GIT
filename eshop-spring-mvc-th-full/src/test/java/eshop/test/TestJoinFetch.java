package eshop.test;

public class TestJoinFetch {

	public static void main(String[] args) {
		
		/*DAOProduit daoProduit = Singleton.getInstance().getDaoProduit();
		DAOAchat daoAchat = Singleton.getInstance().getDaoAchat();
		DAOPersonne daoPersonne = Singleton.getInstance().getDaoPersonne();
		
		
		Adresse  adresse1 = new Adresse("6","rue rougemont","75009","Paris");
		Adresse  adresse2 = new Adresse("1","rue de chez moi","00001","ma ville");
		
		Client client1 = new Client("Abid","Jordan",30,LocalDate.parse("1993-05-01"),adresse1);
		Client client2 = new Client("Doe","John",30,LocalDate.parse("1993-05-01"),adresse2);
		Fournisseur fournisseur1 = new Fournisseur("Abid","Charly","AJC Ingenierie");
		Fournisseur fournisseur2 = new Fournisseur("Titi","Toto","AJC Ingenierie");
		
		
		client1 = (Client) daoPersonne.save(client1);
		client2 = (Client) daoPersonne.save(client2);
		fournisseur1 = (Fournisseur) daoPersonne.save(fournisseur1);
		fournisseur2 = (Fournisseur) daoPersonne.save(fournisseur2);
		
		
		Produit produit1 = new Produit("Formation SQL",1200,fournisseur1);
		Produit produit2 = new Produit("Formation Algo",1049.99,fournisseur1);
		
		produit1 = daoProduit.save(produit1);
		produit2 = daoProduit.save(produit2);
		
		
		
		
		Achat achat1 = new Achat(LocalDate.now(),1,client1,produit2);
		Achat achat2 = new Achat(LocalDate.now(),2,client1,produit1);
		
		achat1 = daoAchat.save(achat1);
		daoAchat.save(achat2);
		
		
		//----------------BLOC 1
		System.out.println("Liste de tous les fournisseurs :");
		List<Fournisseur> allFournisseurs = daoPersonne.findAllFournisseur();
		for(Fournisseur f : allFournisseurs) 
		{
			System.out.println(f);
		}
		
		
		System.out.println("Liste de tous les clients :");
		List<Client> allClients = daoPersonne.findAllClient();
		for(Client c : allClients) 
		{
			System.out.println(c);
		}
		
		System.out.println("Produits dont le libelle est Formation Algo ");
		System.out.println(daoProduit.findByLib("Formation Algo"));
		
		System.out.println("Produit contenant un S : ");
		System.out.println("--"+daoProduit.findByLibelleContaining("s")+"---");
		System.out.println("Produit contenant le mot formation : ");
		System.out.println("--"+daoProduit.findByLibelleContaining("formation")+"---");

		//----------------BLOC 2
		
		Fournisseur fournisseurAvecProduit = daoPersonne.findByIdWithStock (fournisseur1.getId());
		
		System.out.println("Voici les produits du fournisseur "+fournisseurAvecProduit.getNom());
		for(Produit p : fournisseurAvecProduit.getStock()) 
		{
			System.out.println(p);
		}
		
		Fournisseur fournisseurSansProduit = daoPersonne.findByIdWithStock(fournisseur2.getId());
		
		if(fournisseurSansProduit.getStock().isEmpty()) 
		{
			System.out.println("Le 2e fournisseur n'a pas encore de produit dans son stock");
		}
		else 
		{
			System.out.println("ERROR, CE FOURNISSEUR N'A POURTANT PAS DE PRODUIT");
		}
		
		
		
		//----------------BLOC 3
		
		Produit produitAvecVentes = daoProduit.findByIdWithVentes(produit1.getId());
		
		System.out.println("Le produit "+produitAvecVentes.getLibelle()+" a ete vendu "+produitAvecVentes.getVentes().size()+" fois");
		
		
		
		//----------------BLOC 4
		
		System.out.println("----------Voici le recap de vos achats : -------------");
		
		Client clientAvecAchats = daoPersonne.findByIdWithAchats(client1.getId());
		
		System.out.println(clientAvecAchats.getPrenom()+", vous avez achete : ");
		for(Achat a : clientAvecAchats.getAchats()) 
		{
			System.out.println(a.getProduit().getLibelle());
		}
		
		
		Client clientSansAchats = daoPersonne.findByIdWithAchats(client2.getId());
		
		if(clientSansAchats.getAchats().isEmpty()) 
		{
			System.out.println(clientSansAchats.getNom()+" n'a rien achete !");
		}
		else 
		{
			System.out.println("ERROR, le client 2 n'a RIEN ACHETE POURTANT !");
		}*/
		
	}

}
