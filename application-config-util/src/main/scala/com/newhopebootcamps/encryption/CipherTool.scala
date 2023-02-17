package com.newhopebootcamps.encryption


object CipherTool {
  val passwd = "Admin@777"
  def main(args: Array[String]): Unit = {
    test02
  }

  def test02(): Unit = {
   // val encryptobj = new EncryptionUtil
    val result = EncryptionUtil.encrypt(passwd)
    println("Encrypted = " + result)

    val pwd = EncryptionUtil.decrypt(result)
    println(s"passwd : $pwd")
  }

}
