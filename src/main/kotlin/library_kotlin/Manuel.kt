package bibliotheque_With_kotlin

class Manuel( isbn:String, titre:String, var niveauScolaire: NiveauScolaire,var  auteures:ArrayList<Auteur>):Livre(isbn, titre) {
    constructor(isbn: String, titre: String, niveauScolaire: NiveauScolaire):this(isbn, titre, niveauScolaire, ArrayList())
    constructor(isbn: String, titre: String,auteur: Auteur, niveauScolaire: NiveauScolaire):this(isbn, titre, niveauScolaire){
        auteures.add(auteur)
    }
    override fun toString(): String {
        return "$isbn -  $titre - $niveauScolaire - $auteures"
    }
}