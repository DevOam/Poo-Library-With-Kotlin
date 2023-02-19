package bibliotheque_With_kotlin

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.util.TreeMap
import java.util.Vector

class Bibliotheque(private val ficher: String) : Livre() {
    constructor() : this(ficher = "bibliothèque.bin")

    private val liste: TreeMap<Livre, Int> = TreeMap()
    val file: File = File("fichier.txt")

    init {
        if (!file.exists()) {
            throw RuntimeException("file exists")
        }
        compteur++
    }

    fun nombresDeLivres(): Int {
        return compteur
    }

    fun existe(o: String): Livre? {
        for (c in liste.keys) {
            if (c.isbn == o) {
                return c
            }
        }
        return null

    }

    fun ajouterLivre(o: Livre?) {
        if (o == null || liste.keys.contains(o)) {
            throw RuntimeException("Livre est null or livre existe déjà dans la liste.")
        } else {
            liste.put(o, 0)
        }
    }

    fun achetrerLivre(isbn: String, quantite: Int) {
        val l: Livre = Livre()
        var found = true
        if (quantite < 0) {
            for ((c, v) in liste) {
                if (isbn == l.isbn) {
                    liste.put(c, v + quantite)
                    found = false
                }
            }
            if (found) {
                throw RuntimeException("Livre n’existe pas")
            }
        } else {
            throw RuntimeException("La quantité à ajouter est négative ou nulle.")
        }

    }

    fun vendreLivre(isbn: String, quantite: Int) {
        val l: Livre = Livre()
        var found = true
        if (quantite < 0) {
            for ((c, v) in liste) {
                if (v < quantite) {
                    throw RuntimeException("La quantité en stock est insuffisante")
                }
                if (isbn == l.isbn) {
                    liste.put(c, v + quantite)
                    found = false
                }
            }
            if (found) {
                throw RuntimeException("Livre n’existe pas")
            }
        } else {
            throw RuntimeException("La quantité à ajouter est négative ou nulle.")
        }
    }

    fun supprimer(isbn: String) {
        var found = true
        for (l: Livre in liste.keys) {
            if (l.isbn == isbn) {
                liste.remove(l)
                found = false
            }

        }
        if (found) {
            throw RuntimeException("Livre n’existe pas")
        }
    }

    fun supprimer(l: Livre?) {
        if (l == null) {
            throw RuntimeException("livre est null")
        } else {
            if (liste.contains(l)) {
                liste.remove(l)
            } else {
                throw RuntimeException("Livre n’existe pas")
            }
        }
    }

    fun livre(): ArrayList<Livre> {
        val livers = ArrayList<Livre>()
        for (liv: Livre in liste.keys) {
            //On vérifie si la clé courante est une instance de la classe Livre
            if (liv.javaClass == Livre::class.java) {
                livers.add(liv)
            }
        }
        return livers
    }

    fun manuels(): ArrayList<Manuel> {
        val manuels = ArrayList<Manuel>()
        for (liv:Livre in liste.keys){
            if (liv.javaClass==Manuel::class.java){
                manuels.add(liv as Manuel)
            }
        }
        return manuels
    }

    fun dictionnaires():ArrayList<Dictionnaire>{
        val dictionnaires=ArrayList<Dictionnaire>()
        for (liv :Livre in liste.keys){
            if (liv.javaClass==Dictionnaire::class.java){
                dictionnaires.add(liv as Dictionnaire)
            }
        }
        return dictionnaires
    }

    fun auteurs():ArrayList<Auteur>{
        val auteursSansDoublans = ArrayList<Auteur>()
        for (liv:Livre in liste.keys){
            for (aut:Auteur in liv.auteurs){
                if (!(auteursSansDoublans.contains(aut))){
                    auteursSansDoublans.add(aut)
                }
            }
        }
        return auteursSansDoublans
    }

    fun livreD1Auteur(auteur: Auteur): ArrayList<Livre> {
        val livresAuteur =  ArrayList<Livre>()
        for (liv :Livre in liste.keys){
            for (aut:Auteur in liv.auteurs){
                if (aut==auteur){
                    livresAuteur.add(liv)
                }
            }
        }
        return livresAuteur
    }

    fun sauvegarder() {
        val fileWriter:FileWriter= FileWriter(file)
        val bufferWriter : BufferedWriter = BufferedWriter(fileWriter)
        bufferWriter.write(liste.toString())
        bufferWriter.close()
    }



    companion object {
        var compteur = 0
    }
}