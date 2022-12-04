package com.example.bankofrussia.data.network.modeldto

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "ValCurs")
class ValuteContainer {

    @field:Attribute(name = "ID")
    var id: String = ""

    @field:Attribute(name = "DateRange1")
    var dateRange1: String = ""

    @field:Attribute(name = "DateRange2")
    var dateRange2: String = ""

    @field:Attribute(name = "name")
    var name: String = ""

    @field:ElementList(name ="Record",inline = true)
    var valute: ArrayList<Valute> = arrayListOf()
}