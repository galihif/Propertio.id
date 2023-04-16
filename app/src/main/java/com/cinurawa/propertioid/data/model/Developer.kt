package com.cinurawa.propertioid.data.model

data class Developer(
    var id:Int = 0,
    var name:String ="",
    var address:String ="",
    var imageUrl:String ="",
    var projectCount:Int = 0,
){
    var phone = ""
    var projectList:List<Project> = emptyList()
}
