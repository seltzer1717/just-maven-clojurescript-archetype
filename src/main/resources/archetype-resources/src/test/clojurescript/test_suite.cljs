(ns cloud.seltzer1717.clojure.godsplan.test-suite
  (:require [cloud.seltzer1717.clojure.godsplan.core-test :as c]
            [cljs.test :refer-macros [run-tests]]
            [cljs.nodejs :as nodejs]))

(nodejs/enable-util-print!)

(cljs.test/run-tests 'cloud.seltzer1717.clojure.godsplan.core-test)