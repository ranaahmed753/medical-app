package com.codecamp.medicalapp.model

class Adult {
    var designation :  String? = null;
    var image : Int? = null;
    constructor(){}
    constructor(designation : String?,image : Int?){
        this.designation = designation;
        this.image = image;
    }
}