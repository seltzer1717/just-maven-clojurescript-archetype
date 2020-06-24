@echo off
set clojurescript_args=%*
set clojure_args=.clojure/scripts/repl.clj %clojurescript_args%
mvn -q exec:java@clojure-bat -Dclojure.args="%clojure_args%"
