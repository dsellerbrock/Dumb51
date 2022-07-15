package Dumb51.shared
/*
+-------------+--------------+
|00000000         | nop      |
|01110100-dddddddd| MOV A,#D |
|11101nnn         | MOV A,RN |
|11111nnn         | MOV RN,A |
|00110100-dddddddd| ADDC A,#D|
|00111nnn         | ADDC A,RN|
|01011nnn         | ANL A,RN |
|01001nnn         | ORL A,RN |
|01101nnn         | XRL A,RN |
|11000100         | SWAP A   |
|11000011         | CLR C    |
|11010011         | SETB C   |
|10000000-rrrrrrrr| SJMP REL |
|01100000-rrrrrrrr| JZ REL   |
+-------------+--------------+
 */


object Constants {
  val NOP    = 0x00
  val MOVAI  = 0x74
  val MOVAR  = 0xE8
  val MOVRA  = 0xF8
  val ADDCI  = 0x34
  val ADDCR  = 0x38
  val ANDAR  = 0x58
  val ORAR   = 0x48
  val XORAR  = 0x68
  val SWAPA  = 0xC4
  val CLRC   = 0xC3
  val SETC   = 0xD3
  val SJMP   = 0x80
  val JZ     = 0x60
}