val projectName = "kaska"

ThisBuild / scalaVersion  := "2.13.2"
ThisBuild / scalacOptions ++= Seq(
	// the default settings from https://scastie.scala-lang.org
	"-encoding", "UTF-8",
	"-deprecation",
	"-feature",
	"-unchecked",
  /*
    scastie also has the followings in the default
      scalacOptions += "-language:higherKinds"
      addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.0" cross CrossVersion.full)
      addSbtPlugin("org.lyranthe.sbt" % "partial-unification" % "1.1.2")
  */
)
ThisBuild / version       := "0.1.0"
ThisBuild / turbo         := true // enable classLoaderLayeringStrategy
// TODO: semanticdbEnabled, semanticdbVersion, semanticdbIncludeInJar

Global / onChangedBuildSource := ReloadOnSourceChanges

// set the default project to be jvm
onLoad in Global ~= (_ andThen ("project kaska" :: _)) // TODO: this has been unneeded in other projects

lazy val kaska = crossProject(JVMPlatform, JSPlatform)
	.withoutSuffixFor(JVMPlatform)
	.settings( // shared by server and client
		name := s"${projectName}-${crossProjectPlatform.value.identifier}",
		libraryDependencies ++= Seq(
			"org.typelevel" %%% "cats-effect" % "2.1.3", // IO monad
			"com.softwaremill.sttp.client" %%% "core" % "2.1.4", // http client
			"io.circe" %%% "circe-generic" % "0.13.0", // json
			"io.circe" %%% "circe-parser" % "0.13.0",
      "org.scalatest" %% "scalatest" % "3.1.2" % Test,
		),
	)
	.jvmSettings(
		libraryDependencies ++= Seq(
			"org.scala-lang" % "scala-compiler" % scalaVersion.value,
			"com.github.pureconfig" %% "pureconfig" % "0.12.3", // configuration loading
			"org.http4s" %% "http4s-blaze-server" % "0.21.4", // http server
			"org.http4s" %% "http4s-dsl" % "0.21.4",
			"org.http4s" %% "http4s-circe" % "0.21.4",
			"com.pauldijou" %% "jwt-circe" % "4.3.0", // json web token
			"org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.13.3", // log implementation
		),
	)
	.jsSettings(
		libraryDependencies ++= Seq(
			"org.scala-js" %%% "scalajs-dom" % "1.0.0", // dom
			"io.github.cquiroz" %%% "scala-java-time" % "2.0.0", // java.time
			"io.github.cquiroz" %%% "scala-java-time-tzdb" % "2.0.0", // time zone
		),
	)
  .in(file("."))
