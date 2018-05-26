//
// Copyright (C) 2009-2018 Lightbend Inc. <https://www.lightbend.com>
//

//#build.sbt
libraryDependencies += "com.typesafe.play" % "play-enhancer" % "1.2.2"
//#build.sbt

//#disable-project
lazy val nonEnhancedProject = (project in file("non-enhanced"))
  .disablePlugins(PlayEnhancer)
//#disable-project

//#disable-enhancement
playEnhancerEnabled := false
//#disable-enhancement

//#select-generate
sources in (Compile, playEnhancerGenerateAccessors) := {
  ((javaSource in Compile).value / "models" ** "*.java").get
}
//#select-generate
