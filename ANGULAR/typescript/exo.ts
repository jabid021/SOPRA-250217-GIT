class Personne {
    constructor(private nom: string, private prenom: string) { }
}

class Client extends Personne {
    private produits: Array<Produit> = new Array<Produit>();
    
    constructor(nom: string, prenom: string, private ca: number) {
        super(nom, prenom);
    }
}

class Fournisseur extends Personne {
    constructor(nom: string, prenom: string, private societe: string) {
        super(nom, prenom);
    }
}

class Produit {
    private _clients: Array<Client> = new Array<Client>();
    
    constructor(private nom: string, private prix: number, private fournisseur?: Fournisseur) { }

    public get clients(): Array<Client> {
        return this._clients;
    }
}

let produit: Produit = new Produit("nom", 42);
console.log(produit.clients.length);
