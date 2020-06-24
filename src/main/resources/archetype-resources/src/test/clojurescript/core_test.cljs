(ns cloud.seltzer1717.clojure.godsplan.core-test
  (:require [cloud.seltzer1717.clojure.godsplan.core :as c]
            [cljs.test :refer-macros [deftest is testing run-tests]]
            [cljs.nodejs :as nodejs]))

(nodejs/enable-util-print!)

(deftest test-numbers
  (is (= 5 (c/my-add [2 3]))))
