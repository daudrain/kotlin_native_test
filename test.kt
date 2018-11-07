import kotlinx.cinterop.*
import test.*

fun assertEquals(value1: Any?, value2: Any?) {
    if (value1 != value2)
        throw AssertionError("Expected $value1, got $value2")
}

fun assertNotEquals(value1: Any?, value2: Any?) {
    if (value1 == value2)
        throw AssertionError("Expected $value1, got $value2")
}

fun main(args: Array<String>) {
    
  memScoped {

    var va : SVector2D = alloc<SVector2D>()
    va.x = 2
    va.y = 3

    val vb = alloc<SVector2D>()
    vb.x = 5
    vb.y = 6

    val vc = alloc<SVector2D>()
    vc.x = 5
    vc.y = 6

    sv2d_ope_with_ptr(OPERATION.ADD, va.ptr, vb.ptr, vc.ptr)
    assertEquals(vc.x, va.x + vb.x)
    assertEquals(vc.y, va.y + vb.y)
  }
}