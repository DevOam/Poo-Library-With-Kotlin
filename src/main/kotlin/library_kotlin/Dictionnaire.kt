package bibliotheque_With_kotlin

class Dictionnaire( isbn:String, titre:String, private var langue: Langue, var auteures:ArrayList<Auteur> = ArrayList()):Livre(isbn, titre) {

    constructor(isbn: String, titre: String, auteur: Auteur, langue: Langue):this(isbn, titre, langue ,ArrayList()){
        auteures.add(auteur)
    }
    constructor(isbn: String, titre: String, langue: Langue):this(isbn, titre, langue, ArrayList())

    override fun toString(): String {
        return "$isbn -  $titre - $langue - $auteures"
    }
}