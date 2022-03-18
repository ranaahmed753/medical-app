package com.codecamp.medicalapp.model

class Doctor {
    var doctorName : String? = null;
    var doctorImage : Int? = null;
    var doctorDesignation : String? = null;
    constructor(){}
    constructor(doctorName : String?,doctorImage : Int?,doctorDesignation : String?){
        this.doctorName = doctorName;
        this.doctorImage = doctorImage;
        this.doctorDesignation = doctorDesignation;
    }
}