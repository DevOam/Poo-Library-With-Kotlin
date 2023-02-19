package bibliotheque_With_kotlin

import java.util.ArrayList

open class Livre(var isbn:String="", var titre:String="", var auteurs:ArrayList<Auteur> = ArrayList<Auteur>()):Comparable {
    init {
        if ((isbn.isNullOrEmpty())||!(isbn.length==13)||!(isbn.length<10)){
            throw RuntimeException("isbn is empty or not equals 10 or 13")
            }
        if (titre.isNullOrEmpty()){
            throw RuntimeException("titre is empty")
        }
    }
    fun ajoutAuteur(o:Auteur){
        if (auteurs.contains(o)||o==null){
            throw RuntimeException("l’auteur est null ou appartient déjà à la liste")
        }
        auteurs.add(o)
    }
    private fun auteursToString():String{
        var mssj = ""
        if (auteurs.isEmpty()){
            mssj="Aucun"
        }else{
            mssj=auteurs.joinToString("-"){ it.toString() }
        }
        return mssj
    }

    override fun toString(): String {
        return "isbn : $isbn   titre : $titre  auteurs :\n\t$auteurs"
    }

    override fun equals(other: Any?): Boolean {
        val o = other as Livre
        return o.isbn==isbn
    }
    fun s(d:Livre):Boolean{
        return d==Livre()
    }

    override fun compareTo(o:Livre): Boolean {
        return o.titre==titre
    }

}