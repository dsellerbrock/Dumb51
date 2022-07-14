
package Dumb51
import chisel3._
import chisel3.util._
class ALU(size: Int) extends Module {
  object Types {
    val nop :: movi :: movr :: add :: andar :: orar :: xorar :: swapa :: clrc :: setc :: Nil
    = Enum (12)
  }
  val io = IO(new Bundle{
  val op = Input(UInt(size.W))
  val aux = Input(SInt(size.W))
  val acc = Input(SInt(size.W))
  val ic  = Input(SInt(1.W))
  val oc = Output(UInt(1.W))
  val z = Output(UInt(1.W))
  val y = Output(SInt(size.W))
})

  val op = io.op
  val aux = io.aux
  val acc = io.acc
  val c = io.ic
  val res = WireDefault (0.S(size.W))
  val resc = WireDefault (0.S(size.W))
  val resz = WireDefault (0.S(size.W))

  switch(op) {
    is(Types.movi) {
      res := aux
    }
    is(Types.movr) {
      res := acc
    }
    is(Types.add) {
      res := aux + acc + c
    }
  }
  when (res =/= 0.S){
    resz:=0.S
  } .otherwise{
    resz:=1.S
  }
  io.y := res
  io.oc := resc
  io.z := resz
}