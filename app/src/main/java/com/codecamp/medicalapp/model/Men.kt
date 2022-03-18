package com.codecamp.medicalapp.model

class Men {
    var designation :  String? = null;
    var image : Int? = null;
    constructor(){}
    constructor(designation : String?,image : Int?){
        this.designation = designation;
        this.image = image;
    }
}