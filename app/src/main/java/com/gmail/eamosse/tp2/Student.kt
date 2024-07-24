package com.gmail.eamosse.tp2

import android.os.Parcel
import android.os.Parcelable

//TODO : Complete the class
data class Student(val name: String,
                   val age: Int) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString() ?: "",
        parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }
    // 1. Créer une classe Etudiant
    class Etudiant {
        // Getters et Setters
        var name: String? = null
        var code: String? = null
        var sexe: Char = 0.toChar() // M pour masculin, F pour féminin
        var adresse: String? = null

        // Autres méthodes éventuelles de la classe Etudiant
        var age: Int = 0

        // Constructeur par défaut
        constructor()

        // Constructeur avec tous les attributs
        constructor(name: String?, code: String?, sexe: Char, adresse: String?, age: Int) {
            this.name = name
            this.code = code
            this.sexe = sexe
            this.adresse = adresse
            this.age = age
        }
        ////////////////////////////////////////////////////////////////////////////////////////////
        // 2.
        val etudiants = mutableListOf<Student>()
        etudiants.add(Student("1724","Valentin","Morzine","Homme",21))
        etudiants.add(Student("4580","Aurélie","Lyon","Femme",32))
        etudiants.add(Student("6529","Elsa","Chambéry","Femme",12))
        etudiants.add(Student("0986","Patrick","Annecy","Homme",19))
        etudiants.add(Student("6591","Laura","Grenoble","Femme",45))
        etudiants.add(Student("8945","Edouard","Morzine","Homme",26))
        etudiants.add(Student("2856","Eddy","Aix les Bains","Homme",45))
        etudiants.add(Student("4458","Cloé","Annecy","Femme",21))
        etudiants.add(Student("5855","William","Ambérieux","Homme",30))
        etudiants.add(Student("6856","Jessica","Lyon","Femme",18))

// 3.
        etudiants.sortBy { it.age }
        println(etudiants)


// 5.
        println(etudiants.groupBy { it.sexe  }.get("Femme"))
        println(etudiants.groupBy { it.sexe  }.get("Homme"))

// 6.
        println(etudiants.first { it.sexe == "Homme" }.name)

        // 7.
        val etudiantsNoms = mutableListOf<String>()
        etudiants.forEach {
            etudiantsNoms.add(it.name)
        }
        println(etudiantsNoms)

// 8.
        etudiants.removeIf { it.sexe == "Femme" }
        println(etudiants)

// 9.
        println(etudiants.reversed())

// 10. 
        etudiants.clear()
        println(etudiants)
    }
}
