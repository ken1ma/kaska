// Scala.js
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.1.0")

// build both Scala/Scala.js
addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "1.0.0")

// fat jar
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.10")

// dependencyUpdates task to list dependencies that have updates
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.5.0")

//libraryDependencies ++= Seq(
//	"com.nixxcode.jvmbrotli" % "jvmbrotli" % "0.2.0",
//),
