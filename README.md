# Dumb51

A re-implementation of the **WIMP51** 8051 core in **Chisel 3**. Only the ALU is functional so far; the decoder and top level are stubs.

| | |
|---|---|
| Language | Scala 2.13 / Chisel 3.5.3 |
| Build | sbt (or mill via `build.sc`) |
| Tests | ChiselTest + ScalaTest |
| Status | Archived (2022-07) |
| License | BSD-2-Clause |

## Layout

| Path | What |
|---|---|
| `src/main/scala/Dumb51/ALU.scala` | Parameterized ALU: move, add, AND, OR, XOR, swap, clear/set carry |
| `src/main/scala/Dumb51/Decode.scala`, `Dumb51.scala` | Placeholders for the decoder and top level |
| `src/main/scala/Dumb51/shared/Constants.scala` | Opcode constants |
| `src/test/scala/Dumb51/ALUSpec.scala` | ALU tests |

## Run

```sh
sbt test
```
