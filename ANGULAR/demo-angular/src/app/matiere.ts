export class Matiere {
    constructor(private _id: number, private _libelle: string) { }

    public get id(): number {
        return this._id;
    }

    public set id(value: number) {
        this._id = value;
    }

    public get libelle(): string {
        return this._libelle;
    }

    public set libelle(value: string) {
        this._libelle = value;
    }
}
