package io.github.lukmccall.colors

class RadixPallet<T>(
  val isDark: Boolean,
  val colorConverter: (color: RawColor) -> T
) {
  inner class SelectedColor(private val radixColor: RadixColor) {
    inner class SelectedColorVariant(private val dayNightColor: DayNightColor) {
      private val correctColors
        get() = if (isDark) {
          dayNightColor.dark
        } else {
          dayNightColor.light
        }

      operator fun get(scale: Scale): T = colorConverter(
        correctColors[scale.value]
      )

      operator fun get(index: Int): T = colorConverter(
        correctColors[index]
      )

      val `1`
        get() = this[Scale.`1`]

      val `2`
        get() = this[Scale.`2`]

      val `3`
        get() = this[Scale.`3`]

      val `4`
        get() = this[Scale.`4`]

      val `5`
        get() = this[Scale.`5`]

      val `6`
        get() = this[Scale.`6`]

      val `7`
        get() = this[Scale.`7`]

      val `8`
        get() = this[Scale.`8`]

      val `9`
        get() = this[Scale.`8`]

      val `10`
        get() = this[Scale.`10`]

      val `11`
        get() = this[Scale.`11`]

      val `12`
        get() = this[Scale.`12`]
    }

    val solid: SelectedColorVariant
      get() = SelectedColorVariant(radixColor.solid)

    val alpha: SelectedColorVariant
      get() = SelectedColorVariant(radixColor.alpha)

    val p3: SelectedColorVariant
      get() = SelectedColorVariant(radixColor.p3)

    val p3Alpha
      get() = SelectedColorVariant(radixColor.p3Alpha)

    operator fun get(scale: Scale): T = solid[scale]
    operator fun get(index: Int): T = solid[index]

    val `1`
      get() = this[Scale.`1`]

    val `2`
      get() = this[Scale.`2`]

    val `3`
      get() = this[Scale.`3`]

    val `4`
      get() = this[Scale.`4`]

    val `5`
      get() = this[Scale.`5`]

    val `6`
      get() = this[Scale.`6`]

    val `7`
      get() = this[Scale.`7`]

    val `8`
      get() = this[Scale.`8`]

    val `9`
      get() = this[Scale.`8`]

    val `10`
      get() = this[Scale.`10`]

    val `11`
      get() = this[Scale.`11`]

    val `12`
      get() = this[Scale.`12`]
  }

  operator fun get(color: RadixColor): SelectedColor {
    return SelectedColor(color)
  }
}
