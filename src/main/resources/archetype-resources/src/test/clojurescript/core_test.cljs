#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
(ns ${package}.core-test
  (:require [${package}.core :as c]
            [cljs.test :refer-macros [deftest is]]))

(deftest test-numbers
  (is (= 5 (c/my-add [2 3]))))
