package com.myapp.egghuntlist.data

data class Facts(
    val fact: String
)

val factList = listOf(
    Facts("The tradition of decorating eggs dates back to ancient civilizations, including Egyptians and Persians."),
    Facts("The largest Easter egg ever made was over 7 meters tall and weighed over 3,600 kilograms."),
    Facts("In some cultures, eggs are painted red to symbolize the blood of Christ."),
    Facts("The Easter Bunny originated from German folklore, where it was believed to lay eggs for children to find."),
    Facts("In 1970, the first-ever Easter egg hunt was held on the White House lawn."),
    Facts("Cadbury's Crème Egg is one of the most popular Easter treats, with over 200 million sold each year."),
    Facts("TIn Finland, Easter is celebrated with a tradition where children dress up as witches and go door-to-door for treats."),
    Facts("The word \"Easter\" is believed to be derived from \"Eostre,\" a pagan goddess of spring and fertility."),
    Facts("In Ukraine, the art of decorating eggs is known as \"Pysanky,\" which involves intricate designs using wax and dye."),
    Facts("The tradition of the Easter egg hunt is thought to symbolize the search for the tomb of Jesus."),
    Facts("The practice of giving chocolate eggs started in the 19th century in Europe."),
    Facts("The world's most expensive chocolate egg, made by a luxury chocolatier, was valued at over €144,000."),
    Facts("In Greece, red eggs are cracked against each other in a game called \"tsougrisma,\" symbolizing the resurrection."),
    Facts("In some cultures, Easter eggs are hidden in gardens and parks for children to find, promoting outdoor activity."),
)

fun String.toQuoted(): String{
    return "\"${this}\""
}















