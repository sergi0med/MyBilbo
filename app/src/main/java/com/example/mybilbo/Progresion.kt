package com.example.mybilbo

enum class Progresion {
    estandar,
    avanzado}

fun getProgresionList(): List<Progresion> {
    val recurrenceList = mutableListOf<Progresion>()
    recurrenceList.add(Progresion.estandar)
    recurrenceList.add(Progresion.avanzado)

    return recurrenceList
}