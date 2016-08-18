val annotatorLibrary = Map[String, (ModuleID, String)]()

name := "jiggTest"

scalaVersion := "2.11.7"

version := "0.1"

fork in run := true

parallelExecution in Test := false

crossPaths := false

mainClass in assembly := Some("jiggTest.Test")

javacOptions ++= Seq("-Xlint:all", "-source", "1.6", "-target", "1.6")

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies ++= Seq(
  "com.novocode" % "junit-interface" % "0.10-M4" % "test->default",
  "org.scalactic" %% "scalactic" % "2.2.6",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.scala-lang.modules" %% "scala-xml" % "1.0.5",
  "org.scala-lang" % "scala-reflect" % "2.11.7",
  "com.ibm.icu" % "icu4j" % "56.1",
  "org.scalanlp" % "breeze-config_2.10" % "0.9.1",
  "org.json4s" %% "json4s-jackson" % "3.3.0",
  "com.github.mynlp" % "jigg" % "0.6.1"
)

libraryDependencies ++= (
  stanfordCoreNLPDependencies
    ++ kuromojiDependencies
    ++ berkeleyParserDependencies)

val stanfordCoreNLPDependencies = Seq(
  "org.slf4j" % "slf4j-api" % "1.7.20", 
  "org.slf4j" % "slf4j-simple" % "1.7.6",
  "edu.stanford.nlp" % "stanford-corenlp" % "3.6.0"
)

val kuromojiDependencies = Seq(
  "com.atilika.kuromoji" % "kuromoji-ipadic" % "0.9.0",
  "com.atilika.kuromoji" % "kuromoji-jumandic" % "0.9.0",
  "com.atilika.kuromoji" % "kuromoji-unidic" % "0.9.0"
)

val berkeleyParserDependencies = Seq(
  "edu.berkeley.nlp" % "berkeleyparser" % "r32"
)

libraryDependencies ++= annotatorLibrary.map { case (k, v) => v._1 }.toSeq

lazy val root = (project in file(".")).
  enablePlugins(BuildInfoPlugin).
  settings(
    buildInfoKeys := annotatorLibrary.map { case (k, v) =>
      BuildInfoKey.action("ann_" + k)(v._2)
    }.toSeq,
    buildInfoPackage := "jigg.pipeline.annotator"
  )
