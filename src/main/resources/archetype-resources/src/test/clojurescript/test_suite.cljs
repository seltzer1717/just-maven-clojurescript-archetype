#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
(ns ${package}.test-suite
  (:require [${package}.core-test :as c]
            [cljs.test :refer-macros [run-tests]]))

(run-tests 'cloud.seltzer1717.clojure.godsplan.core-test)