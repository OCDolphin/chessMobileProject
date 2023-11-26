package com.bignerdranch.android.criminalintent

class Tools {
  companion object {
    fun parsePgn(src: String) {
      val vals = HashMap<String, String>()
      val pattern = "[(.*) (.*)]"
      Regex(pattern).findAll(src).forEach {
        vals[it.groupValues[0]] = it.groupValues[1]
      }
    }
  }
}
