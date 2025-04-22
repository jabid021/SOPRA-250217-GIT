class Personne {
    nom;
    prenom;
    constructor(nom, prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
}
class Client extends Personne {
    ca;
    produits = new Array();
    constructor(nom, prenom, ca) {
        super(nom, prenom);
        this.ca = ca;
    }
}
class Fournisseur extends Personne {
    societe;
    constructor(nom, prenom, societe) {
        super(nom, prenom);
        this.societe = societe;
    }
}
class Produit {
    nom;
    prix;
    fournisseur;
    _clients = new Array();
    constructor(nom, prix, fournisseur) {
        this.nom = nom;
        this.prix = prix;
        this.fournisseur = fournisseur;
    }
    get clients() {
        return this._clients;
    }
}
let produit = new Produit("nom", 42);
console.log(produit.clients.length);
