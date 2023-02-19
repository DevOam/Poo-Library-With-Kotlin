package bibliotheque_With_kotlin

import java.time.LocalDate
import java.util.Date

class Auteur(
    var code:Int,
    var nom:String,
    var prenom:String,
    var pseudonyme:String,
    var nationalite:Nationalite,
    var dateDeNaissance:LocalDate,
    var dateDeDeces:LocalDate) {

    init {
        if (!(nom == "^[a-zA-Z]{3,}$")&&!(prenom == "^[a-zA-Z]{3,}$")){
            throw RuntimeException("nom ou prenom oubliger de se compose des alphabets et au moins des caracters")
        }
        pseudonyme=""
        dateDeNaissance=LocalDate.parse("0000-00-00") // initialise la variable dateDeNaissance
        dateDeDeces=LocalDate.parse("0000-00-00") // initialise la variable dateDeDeces
        if (dateDeDeces.isBefore(dateDeNaissance)){
            throw RuntimeException("date de décès  doit être supérieure à la date de naissance ")
        }
    }

    override fun equals(other: Any?): Boolean {
        val o = other as Auteur
        return o.code==code
    }

    override fun toString(): String {
        return "[[$code] [$prenom] [$nom]]"
    }
    fun details():String{
        val naissance = if (dateDeNaissance == null) "Inconnue" else "Naissance : $dateDeNaissance"
        val deces = if (dateDeDeces == null) "Inconnue" else "Décès : $dateDeDeces"
        val pseudo = if (pseudonyme.isEmpty()) "" else " - $pseudonyme"
        return super.toString()+"$pseudo ( $nationalite ) [$naissance - $deces]"
    }
}