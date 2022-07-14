package Dumb51
import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class ALUSpec extends AnyFlatSpec with ChiselScalatestTester {
  behavior of "ALU"
  it should "Perform Addition" in {
    test(new ALU(8)) { dut =>
      dut.io.op.poke(Types.add)
      dut.io.acc.poke(0xAA.U)
      dut.io.aux.poke(0x11.U)
      dut.clock.step()
      dut.io.y.expect(0xBB.U)
      println("Last output value :" + dut.io.y.peek().litValue)
    }
  }
  it should "Swap Accumulator" in {
    test(new ALU(8)) { dut =>
      dut.io.op.poke(Types.swapa)
      dut.io.acc.poke(0xAB.U)
      dut.io.aux.poke(0x00.U)
      dut.clock.step()
      dut.io.y.expect(0xBA.U)
      println("Last output value :" + dut.io.y.peek().litValue)
    }
  }
  it should "Perform AND" in {
    test(new ALU(8)) { dut =>
      dut.io.op.poke(Types.andar)
      dut.io.acc.poke(0xAF.U)
      dut.io.aux.poke(0xFA.U)
      dut.clock.step()
      dut.io.y.expect(0xAA.U)
      println("Last output value :" + dut.io.y.peek().litValue)
    }
  }
  it should "Perform OR" in {
    test(new ALU(8)) { dut =>
      dut.io.op.poke(Types.orar)
      dut.io.acc.poke(0xAA.U)
      dut.io.aux.poke(0x55.U)
      dut.clock.step()
      dut.io.y.expect(0xFF.U)
      println("Last output value :" + dut.io.y.peek().litValue)
      dut.io.op.poke(Types.orar)
      dut.io.acc.poke(0xAA.U)
      dut.io.aux.poke(0xAA.U)
      dut.clock.step()
      dut.io.y.expect(0xAA.U)
      println("Last output value :" + dut.io.y.peek().litValue)
    }
  }
  it should "Perform XOR" in {
    test(new ALU(8)) { dut =>
      dut.io.op.poke(Types.xorar)
      dut.io.acc.poke(0xAA.U)
      dut.io.aux.poke(0x55.U)
      dut.clock.step()
      dut.io.y.expect(0xFF.U)
      println("Last output value :" + dut.io.y.peek().litValue)
      dut.io.op.poke(Types.xorar)
      dut.io.acc.poke(0xAA.U)
      dut.io.aux.poke(0xAA.U)
      dut.clock.step()
      dut.io.y.expect(0x00.U)
      println("Last out value :" + dut.io.y.peek().litValue)
    }
  }
  it should "Set and Clear C Bit" in {
    test(new ALU(8)) { dut =>
      dut.io.op.poke(Types.clrc)
      dut.clock.step()
      dut.io.oc.expect(0.U)
      println("Last output value :" + dut.io.oc.peek().litValue)

      dut.io.op.poke(Types.setc)
      dut.clock.step()
      dut.io.oc.expect(1.U)
      println("Last output value :" + dut.io.oc.peek().litValue)

      dut.io.op.poke(Types.clrc)
      dut.clock.step()
      dut.io.oc.expect(0.U)
      println("Last output value :" + dut.io.oc.peek().litValue)

      dut.io.op.poke(Types.setc)
      dut.clock.step()
      dut.io.oc.expect(1.U)
      println("Last output value :" + dut.io.oc.peek().litValue)

    }
  }
}
