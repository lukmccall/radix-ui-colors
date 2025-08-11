package io.github.lukmccall.colors

data class DayNightColor(
  val light: List<RawColor> = emptyList(),
  val dark: List<RawColor> = emptyList()
)
