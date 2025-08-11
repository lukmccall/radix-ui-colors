package io.github.lukmccall.colors

sealed interface RawColor {
  data class SRgb(
    val r: Float,
    val g: Float,
    val b: Float,
    val a: Float,
  ) : RawColor

  data class P3(
    val r: Float,
    val g: Float,
    val b: Float,
    val a: Float,
  ) : RawColor
}
