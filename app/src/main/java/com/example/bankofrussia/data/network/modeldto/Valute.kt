package com.example.bankofrussia.data.network.modeldto

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Record")
class Valute {

    @field:Attribute(name = "Date")
    var date: String = ""

    @field:Attribute(name = "Id")
    var id: String = ""

    @field:Element(name = "Nominal")
    var nominal: String = ""

    @field:Element(name = "Value")
    var value: String = ""

}