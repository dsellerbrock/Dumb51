
package Dumb51
import chisel3._
import chisel3.util._
object Types {
  val nop :: movi :: movr :: add :: andar :: orar :: xorar :: swapa :: clrc :: setc :: Nil
  = Enum (10)
}
class ALU(size: Int) extends Module {
  val io = IO(new Bundle{
  val op = Input(UInt(size.W))
  val aux = Input(UInt(size.W))
  val acc = Input(UInt(size.W))
  val ic  = Input(UInt(1.W))
  val oc = Output(UInt(1.W))
  val z = Output(UInt(1.W))
  val y = Output(UInt(size.W))
})

  val op = io.op
  val aux = io.aux
  val acc = io.acc
  val c = io.ic
  val res = WireDefault (0.U(size.W))
  val resc = WireDefault (0.U(size.W))
  val resz = WireDefault (0.U(size.W))

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
    is(Types.andar){
      res:= aux & acc
    }
    is(Types.orar){
      res:= aux | acc
    }
    is(Types.xorar){
      res:= aux ^ acc
    }
    is(Types.swapa){
      res:= Cat(acc(3,0),acc(7,4))
    }
    is(Types.clrc){
      resc:= 0.U
    }
    is(Types.setc){
      resc:= 1.U
    }

  }
  when (res =/= 0.U){
    resz:=0.U
  } .otherwise{
    resz:=1.U
  }
  io.y := res
  io.oc := resc
  io.z := resz
}
