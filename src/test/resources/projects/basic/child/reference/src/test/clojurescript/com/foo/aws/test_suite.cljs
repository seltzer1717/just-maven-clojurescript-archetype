(ns com.foo.aws.test-suite
  (:require [com.foo.aws.core-test :as c]
            [cljs.test :refer-macros [deftest is testing run-tests]]))

(defn -main [args] (run-tests 'com.foo.aws.core-test))

;; (run-tests 'com.example.foo.core-test)
